package main;

import java.util.Scanner;
import board.BoardMain;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int answer;
		BoardMain boardMain;
		
		answer = selectScene();
		
		if(answer == 1) {
			boardMain = new BoardMain();
			boardMain.game();
		}
		if(answer == 2) return;
	}
	
	public static int selectScene() {
		int answer=0;
		Scanner scanner = new Scanner(System.in);
		
		while(!(answer == 1 || answer == 2)) {
			System.out.println("ƒQ[ƒ€‚ðŽn‚ß‚Ü‚·");
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.print("> ");
			
			answer = Integer.valueOf(scanner.next());
		}
		return answer;
	}
}
