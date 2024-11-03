import java.util.Random;
import java.util.Scanner;

public class Main {

	static Integer count = 0;
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		do{
			System.err.println("手を選択してください(1: ぐー, 2: ちょき, 3: ぱー)");

			Scanner scan = new Scanner(System.in);
			Integer playerHandNum = scan.nextInt();
			
			if(playerHandNum != 1 && playerHandNum != 2 && playerHandNum != 3) {
				System.out.println("不正な入力です");
				continue;
			}
			
			String playerHand = main.intToStr(playerHandNum);
			String cpuHand = main.cpuHand();
			
			System.out.println("プレイヤー	：" + playerHand);
			System.out.println("ＣＰＵ		：" + cpuHand);
			
			main.printResult(playerHand, cpuHand);
		} while(count < 3);

	}
	
	public String cpuHand() {
		String cpuHand = "";
		
		Random rand = new Random();
		Integer cpuHandNum = rand.nextInt(2) + 1;
		
		Main cpu = new Main();
		
		cpuHand = cpu.intToStr(cpuHandNum);
		
		return cpuHand;
	}
	
	public String intToStr(Integer handNum) {
		String handStr = "";
		
		if(handNum == 1) {
			handStr = "ぐー";
		} else if(handNum == 2) {
			handStr = "ちょき";
		} else if(handNum == 3) {
			handStr = "ぱー";
		} else {
			handStr = "不正";
		}
		
		return handStr;
	}
	
	public void printResult(String playerHand, String cpuHand) {
		if(playerHand == cpuHand) {
			System.out.println("あいこ");
		} else if(	(playerHand == "ぐー" && cpuHand == "ちょき")
				 || (playerHand == "ちょき" && cpuHand == "ぱー") 
				 || (playerHand == "ぱー" && cpuHand == "ぐー")) {
			System.out.println("プレイヤーの勝利");
			count++;
			System.out.println(count + "回目の勝利");
		} else if(	(playerHand == "ぐー" && cpuHand == "ぱー") 
				 || (playerHand == "ちょき" && cpuHand == "ぐー") 
				 || (playerHand == "ぱー" && cpuHand == "ちょき")) {
			System.out.println("プレイヤーの敗北");
		}
	}
}
