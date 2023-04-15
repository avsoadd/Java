import java.util.Random;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		ユーザーの手の入力
		int user=getUser();
//		コンピュータの手の入力
		int pc=getPC();
//		勝敗の判定
		String result=judgejanken(user,pc);
//		結果表示
		showResult(user,pc,result);
	}
	public static int getUser() {
		Scanner stdin=new Scanner(System.in);
		while(true) {
//			メッセージの表示
			System.out.println("あなたのじゃんけんの手を入力して下さい");
			System.out.print("(グー：0，チョキ：1、パー：2)");
//			入力されたデータが整数かどうかのチェック
			if(stdin.hasNextInt()) {
				int number=stdin.nextInt();
//				有効な整数の範囲
				if(number<0 || number>2) {
					System.out.println("【無効な数字】入力できるのは「0～2」です");
					continue;
				}else {
					return number;
				}
			}
		}
	}
	public static int getPC() {
		Random rand = new Random();
		return rand.nextInt(3);
	}
	public static String judgejanken(int user, int pc) {
		String ret = "pcの勝ちです";
		int [][] judgelist = {
				{0,1},
				{1,2},
				{2,0},
		};
		for(int i = 0; judgelist.length>i; i++) {
				if(user==judgelist[i][0]&&pc==judgelist[i][1]) {
					ret="プレイヤーの勝ちです";
					break;
				}
		}
		if(user==pc) {
			ret="あいこです";
		}
		return ret;
	}
	public static void showResult(int user,int pc,String result) {
		System.out.println("プレイヤーの手:"+user);
		System.out.println("pcの手:"+pc);
		System.out.println("勝敗:"+result);
	}
}
