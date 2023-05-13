package janken;
import java.util.Random;

public class janken1 {

	public static void main(String[] args) {
		String[] hands = { "グー", "チョキ", "パー" };
	    Random r = new Random();
	    for(int i=0 ; i<5 ; i++) {
	      String hand = hands[r.nextInt(3)];
	      System.out.println(hand);
	    }

	}

}
