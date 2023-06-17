package marubatuquizu;

import java.util.Random;

public class Npcturn {
	public int[] npc() {
		Random rnd=new Random();
		int ab=rnd.nextInt(9)+1;
		System.out.println(ab);
		int[] pc=new int[2];
		
		switch(ab) {
		case 1:
			pc[0]=0;
			pc[1]=0;
			break;
		case 2:
			pc[0]=0;
			pc[1]=2;
			break;
		case 3:
			pc[0]=0;
			pc[1]=4;
			break;
		case 4:
			pc[0]=2;
			pc[1]=0;
			break;
		case 5:
			pc[0]=2;
			pc[1]=2;
			break;
		case 6:
			pc[0]=2;
			pc[1]=4;
			break;
		case 7:
			pc[0]=4;
			pc[1]=0;
			break;
		case 8:
			pc[0]=4;
			pc[1]=2;
			break;
		case 9:
			pc[0]=4;
			pc[1]=4;
			break;
		}
		return pc;
		
	}

}
