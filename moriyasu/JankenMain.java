package janken;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class JankenMain {

	public static void main(String[] args) {


		System.out.println("開始");
		
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		System.out.println("勝負回数を入力してください");
		String vs = scanner.next();
		for(int i=0;i<Integer.parseInt(vs);i++) {
		
			System.out.println(i+1+"回戦");
			//System.out.println(vs);
			
			System.out.println("自分の手を入力してください");
			String myhand = scanner.next();
			//System.out.println(myhand);
			String[] hands = {"グー","チョキ","パー"};
			Random r = new Random();
			String yourhand = hands[r.nextInt(3)];
			
			System.out.println("相手の手は"+yourhand+"です");
			//System.out.println("相手の手を入力してください");
			//String yourhand = scanner.next();
			//System.out.println(yourhand);
			
			//System.out.println(myhand);
			
			JankenMain janken = new JankenMain();
			boolean win = janken.isWin(myhand,yourhand);
			boolean lose = janken.isLose(myhand, yourhand);
			System.out.println("じゃんけんの結果はあなたの");
			if(win==true) {
				System.out.println("勝ち");
				count++;
			}else if(lose==true){
				System.out.println("負け");
			}else {
				
				System.out.println("あいこ");
				i--;
				System.out.println("もう一回");
			}
			if(count==Integer.parseInt(vs)/2) {
				System.out.println("半分以上の勝利が確定しました。");
				System.out.println("じゃんけんを終了します。");
				break;
			}
		}
		//if(myhand.equals("パー")) {
		//	System.out.println("成功");
		//}
		//else {
		//	System.out.println("失敗");
		//}
		
		//boolean result = false;
		
//		//if(myhand.equals("パー")&&yourhand.equals("グー")) {
//			
//			 result = true;
//		}
//		if(myhand.equals("グー")&&yourhand.equals("チョキ")) {
//			
//			 result = true;
//		}
//		if(myhand.equals("チョキ")&&yourhand.equals("パー")) {
//			
//			result = true;
//		}
//		

		

	}
	public boolean isWin(String key,String libalhand) {
		Map<String, String> map = new HashMap<>();
		map.put("グー", "チョキ");
		map.put("チョキ","パー");
		map.put("パー","グー");

		String hand = map.get(key);
			if(hand.equals(libalhand)) {
				
				return true;
			}else {
				return false;
			}
		
	}
	public boolean isLose(String key, String libalhand) {
		Map<String, String> map = new HashMap<>();
		map.put("グー", "パー");
		map.put("チョキ","グー");
		map.put("パー","チョキ");
		String hand = map.get(key);
		if(hand.equals(libalhand)) {
			
			return true;
		}else {
			return false;
		}		
		

	}

}
