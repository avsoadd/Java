package practice;

public class Sample4_1 {

	public static void main(String[] args) {
		int x = 5+5;
		if(x >=10) {
			System.out.println("10以上です");
		}
		
		int y = 100/20;
		if(y >=10) {
			System.out.println("10以上です");
		}
		else {
			System.out.println("10未満です");
		}
		
		int z = 10 % 3;
		if(z == 0 ) {
			System.out.println("割り算のあまりは0です");
		}
		else {
			System.out.println("割り算のあまりは" + z + "です");
		}
	}
}
