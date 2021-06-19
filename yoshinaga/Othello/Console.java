import java.util.*;

public class Console {
    // write と read でクラスを分けるかどうかは検討中
    
    public void writeBoard(String[][] board) {
        for (String[] row : board) {
            System.out.println(Arrays.asList(row));
        }
    }
    
    public void writeSkipMessage() {
        System.out.println("置く場所が無かった為、ターンをスキップしました。");
    }
    
    public void writePutResult(String stone, int x, int y) {
        System.out.println();
        System.out.println(String.format("%s, %s に %s を置きました。", x, y, stone));
    }
}