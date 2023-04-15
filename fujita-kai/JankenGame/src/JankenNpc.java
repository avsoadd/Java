import java.util.Random;
public class JankenNpc {
	public int play() {
		Random r = new Random();
		int hand = r.nextInt(3);
		return hand;
	}
}
