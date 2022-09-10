import java.util.Random;
import java.util.Scanner;
public class JyannkennMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("じゃんけんをします");
		Random rnd = new Random();

		//int myhand = 10;
		System.out.println("自分手を入力");

		int [][] table = {{0,1},{1,2},{2,0}};
		int [][] wintable = {{0,2},{1,0},{2,1}};
		for(int i = 0; i < 6; i++) {
			int hand = rnd.nextInt(3);
			Scanner myhand = new Scanner(System.in);
			int jankenn = myhand.nextInt();

			if(hand == 0) {
				System.out.println("相手の手は『パー』");
			}
			else if(hand == 1) {
				System.out.println("相手の手は『チョキ』");
			}
			else {
				System.out.println("相手の手は『グー』");
			}
			for(int j = 0;j < wintable.length;j++) {
				//for(int k = 0;k < wintable[j].length;k++) {
					if(jankenn == wintable[j][0] && hand == wintable[j][1]) {
						System.out.println("あなたの勝ちです");
				}
			}
			for(int j = 0;j < table.length;j++) {
				//for(int k = 0;k < wintable[j].length;k++) {
					if(jankenn == table[j][0] && hand == table[j][1]) {
						System.out.println("あなたの負けです");
				}
			}
			if(jankenn == hand) {
				System.out.println("あいこです");
			}

			}
		}

	}


