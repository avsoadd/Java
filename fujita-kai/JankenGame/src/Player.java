import java.util.Scanner;
public class Player {
	public int play() {
		System.out.println("グーは0、チョキは1、パーは2を入力してください");
		Scanner sc = new Scanner(System.in);
		int hand = sc.nextInt();
		if (hand == 0 || hand == 1 || hand == 2) {
			return hand;
		}
		return 3;
	}
}
