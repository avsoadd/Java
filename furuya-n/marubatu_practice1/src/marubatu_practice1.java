import java.util.Scanner;

public class marubatu_practice1 {

    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("=== マルバツゲーム ===");
        printBoard();

        while (gameRunning) {
            System.out.println("あなた " + currentPlayer + " の番です。");
            System.out.print("行番号 (1-3): ");
            int row = scanner.nextInt() - 1;
            System.out.print("列番号 (1-3): ");
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("あなた " + currentPlayer + " の勝ちです！");
                    gameRunning = false;
                } else if (isBoardFull()) {
                    System.out.println("引き分けです！");
                    gameRunning = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("無効な入力です。もう一度試してください。");
            }
        }

        scanner.close();
        System.out.println("ゲーム終了。");
    }

    private static void printBoard() {
        System.out.println("  +---+---+---+");
        for (int i = 0; i < 3; i++) {
            System.out.print("  | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("  +---+---+---+");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkWin() {
        // 行と列をチェック
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // 対角線をチェック
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
