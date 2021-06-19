import java.util.ArrayList;

public class Board {

	// 盤面
	Piece[][] currentBoard = new Piece[8][8];

	// 空いている場所の数
	private int emptySpaceCount;

	public Piece[][] getCurrentBoard() {
		return currentBoard;
	}

	public int getEmptySpaceCount() {
		return emptySpaceCount;
	}

	// 盤面の初期化
	public  void initialize() {

		for(int i=0; i < currentBoard.length; i++) {
			for(int j=0; j < currentBoard[i].length; j++) {

				if((i == 3 && j == 3) || (i == 4 && j == 4)) {
					currentBoard[i][j] = Piece.Black;
				} else if((i == 3 && j == 4) || (i == 4 && j == 3)) {
					currentBoard[i][j] = Piece.White;
				} else {
					currentBoard[i][j] = Piece.Empty;
				}

			}
		}

		emptySpaceCount = 60;

	}

	public boolean putPiece(int x, int y, Piece turn) {

		boolean result = false;

		int verticalDirection;	// 縦方向
		int horizontalDirection;	// 横方向

		for(verticalDirection = -1; verticalDirection <= 1; verticalDirection++) {

			for(horizontalDirection = -1; horizontalDirection <= 1; horizontalDirection++) {

				int currentX = x;
				int currentY = y;

				currentX += horizontalDirection;
				currentY += verticalDirection;

				ArrayList<int[]> reverseList = new ArrayList<>();

				while(currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8) {	// 仮置き

					if(currentBoard[currentX][currentY] == Piece.Empty) {
						break;
					} else if(currentBoard[currentX][currentY] == turn) {

						if(reverseList.size() > 0) {

							if(!result) {
								result = true;
							}

							for(int i=0; i<reverseList.size(); i++) {

								int[] reversePoint = new int[2];
								reversePoint = reverseList.get(i);
								currentBoard[reversePoint[0]][reversePoint[1]] = turn;

							}

						}

					} else {

						int[] reversePoint = new int[2];
						reversePoint[0] = currentX;
						reversePoint[1] = currentY;
						reverseList.add(reversePoint);

					}

					currentX += horizontalDirection;
					currentY += verticalDirection;

				}

			}
		}

		if(result) {
			currentBoard[x][y] = turn;
			emptySpaceCount--;
		}

		return result;
	}



}
