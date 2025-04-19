
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	// プレイヤー種別
	public enum PlayerType {
		USER,
		CPU,
	}

	// 手
	public enum Hand {
		Invalid("無効"),
		GU("グー"),
		PA("パー"),
		CHOKI("チョキ");

		// 手（文字列）
		private String mHand;

		// コンストラクタ
		private Hand(String hand) {
			mHand = hand;
		}

		// 手（文字列）を取得
		public String getHand() {
			return mHand;
		}

		// 手変換（int → Hand）
		static public Hand ConvertHand(int hand) {
			List<Hand> list = new ArrayList<Hand>();
			list.add(GU);
			list.add(PA);
			list.add(CHOKI);

			Hand ret = Hand.Invalid;
			if(0 <= hand && list.size() > hand) {
				ret = list.get(hand);
			}
			return ret;
		}
	}

	// プレイヤーリスト
	private List<PlayerType> mPlyerList;

	// コンストラクタ
	public Main() {
		mPlyerList = new ArrayList<PlayerType>(2);
	}

	// プレイヤー追加
	public void addPlayer(PlayerType type) {
		mPlyerList.add(type);
	}

	// 手取得
	public Hand getHand(PlayerType type) {
		int hand = -1;
		if(PlayerType.CPU == type)
		{
			Random rand = new Random();
			hand = rand.nextInt(3);
		}
		else
		{
			while((hand < 0) || (hand >= 3))
			{
				try
				{
					Scanner scan = new Scanner(System.in);
					System.out.println("手を入力してください（0：グー、1：パー、2：チョキ）");
					hand = scan.nextInt();
					if((hand < 0) || (hand >= 3)) {
						throw new Exception();
					}
				}
				catch(Exception e)
				{
					System.out.println("0～3の数値を入力してください");
				}
			}
		}
		return Hand.ConvertHand(hand);
	}

	// 勝敗判定
	public String check(Hand one, Hand two) {
		String ret = "プレイヤー2の勝ち";

		System.out.println("プレイヤー1：" + one.getHand() + ", プレイヤー2:" + two.getHand());

		// プレイヤー1の勝ち組み合わせ配列
		Hand[][] oneWinCheckList = {
			{Hand.GU, Hand.CHOKI},
			{Hand.PA, Hand.GU},
			{Hand.CHOKI, Hand.PA},
		};

		if(one == two) {
			// 同じ手の場合
			ret = "あいこ";
		}
		else {
			// 違う手の場合、プレイヤー1の勝ちか確認
			for(Hand[] checkList : oneWinCheckList)
			{
				if((checkList[0] == one) && (checkList[1] == two)) {
					ret = "プレイヤー1の勝ち";
					break;
				}
			}
		}

		return ret;
	}

	// じゃんけん実施
	public void game() {
		// 開始の準備
		System.out.println("じゃんけん開始");
		addPlayer(PlayerType.USER);
		addPlayer(PlayerType.CPU);

		// 回数の入力
		int cnt = -1;
		while(0 > cnt)
		{
			try
			{
				Scanner scan = new Scanner(System.in);
				System.out.println("じゃんけん回数を入力してください：");
				cnt = scan.nextInt();
				if(0 > cnt) {
					throw new Exception();
				}
			}
			catch(Exception e)
			{
				System.out.println("数値で1以上の値を入力してください");
			}
		}

		// 入力された回数分じゃんけん実施
		for(int i = 0; i < cnt; i++) {
			System.out.println("----------------------------------");
			System.out.println("じゃんけん - " + (i+1) + "回目");

			String ret = check(getHand(mPlyerList.get(0)), getHand(mPlyerList.get(1)));

			System.out.println("結果：" + ret);
			System.out.println("----------------------------------");
		}

		System.out.println("じゃんけん終了");
	}

	// メイン処理
	public static void main(String[] args) {
		Main janken = new Main();
		janken.game();
	}
}
