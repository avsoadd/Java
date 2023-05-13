package marubatuquizu;

import java.util.Scanner;

public class Playerturn {
	public int[] player() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("入力してください");
		
		int p = scanner.nextInt();
		int[] s=new int[2];
		
		switch(p) {
		case 1:
			s[0]=0;
			s[1]=0;
			break;
		case 2:
			s[0]=0;s[1]=2;
			break;
		case 3:
			s[0]=0;
			s[1]=4;
			break;
		case 4:
			s[0]=2;s[1]=0;
			break;
		case 5:
			s[0]=2;
			s[1]=2;
			break;
		case 6:
			s[0]=2;s[1]=4;
			break;
		case 7:
			s[0]=4;
			s[1]=0;
			break;
		case 8:
			s[0]=4;s[1]=2;
			break;
		case 9:
			s[0]=4;s[1]=4;
			break;
		}
		return s;
	}
}
