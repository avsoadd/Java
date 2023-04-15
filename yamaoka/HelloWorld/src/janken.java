import java.util.Random;
import java.util.Scanner;
public class janken {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("指定回数 < ");
		int a = sc.nextInt();
		int b = 0;
		while(b < a) {
			
		System.out.println("じゃんけんをしましょう");
		System.out.println("最初はグーじゃんけんぽん");
		System.out.println("グーかチョキかパーを出して下さい");
		System.out.println("プレイヤー１ <");
		String jan1 = sc.next();
		while(!(jan1.equals("グー"))&&!(jan1.equals("チョキ"))&&!(jan1.equals("パー"))){
			System.out.println("エラー！！打ち直して下さい");
			System.out.println("グーかチョキかパーを出して下さい");
			System.out.println("プレイヤー１ <");
			 jan1 = sc.next();
		}
		int jankazu = rand.nextInt(3);
		String jan2;
		if(jankazu == 0) {
			jan2 = "グー";
		}else if(jankazu == 1) {
			jan2 = "チョキ";
		}else {
			jan2 = "パー";
		}
		System.out .println("プレイヤー２ < " + jan2);
		while(jan1.equals(jan2)) {
			System.out.println("あいこでしょ");
			System.out.println("グーかチョキかパーを出して下さい");
			System.out.println("プレイヤー１ <");
			 jan1 = sc.next();
			 while(!(jan1.equals("グー"))&&!(jan1.equals("チョキ"))&&!(jan1.equals("パー"))){
				System.out.println("エラー！！打ち直して下さい");
				System.out.println("グーかチョキかパーを出して下さい");
				System.out.println("プレイヤー１ <　");
				 jan1 = sc.next();
			}
			 jankazu = rand.nextInt(3);
			 
			if(jankazu == 0) {
				jan2 = "グー";
			}else if(jankazu == 1) {
				jan2 = "チョキ";
			}else {
				jan2 = "パー";
			
		}
			System.out .println("プレイヤー２ < " + jan2);
		
	}
	if(jan1.equals("グー")&&jan2.equals("チョキ")||jan1.equals("チョキ")&&jan2.equals("パー")||jan1.equals("パー")&&jan2.equals("グー")){
		System.out.println("プレイヤー１の勝利です！！");
	b = b+ 1;
		 System.out.println("現在" + b + "回勝ちました");
	}
	if(jan1.equals("グー")&&jan2.equals("パー")||jan1.equals("チョキ")&&jan2.equals("ぐー")||jan1.equals("パー")&&jan2.equals("チョキ")){
		System.out.println("プレイヤー２の勝利です！！");
		System.out.println("現在" + b + "回勝ちました");
	}
	
	}
	}	
}
