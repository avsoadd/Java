import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MaruBatsu1 {
	// boardの初期値。showBoardで使用。
	public String[] board = {"０","１","２",
						 	"３","４","５",
						 	"６","７","８"};
	
	// 土台。
	public void showBoard() {
		
		System.out.println("----------");

		for (int row = 0; row < 9; row += 3) {
			System.out.print("|");
			for (int col = 0; col < 3; col++) {
				System.out.print(board[col + row]);
				System.out.print("|");
			}
			System.out.println();
			System.out.println("----------");
		}
	}
	
	// Listの中のIntegerを配列に。
	// 0～8までListに格納
	public List <Integer> avairableInputList = new ArrayList <Integer>();
	
	// MaruBatsu6のコンストラクタ
	public MaruBatsu1() {
		for(int i = 0; i < 9; i++) {
			avairableInputList.add(i);
		}
	}
		
	// Playerの入力処理
	public int playerInput() {
		
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < avairableInputList.size(); i++) {
			System.out.print(avairableInputList.get(i) + " ");
		}
		System.out.println("のいずれかの数値を入力してください");
		
		int inputInt = scan.nextInt();
		int index = 0;
		for(; index < avairableInputList.size(); index++) {
			if(avairableInputList.get(index) == inputInt) {
				break;
			}
		}
		
		try {
		inputInt = avairableInputList.remove(index);}
		catch(IndexOutOfBoundsException e) {
			
			System.out.println("入力誤り");
			inputInt = -1;
		}
//		scan.close();
		return inputInt;
	}
	
	// CPUの入力処理
	public int cpuInput() {
		Random rand = new Random();
		System.out.println("************************");
		System.out.println("cpuの入力です。");
		int inputInt = rand.nextInt(9);
		System.out.println(inputInt);
		int index = 0;
		for(; index < avairableInputList.size(); index++) {
			if(avairableInputList.get(index) == inputInt) {
				break;
			}
		}
		
		try {
			inputInt = avairableInputList.remove(index);}
		catch(IndexOutOfBoundsException e) {
			
			System.out.println("入力誤り");
			inputInt = -1;
		}

		return inputInt;
	}
	
	
	
	// mainメソッド
	public static void main(String[] args) {
		MaruBatsu1 mb = new MaruBatsu1();
		mb.showBoard();
		
		// for文から勝ちに変更する
		for(int i = 0; i < 5; i++) {
			// Player
			while(true) {
				int player = mb.playerInput();
				if(player != -1) {
					mb.board[player] = "○";				
					mb.showBoard();		
					break;
				}else {
					System.out.println("選び直してください");
				}				
			}
			
			
			if(mb.board[0] == "○" && mb.board[1] == "○" && mb.board[2] == "○" 
					|| mb.board[3] == "○" && mb.board[4] == "○" && mb.board[5] == "○" 
					|| mb.board[6] == "○" && mb.board[7] == "○" && mb.board[8] == "○" 
					|| mb.board[0] == "○" && mb.board[3] == "○" && mb.board[6] == "○" 
					|| mb.board[1] == "○" && mb.board[4] == "○" && mb.board[7] == "○" 
					|| mb.board[2] == "○" && mb.board[5] == "○" && mb.board[8] == "○" 
					|| mb.board[0] == "○" && mb.board[4] == "○" && mb.board[8] == "○" 
					|| mb.board[2] == "○" && mb.board[4] == "○" && mb.board[6] == "○") {
				System.out.println("Playerの勝ちです。");
				break;
			}
			
			if(i == 4) {
				System.out.println("引き分けです。");
				break;
			}
			
			// cpu
			while(true) {
				int cpu = mb.cpuInput();
				if(cpu != -1) {
					mb.board[cpu] = "●";				
					mb.showBoard();		
					break;
				}else {
					System.out.println("選び直します");
				}	
			}
			if(mb.board[0] == "●" && mb.board[1] == "●" && mb.board[2] == "●" 
					|| mb.board[3] == "●" && mb.board[4] == "●" && mb.board[5] == "●" 
					|| mb.board[6] == "●" && mb.board[7] == "●" && mb.board[8] == "●" 
					|| mb.board[0] == "●" && mb.board[3] == "●" && mb.board[6] == "●" 
					|| mb.board[1] == "●" && mb.board[4] == "●" && mb.board[7] == "●" 
					|| mb.board[2] == "●" && mb.board[5] == "●" && mb.board[8] == "●" 
					|| mb.board[0] == "●" && mb.board[4] == "●" && mb.board[8] == "●" 
					|| mb.board[2] == "●" && mb.board[4] == "●" && mb.board[6] == "●" ) {
				System.out.println("cpuの勝ちです。");
				break;
			}

		}
		
	}
}