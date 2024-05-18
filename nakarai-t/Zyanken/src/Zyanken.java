import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zyanken {
	// じゃんけんゲーム
		
		static Random rand = new Random();
	

	public static void main(String[] args) {
		
		//最初の入力を求める
		System.out.println("何回勝利するまでじゃんけんをするか入力してください。");
		System.out.print("勝利回数: ");
		//入力値を受け取る
		int victorycount = checkintvalue();
		//ゲームを始める
		int winnercount = 0;
		int battleresult, pcvalue, playervalue;
		
		while(winnercount <= victorycount) {
			//プレイヤーの手を受け取る
			playervalue = getplayervalue();
			//pcの手を受け取る
			pcvalue = getpcvalue();
			//勝敗を判定する
			battleresult = getbattleresult(playervalue, pcvalue);
			//勝敗結果を表示する
			winnercount =getwincount(battleresult);
			
		}
		
		

	}

	//数値判定
	public static int checkintvalue() {
		 
		while(true) {
			Scanner sc = new Scanner(System.in);
			try {
				int victoryvalue = sc.nextInt();
				return victoryvalue;
			}
			catch(InputMismatchException e){
				System.out.println("入力は整数値を入力してください.");
				System.out.print("勝利回数: ");	
			}		

		}
	}
	//じゃんけんの勝敗判定
	public static int getbattleresult(int playervalue, int pcvalue) {
		
		int checkbattlevalue = (playervalue - pcvalue + 3) % 3;
		//あいこの場合
		if(checkbattlevalue == 0) {
			return 0;
		}
		//まけの場合
		else if(checkbattlevalue == 1) {
			return 1;
		}
		//勝ちの場合
		else {
			return 2;
		}
	}
	//勝敗処理
	public static int getwincount(int winresult) {
		int wincount = 0;
		if(winresult == 0) {
			System.out.print("結果は、あいこです。");
		}
		else if (winresult == 1){
			System.out.print("結果は、あなたの負けです");
		}
		else {
			System.out.print("結果は、あなたの勝ちです");
			wincount += 1;
		}
		return wincount;
	}
	
	//パソコンの値を決定
	public static int getpcvalue() {
		
		int num = rand.nextInt(3);
		if(num == 0) {
			System.out.println("コンピューターは、グーを出しました。");
		}
		else if(num == 1) {
			System.out.println("コンピューターは、チョキを出しました。");
		}
		else {
			System.out.println("コンピューターは、パーを出しました。");
		}
		return num;
	}
	
	//プレイヤーの手の選択
	public static int getplayervalue() {
		 Scanner sc = new Scanner(System.in);
		System.out.println("グー、チョキ、パーのいずれかを入力してください。");
		System.out.print("あなたの選択: ");
		//プレイヤーの入力を受け取る
		String prayerchoice = sc.nextLine();
		
		int Intplayervalue = 0;
		
		switch(prayerchoice) {
			
		case "グー":
			Intplayervalue = 0;
			break;
			
		case "チョキ":
			Intplayervalue = 1;
			break;
			
		case "パー":
			Intplayervalue = 2;
			break;
			
		default:
			System.out.println("入力値が正しくありません。もう一度入力してください");
			getplayervalue();
		}
		return Intplayervalue;
		
	}


}
