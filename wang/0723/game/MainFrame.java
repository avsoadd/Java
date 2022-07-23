package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements KeyListener {
	int[][] datas = {
			{ 2, 0, 0, 0 },
			{ 0, 0, 0, 0 },
			{ 0, 0, 0, 0 },
			{ 0, 0, 0, 2 }

	};

	int resultFlag = 1;
	int score = 0;

	public MainFrame() {
		initFrame();
		paintView();

		//listen
		this.addKeyListener(this);

		setVisible(true);
	}

	/**
	 * windowの初期化設定
	 *
	 */
	public void initFrame() {

		//superのメソッドを使用するため、削除でOK
		setSize(514, 538);
		setTitle("2048");
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(3);

		setLayout(null);

	}

	/**
	 * 画面を描画
	 *
	 */

	public void paintView() {

		//remove all
		getContentPane().removeAll();

		if (resultFlag == 0) {
			JLabel fail = new JLabel(new ImageIcon("D:\\2048\\fail.png"));
			fail.setBounds(50, 50, 400, 400);
			getContentPane().add(fail);

		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (datas[i][j] == 64) {
					JLabel success = new JLabel(new ImageIcon("D:\\2048\\success.png"));
					success.setBounds(50, 50, 400, 400);
					getContentPane().add(success);
					break;

				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel image = new JLabel(new ImageIcon("D:\\2048\\" + datas[i][j] + ".png"));
				image.setBounds(50 + 100 * j, 50 + 100 * i, 100, 100);
				super.getContentPane().add(image);
			}
		}

		JLabel bg = new JLabel(new ImageIcon("D:\\2048\\bg.png"));
		bg.setBounds(40, 40, 420, 420);
		super.getContentPane().add(bg);

		JLabel scoreLabel = new JLabel("score: " + score);
		scoreLabel.setBounds(50, 20, 100, 20);
		getContentPane().add(scoreLabel);

		getContentPane().repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		int KeyCode = e.getKeyCode();

		if (KeyCode == KeyEvent.VK_UP) {
			MoveToTheTop();
			generateNum();

		} else if (KeyCode == KeyEvent.VK_DOWN) {
			MoveToTheBottom();
			generateNum();

		} else if (KeyCode == KeyEvent.VK_LEFT) {
			MoveToTheLeft(false);
			generateNum();

		} else if (KeyCode == KeyEvent.VK_RIGHT) {
			MoveToTheRight(false);
			generateNum();

		} else {
			return;
		}

		checkAll();

		paintView();

	}

	/**
	 *  結果のチェックを実施
	 *  上下左右へ動かなくなったら失敗
	 *
	 */

	public void checkAll() {
		if (checkLeft() == false && checkRight() == false && checkTop() == false && checkBottom() == false) {
			System.out.print("gameover");
			resultFlag = 0;
		}

	}

	/**
	 *空白のところに２をランダムに生成
	 *
	 */
	public void generateNum() {

		ArrayList<Integer> array1 = new ArrayList<>();
		ArrayList<Integer> array2 = new ArrayList<>();

		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if (datas[i][j] == 0) {
					array1.add(i);
					array2.add(j);
				}
			}
		}
		System.out.println("size:" + array1.size());
		System.out.println("size:" + array2.size());
		Random random = new Random();
		int index = random.nextInt(array1.size());

		int x = array1.get(index);
		int y = array2.get(index);
		datas[x][y] = 2;

	}

	public boolean checkLeft() {
		int[][] tempArr = datas.clone();

		MoveToTheLeft(true);

		boolean flag = false;
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if (datas[i][j] != tempArr[i][j]) {
					flag = true; //左へ移動可能
					break;

				}
			}
		}

		datas = tempArr.clone();
		return flag;

	}

	public boolean checkRight() {
		int[][] tempArr = datas.clone();
		MoveToTheRight(true);
		boolean flag = false;
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if (datas[i][j] != tempArr[i][j]) {
					flag = true; //右へ移動可能
					break;

				}
			}
		}

		datas = tempArr.clone();
		return flag;

	}

	public boolean checkTop() {
		int[][] tempArr = datas.clone();

		MoveToTheTop();
		boolean flag = false;
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if (datas[i][j] != tempArr[i][j]) {
					flag = true; //上へ移動可能
					break;

				}
			}
		}
		datas = tempArr.clone();
		return flag;

	}

	public boolean checkBottom() {
		int[][] tempArr = datas.clone();
		MoveToTheBottom();
		boolean flag = false;
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if (datas[i][j] != tempArr[i][j]) {
					flag = true; //下へ移動可能
					break;

				}
			}
		}
		datas = tempArr.clone();
		return flag;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void MoveToTheLeft(boolean isCheck) {
		for (int m = 0; m < datas.length; m++) {

			//０でない項目を左に移動
			int[] arr = new int[4];
			int index = 0;
			for (int x = 0; x < datas[m].length; x++) {
				if (datas[m][x] != 0) {
					arr[index] = datas[m][x];
					index++;
				}
			}
			datas[m] = arr;

			for (int x = 0; x < 3; x++) {
				//隣の項目と比較し、同じものを足す
				if (datas[m][x] == datas[m][x + 1]) {
					datas[m][x] *= 2;
					if (!isCheck) {
						score += datas[m][x];
					}

					//次の項目を前に移動し、最後に０を足す
					for (int j = x + 1; j < 3; j++) {
						datas[m][j] = datas[m][j + 1];
					}
					datas[m][3] = 0;
				}
			}
		}

		System.out.println("left");

	}

	public void MoveToTheRight(boolean isCheck) {
		for (int m = 0; m < datas.length; m++) {

			//０でない項目を右に移動
			int[] arr = new int[4];
			int index = 3;
			for (int x = datas[m].length - 1; x >= 0; x--) {
				if (datas[m][x] != 0) {
					arr[index] = datas[m][x];
					index--;
				}
			}
			datas[m] = arr;

			for (int x = 3; x > 0; x--) {
				//隣の項目と比較し、同じものを足す
				if (datas[m][x] == datas[m][x - 1]) {
					datas[m][x] *= 2;
					if (!isCheck) {
						score += datas[m][x];
					}

					//次の項目を後ろに移動し、先頭に０を足す
					for (int j = x - 1; j > 0; j--) {
						datas[m][j] = datas[m][j - 1];
					}
					datas[m][0] = 0;
				}
			}
		}
		paintView();
		System.out.println("right");
	}

	public void MoveToTheTop() {
		AntiClockwise();
		MoveToTheRight(false);
		Clockwise();
		System.out.println("up");

	}

	public void MoveToTheBottom() {
		Clockwise();
		MoveToTheRight(false);
		AntiClockwise();
		System.out.println("down");
	}

	public void AntiClockwise() {

		int[][] newArr = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				newArr[j][3 - i] = datas[i][j];

			}
		}
		datas = newArr;

	}

	public void Clockwise() {
		int[][] newArr = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

				newArr[3 - j][i] = datas[i][j];

			}
		}

		datas = newArr;
	}

}
