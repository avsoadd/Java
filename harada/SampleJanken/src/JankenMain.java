import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import define.HandType;
import define.ResultType;
import user.CPU;
import user.Player;
import user.User;

public class JankenMain {

	private User mPlayer;
	private User[] mCPUList;
	private int mGameCnt;

	public JankenMain() {
		mPlayer = null;
		mCPUList = null;
		mGameCnt = -1;
	}

	public static void main(String[] args)
	{
		JankenMain jMain = new JankenMain();
		jMain.prepare();
		jMain.game();
	}

	// じゃんけん前の準備
	public void prepare() {
		while(0 > mGameCnt) {
			Scanner scan = new Scanner(System.in);
			try {
				if(null == mPlayer) {
					// ユーザ情報を入力
					System.out.println("ユーザ名を入力してください：");
					String name = scan.nextLine();
					mPlayer = new Player(name);
				}

				if(null == mCPUList) {
					// CPUの数を入力
					System.out.println("CPU数を入力してください：");
					int cpuNum = scan.nextInt();
					mCPUList = new CPU[cpuNum];
					for(int index = 0; index < mCPUList.length; index++) {
						mCPUList[index] = new CPU();
					}
				}

				// 勝負回数を入力
				System.out.println("勝負回数を入力してください：");
				mGameCnt = scan.nextInt();
			} catch(Exception e) {
				System.out.println("入力値が正しくありません。再度入力してください");
				e.printStackTrace();
			} finally {
			}
		}
	}


	// ゲーム実行
	public void game()
	{
		boolean isDraw = false;
		for(int cnt = 0; cnt < mGameCnt; cnt++) {
			// ユーザの手を入力
			inputPlayerHandType();
			// cpuの手を入力
			inputCpuHandType();
			// あいこ判定
			isDraw = checkDraw();
			// 勝敗更新
			updateResultType(isDraw);
			// 勝敗表示
			showResult();
		}
	}

	// ユーザの手を入力
	private void inputPlayerHandType() {
		HandType handType = HandType.Invalid;
		while(HandType.Invalid.equals(handType))
		{
			Scanner scan = new Scanner(System.in);
			try {
				// 手を入力
				System.out.println("手を入力してください（1:グー,2：チョキ,3：パー）：");
				handType = handType.cast(scan.nextInt());
				mPlayer.setHandType(handType);
			} catch(Exception e) {
				System.out.println("入力値が正しくありません。再度入力してください");
				e.printStackTrace();
			} finally {
			}
		}
	}

	// CPUの手を入力
	private void inputCpuHandType() {
		HandType handType = HandType.Invalid;
		for(int index = 0; index < mCPUList.length; index++)
		{
			Random rand = new Random();
			handType = handType.cast((rand.nextInt(3)+1));
			mCPUList[index].setHandType(handType);
		}
	}

	// あいこ判定（全員の手が同じ）
	private boolean checkDraw() {
		// 全員同じ手か確認
		boolean isDraw = checkSameDraw();
		// 2人以上の場合は全員の手が異なるかも確認
		if(!isDraw && (2 < (mCPUList.length+1))) {
			isDraw = checkWholeHandTypeDraw();
		}

		return isDraw;
	}

	// あいこ判定（全員の手が同じ）
	private boolean checkSameDraw() {
		boolean isDraw = true;

		// 全員の手が同じ
		for(User user : mCPUList) {
			if(!mPlayer.getHandType().equals(user.getHandType())) {
				isDraw = false;
			}
		}

		return isDraw;
	}

	// あいこ判定（手が全種ある）
	private boolean checkWholeHandTypeDraw() {
		boolean isDraw = true;

		List<User> userList = new ArrayList<>();
		userList.addAll(Arrays.asList(mCPUList));
		userList.add(mPlayer);

		// 全種あるか確認
		HandType[] checkHandTypeList = {
				HandType.Gu,
				HandType.Tyoki,
				HandType.Par
		};

		User user = null;
		for(HandType handType : checkHandTypeList) {
			user = getUser(userList, handType);
			if(null == user) {
				isDraw = false;
				break;
			}
			userList.remove(user);
		}

		return isDraw;
	}

	// 指定手のユーザ取得
	private User getUser(List<User> userList, HandType handType)
	{
		User user = null;
		for(User tmpUser : userList) {
			if(handType.equals(tmpUser.getHandType())) {
				user = tmpUser;
				break;
			}
		}
		return user;
	}

	// 結果の初期化
	private void initResultType() {
		mPlayer.setResultType(ResultType.Invalid);
		for(User user : mCPUList) {
			user.setResultType(ResultType.Invalid);
		}
	}

	// 結果更新
	private void updateResultType(boolean isDraw) {
		initResultType();
		if(isDraw) {
			mPlayer.setResultType(ResultType.Draw);
			for(User user : mCPUList) {
				user.setResultType(ResultType.Draw);
			}
		} else {
			List<User> userList = new ArrayList<>();
			userList.addAll(Arrays.asList(mCPUList));
			userList.add(mPlayer);

			while(0 != userList.size()) {
				// 対戦基準のユーザ取得
				User userOne = userList.remove(0);

				if(ResultType.Invalid.equals(userOne.getResultType())) {
					for(User userTwo : userList) {
						ResultType resultType = getResultType(userOne, userTwo);
						if(!ResultType.Invalid.equals(resultType)) {
							userOne.setResultType(resultType);
							userTwo.setResultType(ResultType.Defeat);
						}
						else {
							resultType = getResultType(userTwo, userOne);
							if(!ResultType.Invalid.equals(resultType)) {
								userOne.setResultType(ResultType.Defeat);
								userTwo.setResultType(resultType);
							}
						}
					}
				}
			}
		}
	}

	// 結果取得
	private ResultType getResultType(User userOne, User userTwo) {
		ResultType resultType = ResultType.Invalid;

		Map<HandType, HandType> winMap = new HashMap<HandType, HandType>();
		winMap.put(HandType.Gu, HandType.Tyoki);
		winMap.put(HandType.Tyoki, HandType.Par);
		winMap.put(HandType.Par, HandType.Gu);

		for(Map.Entry<HandType, HandType> entry : winMap.entrySet()) {
			if(entry.getKey().equals(userOne.getHandType()) &&
					entry.getValue().equals(userTwo.getHandType())) {
				resultType = ResultType.Win;
				break;
			}
		}

		return resultType;
	}

	// 勝敗表示
	public void showResult() {
		System.out.println(
				"名称：" + mPlayer.getName() +
				", 手：" + getStrHandType(mPlayer.getHandType()) +
				", 勝敗：" + getStrResultType(mPlayer.getResultType()));
		for(User user : mCPUList) {
			System.out.println("名称：" + user.getName() +
					", 手：" + getStrHandType(user.getHandType()) +
					", 勝敗：" + getStrResultType(user.getResultType()));
		}
	}

	public String getStrHandType(HandType handType) {
		String ret = "";

		if(HandType.Gu.equals(handType)) {
			ret = "グー";
		} else if(HandType.Tyoki.equals(handType)) {
			ret = "チョキ";
		} else if(HandType.Par.equals(handType)) {
			ret = "パー";
		} else {
		}

		return ret;
	}

	public String getStrResultType(ResultType resultType) {
		String ret = "";

		if(resultType.equals(ResultType.Defeat)) {
			ret = "負け";
		} else if(resultType.equals(ResultType.Win)) {
			ret = "勝ち";
		} else if(resultType.equals(ResultType.Draw)) {
			ret = "あいこ";
		} else {
		}

		return ret;
	}
}
