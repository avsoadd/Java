package other;

import java.util.HashMap;
import java.util.Scanner;

public class Practice2 {
	public static void main(String[] args) {
		Marubatsu maru = new Marubatsu();
		maru.marubatsu();
	}
}
class Marubatsu {
	public int playerNum;
	public int enemyNum;
	public String maru;
	public String batsu;
	public HashMap<Integer, String> m = new HashMap<>();
	
	public void marubatsu() {
		m.put(0, "1");
		m.put(1, "2");
		m.put(2, "3");
		m.put(3, "4");
		m.put(4, "5");
		m.put(5, "6");
		m.put(6, "7");
		m.put(7, "8");
		m.put(8, "9");
		
		for(int i = 0; i < 9; i++) {
			System.out.print(" " + m.get(i) + " ");
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
		
	}
	
}