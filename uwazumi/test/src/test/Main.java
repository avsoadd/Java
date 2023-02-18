package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String Str = "テスト";
        int Int = -1000;
        double db = 10.25;
        char tmp = 65;
        String[] Array = {"テスト" ,
                          "プログラム",
                          "実行"};
        int[]Ary3 = {1,2,3};

        String[] Ary2 = new String[1];
        Ary2[0] = "java";
		System.out.println(Str + "," + Int + "," + db + "," + tmp);
		System.out.println(Array[0] + Array[1] + Array[2]);
		System.out.println(Ary2[0]);

		for(int i = 0; i<Ary3.length; i++) {
			System.out.println(Ary3[i]);
		}

		Scanner scan = new Scanner(System.in);

		try {
		    System.out.println("入力");
		    int put = scan.nextInt();

		    System.out.println(put);
		}catch(Exception e) {
			System.out.println("catch");
			e.printStackTrace();
			System.out.println("");
		}
		System.out.println("終了");
	}
	
	public void test() {
		
	}
	
	public int testInt() {
		return 400;
	}
}
