import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static String[][] aryBoard = {
			{"１", "２", "３"},
			{"４", "５", "６"},
			{"７", "８", "９"}
	};
	
	static Integer count = 9;
	static int turn = 1; // 1: 先攻, 2: 後攻

	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.printBoard();
		
		List<Integer> emptyPlace = new ArrayList<>();
		
		do {
			if(turn == 1) {
				System.out.println("プレイヤーの番：◯を書く場所を選択してください(1～9)");
			} else if(turn == 2) {
				System.out.println("CPUの番：CPUが✕を書きます");
			}
			
			Integer putPlace = 0;

			try {
				
				if(turn == 1) {
						Scanner scan = new Scanner(System.in);
						putPlace = scan.nextInt();
					
					if(aryBoard[(putPlace - 1) / 3][(putPlace - 1) % 3].equals("◯")
					 ||aryBoard[(putPlace - 1) / 3][(putPlace - 1) % 3].equals("✕")) {
						System.out.println("選択できません");
						continue;
					}
				} else if(turn == 2) {				
					emptyPlace.clear();
					Integer countPlace = 0;
					
					for(String row[] : aryBoard) {
						for(String col : row) {
							countPlace++;
							if(col != "◯" && col != "✕") {
								emptyPlace.add(countPlace);
							}
						}
					}
					
					Random random = new Random();
					int randomNum = random.nextInt(emptyPlace.size());
					putPlace = emptyPlace.get(randomNum);
				}
	
				System.out.println("選択した手は「" + putPlace + "」");
				
				main.exchange_aryBoard(putPlace);
				main.printBoard();
				
				Integer result = main.Judge();
				if(result == 1) {
					System.out.println("プレイヤーの勝利！");
					break;
				} else if(result == 2) {
					System.out.println("CPUの勝利！");
					break;
				} 
				
				if(turn == 1) {
					turn = 2;
				} else if(turn == 2) {
					turn = 1;
				}
				
				count--;
				
			} catch(InputMismatchException e) {
				System.out.println("数字を入力してください");
				continue;
			} catch(java.lang.ArrayIndexOutOfBoundsException e) {
				System.out.println("1~9の数字を入力してください");
				continue;
			}
		} while(count > 0);
	}

	public void printBoard() {
		for(String row[] : aryBoard) {
			System.out.println("----------");
			for(String col : row) {
				System.out.print("|");
				System.out.print(col);
			}
			System.out.println("|");
		}
		System.out.println("----------");
	}
	
	public void exchange_aryBoard(Integer putPlace) {
		String marubatu = "";
		
		if(turn == 1) {
			marubatu = "◯";
		} else if(turn == 2) {
			marubatu = "✕";
		}
		
		if(putPlace >= 1 && putPlace <= 3) {
			if(putPlace % 3 == 1) {
				aryBoard[0][0] = marubatu;
			} else if(putPlace % 3 == 2) {
				aryBoard[0][1] = marubatu;
			} else if(putPlace % 3 == 0) {
				aryBoard[0][2] = marubatu;
			}
		} else if(putPlace >= 4 && putPlace <= 6) {
			if(putPlace % 3 == 1) {
				aryBoard[1][0] = marubatu;
			} else if(putPlace % 3 == 2) {
				aryBoard[1][1] = marubatu;
			} else if(putPlace % 3 == 0) {
				aryBoard[1][2] = marubatu;
			}
		} else if(putPlace >= 7 && putPlace <= 9) {
			if(putPlace % 3 == 1) {
				aryBoard[2][0] = marubatu;
			} else if(putPlace % 3 == 2) {
				aryBoard[2][1] = marubatu;
			} else if(putPlace % 3 == 0) {
				aryBoard[2][2] = marubatu;
			}
		}
	}
	
	public Integer Judge() {
		// 横方向の判定
		for(int i=0; i<3; i++) {
			// プレイヤーの勝利
			if(aryBoard[i][0] == "◯" && aryBoard[i][1] == "◯" && aryBoard[i][2] == "◯") {
				return 1;
			// CPUの勝利
			}else if((aryBoard[i][0] == "✕" && aryBoard[i][1] == "✕" && aryBoard[i][2] == "✕")) {
				return 2;
			}
		}
		
		// 縦方向の判定
		for(int j=0; j<3; j++) {
			// プレイヤーの勝利
			if(aryBoard[0][j] == "◯" && aryBoard[1][j] == "◯" && aryBoard[2][j] == "◯") {
				return 1;
			// CPUの勝利
			} else if(aryBoard[0][j] == "✕" && aryBoard[1][j] == "✕" && aryBoard[2][j] == "✕") {
				return 2;
			}
		}
		
		// 斜め方向の判定
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				// プレイヤーの勝利
				if((aryBoard[0][0] == "◯" && aryBoard[1][1] == "◯" && aryBoard[2][2] == "◯")
				 ||(aryBoard[0][2] == "◯" && aryBoard[1][1] == "◯" && aryBoard[2][0] == "◯")) {
					return 1;
				// CPUの勝利
				}else if((aryBoard[0][0] == "◯" && aryBoard[1][1] == "◯" && aryBoard[2][2] == "◯")
					   ||(aryBoard[0][2] == "◯" && aryBoard[1][1] == "◯" && aryBoard[2][0] == "◯")) {
					return 2;
				}
			}
		}
		
		return 0;
	}
}
