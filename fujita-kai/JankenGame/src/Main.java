public class Main {
	static int counta = 0;
	public static void main(String[] args) {
		System.out.println("3回勝利してください。");
		while(counta < 3) {
			JankenNpc npc = new JankenNpc();
			int npcHand = npc.play();
			Player p = new Player();
			int playerHand = p.play();
			if (playerHand == 3) {
				System.out.println("入力が正しくありません。もう一度");
				continue;
			}
			System.out.println(npcHand +" npcの手");
			Judge j = new Judge();
			int kekka = j.judgement(npcHand,playerHand);
			if (kekka == 0) {
				System.out.println("あいこです。もう一度");
				continue;
			} else if(kekka == 1) {
				System.out.println("あなたの負け");
			} else {
				System.out.println("あなたの勝ち");
				counta++;
			}
		}
		System.out.println("3回勝利しました。おめでとう!!");
	}
}
