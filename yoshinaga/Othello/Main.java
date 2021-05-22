import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        // 定数
        final String BLACK_STONE = "●";
        final String WHITE_STONE = "◯";

        // 初期ボード
        var board = new String[][] {
            { " -", "1", "2", "3", "4", "5", "6", "7", "8", "9" },
            { " 1", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " 2", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " 3", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " 4", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " 5", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " 6", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " 7", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " 8", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " 9", " ", " ", " ", " ", " ", " ", " ", " ", " " }
        };
        
        // 石の初期配置
        putStone(board, WHITE_STONE, 4, 4);
        putStone(board, WHITE_STONE, 5, 5);
        putStone(board, BLACK_STONE, 5, 4);
        putStone(board, BLACK_STONE, 4, 5);
        
        // 描画
        for (String[] row : board) {
            System.out.println(Arrays.asList(row));
        }
        
        
        // この辺りからループさせる
        for (int turn = 1; turn < 78; turn++) {
            String stone = selectStone(turn);
            System.out.println(stone);
        
            // ここに全面反転チェックを入れる（反転できる数は一旦気にしない方向で）
            List<Point> list = new ArrayList<Point>();
            for (int y: new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }) {
                for (int x: new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }) {
                    var canPut = canPutStone(board, stone, x, y);
                    if (canPut) {
                        list.add(new Point(x, y));
                    }
                }
            }
            
            // 置くところがなかったらスキップ
            if (list.size() == 0) {
                System.out.println("置く場所が無かった為、ターンをスキップしました。");
                continue;
            }
            
            
            Random rand = new Random();
            int num = rand.nextInt(list.size());
            
            Point selected = list.get(num);
            
            // 行動宣言
            int x = selected.x;
            int y = selected.y;
            
            // 反転判定
            var points = getReversePoints(board, stone, x, y);
            putStone(board, stone, x, y);
            if (points != null) {
                // 正常動作
                for (Point point: points) {
                    putStone(board, stone, point.x, point.y);
                }   
            } else {
                // なんか想定外の動作があったのでチェック用
                System.out.println("------");
                System.out.println(x);
                System.out.println(y);
                System.out.println(stone);
                return;
            }
            
            System.out.println();
            System.out.println(String.format("先行は %s, %s に石を置きました。", x, y));
            System.out.println("");
            
            for (String[] row : board) {
                System.out.println(Arrays.asList(row));
            }
        }
        
        
    }
    
    public static void putStone(String[][] board, String stone, int x, int y) {
        board[y][x] = stone;
    }
    
    public static String selectStone(int turn) {
        // 現状は宣言箇所が複数あるので、最終的には一箇所にまとめる予定
        final String BLACK_STONE = "●";
        final String WHITE_STONE = "◯";
        return (turn % 2 == 0) ? WHITE_STONE : BLACK_STONE;
    }
    
    public static boolean canPutStone(String[][] board, String stone, int x, int y) {
        if (board[y][x] != " ") {
            return false;
        }
        
        var upper = upper(board, stone, x, y);
        var lower = lower(board, stone, x, y);
        var right = right(board, stone, x, y);
        var left = left(board, stone, x, y);
        var upperLeft = upperLeft(board, stone, x, y);
        var upperRight = upperRight(board, stone, x, y);
        var lowerLeft = lowerLeft(board, stone, x, y);
        var lowerRight = lowerRight(board, stone, x, y);
        
        // 下手にStack を使ってしまったばかりにこんなことに・・・
        // NUll許容型使えればもっと綺麗になる
        return !(upper == null || upper.empty()) || !(lower == null || lower.empty()) || !(right == null || right.empty()) || !(left == null || left.empty()) || !(upperRight == null || upperRight.empty()) || !(upperLeft == null || upperLeft.empty()) || !(lowerRight == null || lowerRight.empty()) || !(lowerLeft == null || lowerLeft.empty());
    }
    
    public static List<Point> getReversePoints(String[][] board, String stone, int x, int y) {
        // おいて良い場所かどうかは一旦チェックなし。
        List<Point> list = new ArrayList<Point>(); //　このやり方は本当にひどいので後で修正する
        
        var upper = upper(board, stone, x, y);
        mergeStackToList(list, upper);
        var lower = lower(board, stone, x, y);
        mergeStackToList(list, lower);
        var right = right(board, stone, x, y);
        mergeStackToList(list, right);
        var left = left(board, stone, x, y);
        mergeStackToList(list, left);
        var upperLeft = upperLeft(board, stone, x, y);
        mergeStackToList(list, upperLeft);
        var upperRight = upperRight(board, stone, x, y);
        mergeStackToList(list, upperRight);
        var lowerLeft = lowerLeft(board, stone, x, y);
        mergeStackToList(list, lowerLeft);
        var lowerRight = lowerRight(board, stone, x, y);
        mergeStackToList(list, lowerRight);
        
        return list;
    }
    
    public static List<Point> mergeStackToList(List<Point> list, Stack<Point> stack) {
        if (stack == null) {
            return null;
        }
        // List<Point> list = new ArrayList<Point>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
    
    // 同じ色：反転
    // 違う色：継続
    // 空 or 境界外：終了
    // 戻り値をスタックにして入れる？
    public static Stack<Point> upper(String[][] board, String stone, int x, int y) {
        y -= 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
            return null;
        } else if (board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = upper(board, stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public static Stack<Point> lower(String[][] board, String stone, int x, int y) {
        y += 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
            return null;
        } else if (board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = lower(board, stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public static Stack<Point> right(String[][] board, String stone, int x, int y) {
        x += 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
            return null;
        } else if (board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = right(board, stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public static Stack<Point> left(String[][] board, String stone, int x, int y) {
        x -= 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
            return null;
        } else if (board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = left(board, stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public static Stack<Point> upperLeft(String[][] board, String stone, int x, int y) {
        x -= 1; // 面倒だったので再代入
        y -= 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
            return null;
        } else if (board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = upperLeft(board, stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public static Stack<Point> upperRight(String[][] board, String stone, int x, int y) {
        x += 1; // 面倒だったので再代入
        y -= 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
            return null;
        } else if (board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = upperRight(board, stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public static Stack<Point> lowerLeft(String[][] board, String stone, int x, int y) {
        x -= 1; // 面倒だったので再代入
        y += 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
            return null;
        } else if (board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = lowerLeft(board, stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public static Stack<Point> lowerRight(String[][] board, String stone, int x, int y) {
        x += 1; // 面倒だったので再代入
        y += 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
            return null;
        } else if (board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = lowerRight(board, stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
}

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 勝ち負けの判定入れるの忘れてた
// スキップしたときに石の色おかしくなるってことに気づいたので要修正
