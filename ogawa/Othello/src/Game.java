import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		Board gameBoard = new Board();
		gameBoard.initialize();

		Piece currentTurn = Piece.Black;

		int inputX;
		int inputY;

		//System.out.println(gameBoard.getCurrentBoard()[3][3] == piece);

		//gameBoard.putPiece(5, 3, Piece.Black);
		//gameBoard.putPiece(5, 2, Piece.White);

		Piece[][] displayBoard = gameBoard.getCurrentBoard();

		System.out.println("　0 1 2 3 4 5 6 7 ");

		for(int i=0; i<displayBoard.length; i++) {
			System.out.print(i);
			for(int j=0; j<displayBoard[i].length; j++) {

				if(displayBoard[j][i] == Piece.Black) {
					System.out.print("●");
				} else if(displayBoard[j][i] == Piece.White) {
					System.out.print("〇");
				} else if(displayBoard[j][i] == Piece.Empty) {
					System.out.print("　");
				}

			}
			System.out.println();
		}

		while(gameBoard.getEmptySpaceCount() > 0) {

			Scanner sc = new Scanner(System.in);

			System.out.println("横の座標を入力してください");

			String inputLine1 = sc.nextLine();

			inputX = Integer.parseInt(inputLine1);	// チェックが必要

			System.out.println("縦の座標を入力してください");

			String inputLine2 = sc.nextLine();

			inputY = Integer.parseInt(inputLine2);	// チェックが必要

			if(gameBoard.putPiece(inputX, inputY, currentTurn)) {

				if(currentTurn == Piece.Black) {
					currentTurn = Piece.White;
				} else if(currentTurn == Piece.White) {
					currentTurn = Piece.Black;
				}

			} else {
				System.out.println("置けない座標です");
			}

			displayBoard = gameBoard.getCurrentBoard();

			System.out.println("　0 1 2 3 4 5 6 7 ");

			for(int i=0; i<displayBoard.length; i++) {
				System.out.print(i);
				for(int j=0; j<displayBoard[i].length; j++) {

					if(displayBoard[j][i] == Piece.Black) {
						System.out.print("●");
					} else if(displayBoard[j][i] == Piece.White) {
						System.out.print("〇");
					} else if(displayBoard[j][i] == Piece.Empty) {
						System.out.print("　");
					}

				}
				System.out.println();
			}

		}

	}

}
