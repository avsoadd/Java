import java.util.Random;
import java.util.Scanner;

public class MarubatsuMain {
	// 初期盤面
	static String[][] board = {
		{"1", "2", "3"},
		{"4", "5", "6"},
		{"7", "8", "9"}
	};

	public static void main(String[] args) {
		Random r = new Random();
		System.out.println("まるばつゲームを始めます");
		System.out.println("あなたは先攻で○です");
		printBoard();
		
		for(int i = 0; i < 9; i++) {
			playerAction();
			printBoard();
		}

	}
	
	// プレイヤーの手番
	public static void playerAction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1~9を入力してください");
		int player_choice = scanner.nextInt();
		
		// 入力値を座標に変換
        int row = (player_choice - 1) / 3;
        int col = (player_choice - 1) % 3;
        
        // 盤面に反映
        board[row][col] = "○";
        
		System.out.println("あなたの選択:" + player_choice);
	}
	
	// 盤面を表示
	public static void printBoard() {
		// 現在の盤面を取得
		String[][] current_board =  board;
		// 満面の表示
		System.out.println(" |---+---+---|");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(" | " + current_board[i][j]);
			}
			System.out.println(" |");
			System.out.println(" |---+---+---|");
		}
	}
}
