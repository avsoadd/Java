package test;

import java.util.Random;
import java.util.Scanner;

class Janken {
	public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("勝負回数を入力してください");
        int times = scan.nextInt();
        for(int i = 1; i<=times; i++) {
        	int user = User();
    		int pc = Pc();
    		String result = judgeJanken(user,pc);
    		showResult(user,pc,result);

    		public static int User() {
    			Scanner hand = new Scanner(System.in);

    			while(true) {
    			System.out.println("じゃんけんの手を入力して下さい");
    			System.out.print("(グー：0，チョキ：1、パー：2)");

    			if(hand.hasNextInt()) {
    			    int number = hand.nextInt();
    			        if(number<=-1 || number >=3) {
    			            System.out.println("0～2を入力してください");
    			            continue;
    			        }else {
    			            return number;
    			        }
    			    }else {
                    System.out.println("0～2を入力してください");
    			    hand.next();
    			}
    			}
    			}

    		public static int Pc() {

    		}

	}
