public class Main {

	public static void main(String[] args) {
		Player p1 = new Player("プレイヤー1");
		Hand hand1 = new Hand();

		Player p2 = new Player("プレイヤー2");
		Hand hand2 = new Hand();

		Judge judge = new Judge();
		judge.start(p1, hand1, p2, hand2);

	}

}