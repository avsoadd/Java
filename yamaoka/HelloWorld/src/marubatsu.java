import java.util.Scanner;

public class marubatsu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Battle bat = new Battle();
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		int i = 0;
		System.out.println("0または1を選択して下さい");
		System.out.println("先行:0");
		System.out.println("後攻:1");
		System.out.print( ">" );
		int j = sc.nextInt();
		if(j!= 0 || j!=1) {
			System.out.println("エラー！！");
			System.out.println("0または1を選択して下さい");
			System.out.println("先行:0");
			System.out.println("後攻:1");
			System.out.print( ">" );
			 j = sc.nextInt();
		}
		bat.battle(j);
		

	}

}
