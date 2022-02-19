package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class game {
	List<player> playerList;

	public game() {
		playerList= new ArrayList<>();

	}
	public void run() {
		player p=new player();

		for(int i =0; i<=1;i++ ) {
			addPlayer(inputPlayer());
		}
	}

	public void startGame() {
		String playerNow="";
		player p = new player();


		 List<String> numList = new ArrayList<String>(9);
		 for(int i=0;i<9;i++) {
			 numList.add(i,"  ");
			 System.out.println(numList.get(i));
		 }

		 for (int i = 1; i< numList.size()+2;i++) {

		System.out.println("|――|"+"――|"+"――|");
		System.out.println("| "+numList.get(0)+" |"+" "+numList.get(1)+" |"+" "+numList.get(2)+" |");
		System.out.println("|――|"+"――|"+"――|");
		System.out.println("| "+numList.get(3)+" |"+" "+numList.get(4)+" |"+" "+numList.get(5)+" |");
		System.out.println("|――|"+"――|"+"――|");
		System.out.println("| "+numList.get(6)+" |"+" "+numList.get(7)+" |"+" "+numList.get(8)+" |");
		System.out.println("|――|"+"――|"+"――|");
		  //win判定
		if( numList.get(0) !="  "&& numList.get(0).equals(numList.get(1))&&numList.get(1).equals(numList.get(2)) ||
			numList.get(3) !="  "&& numList.get(3).equals(numList.get(4))&&numList.get(4).equals(numList.get(5)) ||
			numList.get(6) !="  "&& numList.get(6).equals(numList.get(7))&&numList.get(7).equals(numList.get(8)) ||
			numList.get(0) !="  "&& numList.get(0).equals(numList.get(4))&&numList.get(4).equals(numList.get(8)) ||
			numList.get(2) !="  "&& numList.get(2).equals(numList.get(4))&&numList.get(4).equals(numList.get(6)) ||
			numList.get(2) !="  "&& numList.get(2).equals(numList.get(4))&&numList.get(4).equals(numList.get(6)) ||
			numList.get(0) !="  "&& numList.get(0).equals(numList.get(3))&&numList.get(3).equals(numList.get(6)) ||
			numList.get(1) !="  "&& numList.get(1).equals(numList.get(4))&&numList.get(4).equals(numList.get(7)) ||
		 	numList.get(2) !="  "&& numList.get(2).equals(numList.get(5))&&numList.get(5).equals(numList.get(8))
				 ) {
					System.out.println(playerNow+"さんの勝ちです");
					break;
				}


           if(i%2 ==1) {
        	   p=playerList.get(0);
        	   p.setMark("〇");
           }else {
        	   p=playerList.get(1);
        	   p.setMark("×");
           }
           playerNow=p.getName();
           int num=0;

       while(true) {

		System.out.println(playerNow+"さん、1-9の番号を入力してください:");
		try {
		Scanner scan = new Scanner(System.in);
		num=scan.nextInt();
		}catch(Exception e) {
			continue;

		}


		//入力判定
		if (num>9 || num<0){
			System.out.println("不正な番号です");

		}else if(numList.get(num-1) !="  " ) {
			System.out.println("番号が重複しています");

		}else {
			break;
		}
		}
		numList.set(num-1,p.getMark());

        if(i==9) {
        	System.out.println("やり直しましょう");
        	break;
        }

		}

		}


	public player inputPlayer() {
		player input = new player();

		Scanner scan = new Scanner(System.in);
		System.out.println("名前入力：");
		try {
				input.setName(scan.next());
		}
		catch(Exception e) {
			e.printStackTrace();
		}


		return input;
	}

	private boolean addPlayer(player player) {
		boolean isAdd = false;
       	if (player!=null) {
			playerList.add(player);
			isAdd= true;
		}

		return isAdd;
	}


	public static void main (String[]args) {
		game marubatu = new game();
		marubatu.run();
		marubatu.startGame();

	}
}
