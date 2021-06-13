import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 定数
        final String BLACK_STONE = "●";
        final String WHITE_STONE = "◯";
        
        var bd = new Board();
        var board = bd.board;
        
        // 描画
        var console = new Console();
        
        // この辺りからループさせる
        for (int turn = 1; turn < 78; turn++) {
            console.writeBoard(board);
            
            String stone = selectStone(turn);
        
            // ここに全面反転チェックを入れる（反転できる数は一旦気にしない方向で）
            List<Point> list = bd.allReverseCheck(stone);
            
            // 置くところがなかったらスキップ
            if (list.size() == 0) {
                console.writeSkipMessage();
                continue;
            }
            
            
            Random rand = new Random();
            int num = rand.nextInt(list.size());
            
            Point selected = list.get(num);
            
            // 行動宣言
            int x = selected.x;
            int y = selected.y;
            
            // 反転判定
            var points = bd.getReversePoints(stone, x, y);
            bd.putStone(stone, x, y); // 前提メソッドで自身を入れたらここが不要になる
            for (Point point: points) {
                bd.putStone(stone, point.x, point.y);
            }
            
            console.writePutResult(stone, x, y);
        }
        
    }
    
    public static String selectStone(int turn) {
        // 現状は宣言箇所が複数あるので、最終的には一箇所にまとめる予定
        final String BLACK_STONE = "●";
        final String WHITE_STONE = "◯";
        return (turn % 2 == 0) ? WHITE_STONE : BLACK_STONE;
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
