import java.util.*;
import java.util.stream.IntStream;

public class Board {
    // 定数
    final String BLACK_STONE = "●";
    final String WHITE_STONE = "◯";
    final String EMPTY = " ";
    String[][] board = new String[][] {
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

    public Board() {
        // 石の初期配置
        putStone(WHITE_STONE, 4, 4);
        putStone(WHITE_STONE, 5, 5);
        putStone(BLACK_STONE, 5, 4);
        putStone(BLACK_STONE, 4, 5);
    }
    
    public void putStone(String stone, int x, int y) {
        this.board[y][x] = stone;
    }
    
    private boolean isEmptySquare(int x, int y) {
        return this.board[y][x] == EMPTY;
    }
    
    private boolean isSameStone(String stone, int x, int y) {
        return this.board[y][x] == stone;
    }
    
    public List<Point> allReverseCheck(String stone) {
        List<Point> list = new ArrayList<Point>();
        IntStream.range(1, 10).forEach(y -> {
            IntStream.range(1, 10).forEach(x -> {
                var canPut = canPutStone(stone, x, y);
                if (canPut) {
                    list.add(new Point(x, y));
                }
            });
        });
        return list;
    }
    
    // public static String selectStone(int turn) {
    //     // 現状は宣言箇所が複数あるので、最終的には一箇所にまとめる予定
    //     final String BLACK_STONE = "●";
    //     final String WHITE_STONE = "◯";
    //     return (turn % 2 == 0) ? WHITE_STONE : BLACK_STONE;
    // }
    
    public boolean canPutStone(String stone, int x, int y) {
        if (!isEmptySquare(x, y)) {
            return false;
        }
        
        var upper = upper(stone, x, y);
        var lower = lower(stone, x, y);
        var right = right(stone, x, y);
        var left = left(stone, x, y);
        var upperLeft = upperLeft(stone, x, y);
        var upperRight = upperRight(stone, x, y);
        var lowerLeft = lowerLeft(stone, x, y);
        var lowerRight = lowerRight(stone, x, y);
        
        // 下手にStack を使ってしまったばかりにこんなことに・・・
        // NUll許容型使えればもっと綺麗になる
        return !(upper == null || upper.empty()) || !(lower == null || lower.empty()) || !(right == null || right.empty()) || !(left == null || left.empty()) || !(upperRight == null || upperRight.empty()) || !(upperLeft == null || upperLeft.empty()) || !(lowerRight == null || lowerRight.empty()) || !(lowerLeft == null || lowerLeft.empty());
    }
    
    public List<Point> getReversePoints(String stone, int x, int y) {
        // おいて良い場所かどうかは一旦チェックなし。
        List<Point> list = new ArrayList<Point>(); //　このやり方は本当にひどいので後で修正する
        
        var upper = upper(stone, x, y);
        mergeStackToList(list, upper);
        var lower = lower(stone, x, y);
        mergeStackToList(list, lower);
        var right = right(stone, x, y);
        mergeStackToList(list, right);
        var left = left(stone, x, y);
        mergeStackToList(list, left);
        var upperLeft = upperLeft(stone, x, y);
        mergeStackToList(list, upperLeft);
        var upperRight = upperRight(stone, x, y);
        mergeStackToList(list, upperRight);
        var lowerLeft = lowerLeft(stone, x, y);
        mergeStackToList(list, lowerLeft);
        var lowerRight = lowerRight(stone, x, y);
        mergeStackToList(list, lowerRight);
        
        return list;
    }
    
    public List<Point> mergeStackToList(List<Point> list, Stack<Point> stack) {
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
    public Stack<Point> upper(String stone, int x, int y) { // 再起じゃなくてスタックにしようか
        y -= 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || isEmptySquare(x, y)) {
            return null;
        } else if (this.board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = upper(stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public Stack<Point> lower(String stone, int x, int y) {
        y += 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || isEmptySquare(x, y)) {
            return null;
        } else if (this.board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = lower(stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public Stack<Point> right(String stone, int x, int y) {
        x += 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || isEmptySquare(x, y)) {
            return null;
        } else if (this.board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = right(stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public Stack<Point> left(String stone, int x, int y) {
        x -= 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || isEmptySquare(x, y)) {
            return null;
        } else if (this.board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = left(stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public Stack<Point> upperLeft(String stone, int x, int y) {
        x -= 1; // 面倒だったので再代入
        y -= 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || isEmptySquare(x, y)) {
            return null;
        } else if (this.board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = upperLeft(stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public Stack<Point> upperRight(String stone, int x, int y) {
        x += 1; // 面倒だったので再代入
        y -= 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || isEmptySquare(x, y)) {
            return null;
        } else if (this.board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = upperRight(stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public Stack<Point> lowerLeft(String stone, int x, int y) {
        x -= 1; // 面倒だったので再代入
        y += 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || isEmptySquare(x, y)) {
            return null;
        } else if (this.board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = lowerLeft(stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }
    
    public Stack<Point> lowerRight(String stone, int x, int y) {
        x += 1; // 面倒だったので再代入
        y += 1; // 面倒だったので再代入
        
        if (y < 1 || y > 9 || x < 1 || x > 9 || isEmptySquare(x, y)) {
            return null;
        } else if (this.board[y][x] == stone) {
            Stack<Point> stack = new Stack();
            return stack;
        } else {
            var stack = lowerRight(stone, x, y);
            if (stack == null) {
                return null;
            } else {
                stack.push(new Point(x, y));
                return stack;
            }
        }
    }    
}
