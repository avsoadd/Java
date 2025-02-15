public class Hello {
    public static void main(String[] args) {
        // 3x3の配列を宣言
        int[][] array = new int[3][3];

        // 配列に値を設定
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = i * 3 + j + 1; // 任意の値を設定
            }
        }

        // 配列の内容を出力
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        
        
        
        
        
        
        
        
        
    }
}