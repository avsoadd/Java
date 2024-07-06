import java.util.Random;
import java.util.Scanner;

class Practice{
	public static void main(String[] args) {
		Marubatsu maru = new Marubatsu();
		maru.marubatsu();
		maru.playerSelect();
		maru.enemySelect();
	}
}

class Marubatsu {
	public int playerNum;
	public int enemyNum;
	public String maru;
	public String batsu;
	public String[] groundNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	
	public void marubatsu() {
		for(int i = 0; i < 9; i++) {
			System.out.print(" " + groundNum[i] + " ");
			if(i == 2 || i == 5 || i == 8) {
				System.out.println();
				for(int j = 1; j <= 11; j++) {
					if(j % 4 == 0) {
						System.out.print("+");
					} else {
						System.out.print("-");
					}
					if(j == 11) {
						System.out.println();
					}
				}
			} else {
				System.out.print("|");
			}
		}
	}
	
	public void playerSelect() {
		System.out.println("1-9の数字を選択");
		Scanner sc = new Scanner(System.in);
		playerNum = sc.nextInt();
		if(playerNum > 10 || playerNum <= 0) {
			System.out.println("エラー。再度数値を入力。");
			playerSelect();
		}
		switch(playerNum) {
		case 1 :
			groundNum[0] = "○";
			marubatsu();
			break;
		case 2 :
			groundNum[1] = "○";
			marubatsu();
			break;
		case 3 :
			groundNum[2] = "○";
			marubatsu();
			break;
		case 4 :
			groundNum[3] = "○";
			marubatsu();
			break;
		case 5 :
			groundNum[4] = "○";
			marubatsu();
			break;
		case 6 :
			groundNum[5] = "○";
			marubatsu();
			break;
		case 7 :
			groundNum[6] = "○";
			marubatsu();
			break;
		case 8 :
			groundNum[7] = "○";
			marubatsu();
			break;
		case 9 :
			groundNum[8] = "○";
			marubatsu();
			break;
		}
	}
	
	public void enemySelect() {
		System.out.println("コンピュータのターン");
		Random random = new Random();
		enemyNum = random.nextInt(10);
		switch(enemyNum) {
		case 1 :
			groundNum[0] = "×";
			marubatsu();
			break;
		case 2 :
			groundNum[1] = "×";
			marubatsu();
			break;
		case 3 :
			groundNum[2] = "×";
			marubatsu();
			break;
		case 4 :
			groundNum[3] = "×";
			marubatsu();
			break;
		case 5 :
			groundNum[4] = "×";
			marubatsu();
			break;
		case 6 :
			groundNum[5] = "×";
			marubatsu();
			break;
		case 7 :
			groundNum[6] = "×";
			marubatsu();
			break;
		case 8 :
			groundNum[7] = "×";
			marubatsu();
			break;
		case 9 :
			groundNum[8] = "×";
			marubatsu();
			break;
		}
	}
	
	
}