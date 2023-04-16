import java.util.Random;
public class Npc {
	public int play() {
		Random r = new Random();
		return r.nextInt(9) + 1;
	}
}
