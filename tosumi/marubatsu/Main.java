import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		System.out.println("〇×ゲーム");
		System.out.println("プレイヤー：〇, NPC：×");
		
		Board b = new Board();
		Player player = new Player();
		Player npc = new Player();
		
		int count = 0;
		
		b.showBoard(b.board);
		
		while(count<5) {
		
			System.out.println("プレイヤーの入力箇所を決定します。");
		
			player.decidePlayer(b.board);
			player.place(b.board, "〇");
			b.judge(b.board, "〇");
			if(b.win) {
				b.showBoard(b.board);
				System.out.println("プレイヤーの勝利！");
				break;
			}
			
			if(count == 4) {
				break;
			}
			
			npc.decideNpc(b.board);
			npc.place(b.board, "×");
			b.judge(b.board, "×");
			if(b.win) {
				b.showBoard(b.board);
				System.out.println("NPCの勝利...");
				break;
			}
		
		
			b.showBoard(b.board);
			count++;
		}
		
		
	}

}

class Board{
	String[][] board = {{"　","　", "　"},{"　","　", "　"},{"　","　", "　"}};
	boolean win = false;
	
	public  void showBoard(String[][] b) {
		System.out.println("   0  1  2");
		System.out.println(" ─────");
		System.out.println("0|"+b[0][0]+"|"+b[0][1]+"|"+b[0][2]+"|");
		System.out.println(" ─────");
		System.out.println("1|"+b[1][0]+"|"+b[1][1]+"|"+b[1][2]+"|");
		System.out.println(" ─────");
		System.out.println("2|"+b[2][0]+"|"+b[2][1]+"|"+b[2][2]+"|");
		System.out.println(" ─────");
	}
	
	public void judge(String[][] b, String type){
		for(int i=0;i<3;i++) {
			if(b[i][0] == type && b[i][1] == type && b[i][2] == type) {
				this.win = true;
			}
			if(b[0][i] == type && b[1][i] == type && b[2][i] == type) {
				this.win = true;
			}
		}
		
		if(b[0][0] == type && b[1][1] == type && b[2][2] == type) {
			this.win = true;
		}
		if(b[2][0] == type && b[1][1] == type && b[0][2] == type) {
			this.win = true;
		}
	}
	
}

class Player{
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	int[] pl = {0,0};
	
	public void place(String[][] b, String type) {
		b[pl[0]][pl[1]] = type;
	}

	public void decidePlayer(String[][] b) {
		System.out.println("test");

		while(true){
			//横の列の指定
			while(true) {
				System.out.println("横の列を指定してください： 0～2");
				this.pl[1] = scanner.nextInt();
				if(this.pl[1] < 0 || this.pl[1] > 2) {
					System.out.println("入力が正しくありません。");
					System.out.println("0～2で指定してください。");
				}else {
					break;
				}
			}
			
			//縦の列の指定
			while(true) {
				System.out.println("縦の列を指定してください： 0～2");
				pl[0] = scanner.nextInt();
				if(this.pl[0] < 0 || this.pl[0] > 2) {
					System.out.println("入力が正しくありません。");
					System.out.println("0～2で指定してください。");
				}else {
					break;
				}
			}
			
			//入力箇所の重複の確認
			if(!(b[this.pl[0]][this.pl[1]].equals("　"))) {
				System.out.println("入力箇所を変更してください。");
				continue;
			}else {
				break;
			}
		}	
	}
	
	public void decideNpc(String[][] b) {
		while(true) {
			this.pl[0] = random.nextInt(3);
			this.pl[1] = random.nextInt(3);
			
			//入力箇所の重複の確認
			if(!(b[this.pl[0]][this.pl[1]].equals("　"))) {
				continue;
			}else {
				break;
			}
		}
	}
}

