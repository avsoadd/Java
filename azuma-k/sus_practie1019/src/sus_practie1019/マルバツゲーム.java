package sus_practie1019;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class マルバツゲーム {
    // 3x3のボードをリストのリストとして定義
    private static List<List<Character>> board = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        // ゲームを繰り返すためのループ
        do {
            initializeBoard(); // ボードの初期化
            displayBoard(); // ボードの表示
            boolean playerTurn = true; // プレイヤーのターンを示すフラグ
            while (true) {
                if (playerTurn) {
                    playerMove(); // プレイヤーの移動
                } else {
                    npcMove(); // NPCの移動
                }
                displayBoard(); // ボードを更新して表示
                String result = checkWin(); // 勝利条件をチェック
                if (!result.equals("")) {
                    System.out.println(result); // 結果を表示
                    break; // ゲームを終了
                }
                playerTurn = !playerTurn; // ターンを切り替え
            }
        } while (playAgain()); // 再プレイの確認
    }

    private static void initializeBoard() {
        // ボードを空の状態で初期化
        board.clear();
        for (int i = 0; i < 3; i++) {
            List<Character> row = new ArrayList<>(); // 行を作成
            for (int j = 0; j < 3; j++) {
                row.add('-'); // 空のセルを初期化
            }
            board.add(row); // 行をボードに追加
        }
    }

    private static void displayBoard() {
        // ボードを表示
        System.out.println("  0 1 2"); // 列番号の表示
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " "); // 行番号の表示
            for (int j = 0; j < 3; j++) {
                System.out.print(board.get(i).get(j) + " "); // 各セルの表示
            }
            System.out.println(); // 次の行に移る
        }
    }

    private static void playerMove() {
        int row, col;
        while (true) {
            // プレイヤーの入力を取得
            System.out.println("プレイヤーのターン。行と列を選択してください (0, 1, 2) :");
            if (!scanner.hasNextInt()) {
                System.out.println("無効な入力です。整数を入力してください。");
                scanner.next(); // 不正な入力をスキップ
                continue;
            }
            row = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("無効な入力です。整数を入力してください。");
                scanner.next(); // 不正な入力をスキップ
                continue;
            }
            col = scanner.nextInt();
            // 入力が有効かどうかチェック
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("無効な入力です。再試行してください。");
            } else if (board.get(row).get(col) != '-') {
                System.out.println("その位置は既に選択されています。再試行してください。");
            } else {
                board.get(row).set(col, 'X'); // プレイヤーのマークを配置
                break; // 有効な移動でループを終了
            }
        }
    }

    private static void npcMove() {
        int row, col;
        System.out.println("NPCのターン。");
        // ランダムに空いているセルを探してNPCのマークを配置
        while (true) {
            row = random.nextInt(3);
            col = random.nextInt(3);
            if (board.get(row).get(col) == '-') {
                board.get(row).set(col, 'O'); // NPCのマークを配置
                break; // 有効な移動でループを終了
            }
        }
    }

    private static String checkWin() {
        // 横と縦のチェック
        for (int i = 0; i < 3; i++) {
            if (board.get(i).get(0) == board.get(i).get(1) && board.get(i).get(1) == board.get(i).get(2) && board.get(i).get(0) != '-') {
                return board.get(i).get(0) + " の勝ち！"; // 横の勝ち
            }
            if (board.get(0).get(i) == board.get(1).get(i) && board.get(1).get(i) == board.get(2).get(i) && board.get(0).get(i) != '-') {
                return board.get(0).get(i) + " の勝ち！"; // 縦の勝ち
            }
        }
        // 斜めのチェック
        if (board.get(0).get(0) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(2) && board.get(0).get(0) != '-') {
            return board.get(0).get(0) + " の勝ち！"; // 左上から右下の勝ち
        }
        if (board.get(0).get(2) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(0) && board.get(0).get(2) != '-') {
            return board.get(0).get(2) + " の勝ち！"; // 右上から左下の勝ち
        }
        // ドローのチェック
        for (List<Character> row : board) {
            if (row.contains('-')) {
                return ""; // まだ空きがある場合
            }
        }
        return "ドロー！"; // すべてのセルが埋まった場合
    }

    private static boolean playAgain() {
        // 再プレイの確認
        System.out.println("もう一度プレイしますか？ (y/n):");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("y"); // 'y'または'Y'なら再プレイ
    }
}
