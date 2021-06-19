import java.util.Random;

public class Hand {
	public static final int STONE = 0;
	public static final int SCISSORS = 1;
	public static final int PAPER = 2;

	public void printHand(int hand) {

		switch (hand) {
		case Hand.STONE :
			System.out.print("グー");
			break;
		case Hand.SCISSORS :
			System.out.print("チョキ");
			break;
		case Hand.PAPER :
			System.out.print("パー");
			break;

			default :
			break;
		}
	}

	public int randomHand() {
		Random randomm = new Random();
		int randomNum = randomm.nextInt(3);

		int hand = 0;

		if (randomNum == STONE) {
			hand = STONE;
		} else if (randomNum == SCISSORS) {
			hand = SCISSORS;
		} else if (randomNum == PAPER) {
			hand = PAPER;
		}
		return hand;
	}
}