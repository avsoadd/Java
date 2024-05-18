public class JavaStudy {
	public static void main(String[] args) {
		String[] hands = {"グー", "チョキ","パー"};
		java.util.Random r = new java.util.Random();
		
		int i1 = 0;
		
		System.out.println("勝ちたい数分勝負しましょう。数字を入力してください。");
		int count = new java.util.Scanner(System.in).nextInt();
		
		while(i1 < count) {
			System.out.println("最初はグー　じゃんけん");
			String playerHand = new java.util.Scanner(System.in).nextLine();
			System.out.println(playerHand);
			
			String cpuHand = hands[r.nextInt(3)];
			System.out.println(cpuHand);
			
			if((playerHand.equals("グー") && cpuHand.equals("チョキ")) || (playerHand.equals("チョキ") && cpuHand.equals("パー")) || playerHand.equals("パー") && cpuHand.equals("グー")) {
				System.out.println("あなたの勝ち");
				i1++;
			} else if(playerHand.equals("グー") && cpuHand.equals("パー") || (playerHand.equals("チョキ") && cpuHand.equals("グー")) || (playerHand.equals("パー") && cpuHand.equals("チョキ"))) {
				System.out.println("あなたの負け");
			} else if(playerHand.equals(cpuHand)) {
				System.out.println("あいこ");
			} else {
				System.out.println("じゃんけんの手を入力してください。");
			}
		}
		System.out.println("終了");
	}
}

