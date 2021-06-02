import java.util.*;

public class Othello {
        // 黒石
        public static String brack = "●";
        // 白石
        public static String white = "○";
        // ユーザの置いたコマの位置
        public static String user_posi = "";
        // コンピュータの置いたコマの位置
        public static String ncu_posi = "";
        // 碁盤
        public static String boad[][]= {
            {" |"," 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8","\n"},
            {"1|","  ","  ","  ","  ","  ","  ","  ","  ","\n"},
            {"2|","  ","  ","  ","  ","  ","  ","  ","  ","\n"},
            {"3|","  ","  ","  ","  ","  ","  ","  ","  ","\n"},
            {"4|","  ","  ","  ","●","○","  ","  ","  ","\n"},
            {"5|","  ","  ","  ","○","●","  ","  ","  ","\n"},
            {"6|","  ","  ","  ","  ","  ","  ","  ","  ","\n"},
            {"7|","  ","  ","  ","  ","  ","  ","  ","  ","\n"},
            {"8|","  ","  ","  ","  ","  ","  ","  ","  ","\n"}
        };
        // 選択位置の周り
        public static int array[] = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        // オセロを作成する

        // 初期状態を表示
        printBoad(boad);

        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("コマを置く場所(縦の数字)を入力してください");
            // 縦の位置を取得
            int y = scanner.nextInt();
            System.out.println("コマを置く場所(横の数字)を入力してください");
            // 横の位置を取得
            int x = scanner.nextInt();
        
            user_posi = boad[y][x];

            if(user_posi.trim()== ""){
                // コマが置ける場所を検索する
                boolean check = true;
                String target = "";
                for(int y_posi : array){
                    for(int x_posi : array){
                        target = boad[y + y_posi][x + x_posi].trim();
                        if((y_posi != 0 || x_posi != 0) && target == ""){
                            check = true;
                        }
                    }    
                }
                if(check){
                    boad[y][x] = brack;
                }
                printBoad(boad);
            }
            else{
                System.out.println("すでにコマが置かれている場所は置けません。終了します。");
                break;
            }
        }while(true);
    } 

    public static void printBoad(String boad[][]){
        String line = "";
        for(int i = 0; i < boad.length; i++){
            for(int j = 0; j < boad[i].length; j++){
                line = line + boad[i][j];
            }
            if(i == 0){
                line = line + "―――――――――\n";
            }
        }
        System.out.println(line);
    }
}
