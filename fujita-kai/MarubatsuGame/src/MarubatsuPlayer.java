import java.util.Scanner;
public class MarubatsuPlayer {
	public int play() {
		System.out.println("上に表示されている番号を選択し、入力してください。");
		Scanner sc = new Scanner(System.in);
		int maru = sc.nextInt();
		return maru;
	}
}
