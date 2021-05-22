import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!

        // オセロを作成する

        Scanner scanner = new Scanner(System.in);
        System.out.println("コマを置く場所を入力してください");
        // 入力値を取得
        int num = scanner.nextInt();
        
        String boad[][]= {
            {"E","E","E","E","E","E","E","E","\n"},
            {"E","E","E","E","E","E","E","E","\n"},
            {"E","E","E","E","E","E","E","E","\n"},
            {"E","E","E","●","○","E","E","E","\n"},
            {"E","E","E","○","●","E","E","E","\n"},
            {"E","E","E","E","E","E","E","E","\n"},
            {"E","E","E","E","E","E","E","E","\n"},
            {"E","E","E","E","E","E","E","E","\n"}
        };
//        System.out.println(num);
        boad[num][num] = "●";
        System.out.println(boad[num][num]);
        String line = "";
        for(int i = 0; i < boad.length; i++){
            for(int j = 0; j < boad[i].length; j++){
                line = line + boad[i][j];
            }
        }
        System.out.println(line);
    }
}
