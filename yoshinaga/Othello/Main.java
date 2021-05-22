import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
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
        
        
        int turn = 0;
        
        // この辺りからループさせる
        turn++;
        String stone = selectStone(turn);
        
        
        System.out.println(canPutStone(board, stone, 5, 3));
        
        if (true) {
            return;
        }
        
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
        System.out.println(list.size());
        for (Point p: list) {
            System.out.println("-----");
            System.out.println(p.x);
            System.out.println(p.y);
        }
        
        // 置くところがなかったらスキップ
        if (list.size() == 0) {
            System.out.println();
        }
        
        
        Random rand = new Random();
        int num = rand.nextInt(list.size());
        
        Point selected = list.get(num);
        
        // 行動宣言
        int x = 4; //selected.x;
        int y = 3; //selected.y;
        System.out.println();
        System.out.println(String.format("先行は %s, %s に石を置きました。", x, y));
        
        // 反転判定
        var res = lower(board, BLACK_STONE, x, y);
        if (res != null) {
            putStone(board, BLACK_STONE, x, y);
            
            var ddd = res.pop();
            System.out.println();
            System.out.println();
            
            putStone(board, BLACK_STONE, ddd.x, ddd.y);
        }
        
        System.out.println("");
        
        for (String[] row : board) {
            System.out.println(Arrays.asList(row));
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
        } // 既においてあったらreturn
        
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
        
        System.out.println(!(upper == null || upper.empty()));
        System.out.println(!(lower == null || lower.empty()));
        System.out.println(!(left == null || left.empty()));
        System.out.println(!(right == null || right.empty()));
        System.out.println(!(upperRight == null || upperRight.empty()));
        System.out.println(!(upperLeft == null || upperLeft.empty()));
        System.out.println(!(lowerLeft == null || lowerLeft.empty()));
        System.out.println(!(lowerRight == null || lowerRight.empty()));
        return !(upper == null || upper.empty()) || !(lower == null || lower.empty()) || !(right == null || right.empty()) || !(left == null || left.empty()) || !(upperRight == null || upperRight.empty()) || !(upperLeft == null || upperLeft.empty()) || !(lowerRight == null || lowerRight.empty()) || !(lowerLeft == null || lowerLeft.empty());
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
            var stack = lower(board, stone, x, y);
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
        
        // System.out.println(x);
        // System.out.println(y);
        // System.out.println(board[y][x]);
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || board[y][x] == " ") {
        System.out.println("??");
            return null;
        } else if (board[y][x] == stone) {
        System.out.println("OK");
            Stack<Point> stack = new Stack();
            return stack;
        } else {
        System.out.println("NG");
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
            var stack = lower(board, stone, x, y);
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
            var stack = lower(board, stone, x, y);
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
            var stack = lower(board, stone, x, y);
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
            var stack = lower(board, stone, x, y);
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
        
        
        System.out.println(x);
        System.out.println(y);
        System.out.println(board[y][x]);
        
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
    
    public static Stack<Point> lowerRight(String[][] board, String stone, int x, int y) {
        x += 1; // 面倒だったので再代入
        y += 1; // 面倒だったので再代入
        
        // System.out.println(x);
        // System.out.println(y);
        // System.out.println(board[y][x]);
        
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
    
}

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
