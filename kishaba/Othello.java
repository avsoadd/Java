import java.util.*;

public class Othello {
        // 黒石
        public static String black = "●";
        // 白石
        public static String white = "○";
        // ユーザの置いたコマの位置
        public static int user_posi = 0;
        // コンピュータの置いたコマの位置
        public static int ncu_posi = 0;
        // 碁盤(0:空、1:黒、2:白)
        public static int board[][]= {
	    {0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0}
	    ,{0,0,0,1,2,0,0,0}
	    ,{0,0,0,2,1,0,0,0}
	    ,{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0}
	    ,{0,0,0,0,0,0,0,0}
	};
        // ひっくり返せるコマの位置
        public static ArrayList<Integer> turnover_list = new ArrayList<>();
        // 最大値
        public static final int BOARD_LENGTH_MAX = 8;
        // 最小値
        public static final int BOARD_LENGTH_MIN = 0;

    public static void main(String[] args) throws Exception {
        // オセロを作成する

        // 初期状態を表示
        printBoard(board);

        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("コマを置く場所(縦の数字)を入力してください");
            // 縦の位置を取得
            int y = scanner.nextInt() -1;
            System.out.println("コマを置く場所(横の数字)を入力してください");
            // 横の位置を取得
            int x = scanner.nextInt() -1;

            if(board[y][x] == 0){
                // コマが置ける場所を検索する
		boolean canput = canPut(y,x);
                if(canput){
                    board[y][x] = 1;
		    turnOver();
                }
		else{
	            System.out.println("そこには置けないのでもう一度。");
		}
                printBoard(board);
            }
            else{
                System.out.println("すでにコマが置かれている場所は置けません。もう一度。");
            }
        }while(true);
    } 

    public static void printBoard(int board[][]){
       StringBuilder line = new StringBuilder();
    	line.append(" | 1 2 3 4 5 6 7 8 \n");
        line.append("―――――――――\n");
    
        for(int i = 0; i < board.length; i++){
            line.append(i+1);
            line.append("|");
            for(int j = 0; j < board[i].length; j++){
	        switch(board[i][j]){
		    case 0:
	                line.append("　");
	            	break;
		    case 1:
	                line.append("●");
        		break;
	            case 2:
	                line.append("○");
         		break;
                }
            }
            line.append("\n");
        }
        System.out.println(line);
    }

    public static boolean canPut(int y, int x){
	// 八方向の直線でみていく
	int target = 0;

	// 上
	if(board[y-1][x] == 2){
		turnover_list.add(y-1);
		turnover_list.add(x);
		for(int y_target = y - 2; y_target > BOARD_LENGTH_MIN; y_target--){
		    target = board[y_target][x];
		    if(target == 1){
		       return true;
		    }
		    if(target == 2){
			turnover_list.add(y_target);
			turnover_list.add(x);
			continue;
		    }
		    if(target == 0){
		        break;
		    }
		}
	}

	// 下
	turnover_list.clear();
	if(board[y+1][x] == 2){
		turnover_list.add(y+1);
		turnover_list.add(x);
		for(int y_target = y + 2; y_target < BOARD_LENGTH_MAX; y_target++){
		    target = board[y_target][x];
		    if(target == 1){
		        return true;
		    }
		    if(target == 2){
			turnover_list.add(y_target);
			turnover_list.add(x);
			continue;
		    }
		    if(target == 0){
		        break;
		    }
		}
	}

	// 左
	turnover_list.clear();
	if(board[y][x-1] == 2){
		turnover_list.add(y);
		turnover_list.add(x-1);
		for(int x_target = x - 2; x_target > BOARD_LENGTH_MIN; x_target--){
		    target = board[y][x_target];
		    if(target == 1){
		       return true;
		    }
		    if(target == 2){
			turnover_list.add(y);
			turnover_list.add(x_target);
			continue;
		    }
		    if(target == 0){
		        break;
		    }
		}
	}

	// 右
	turnover_list.clear();
	if(board[y][x+1] == 2){
		turnover_list.add(y);
		turnover_list.add(x+1);
		for(int x_target = x + 2; x_target < BOARD_LENGTH_MAX; x_target++){
		    target = board[y][x_target];
		    if(target == 1){
		       return true;
		    }
		    if(target == 2){
			turnover_list.add(y);
			turnover_list.add(x_target);
			continue;
		    }
		    if(target == 0){
		        break;
		    }
		}
	}

	// 左上
	turnover_list.clear();
	if(board[y-1][x-1] == 2){
		turnover_list.add(y-1);
		turnover_list.add(x-1);
		for(int y_target = y - 2, x_target = x - 2; y_target > BOARD_LENGTH_MIN && x_target > BOARD_LENGTH_MIN; y_target--, x_target--){
		    target = board[y_target][x_target];
		    if(target == 1){
		       return true;
		    }
		    if(target == 2){
			turnover_list.add(y_target);
			turnover_list.add(x_target);
			continue;
		    }
		    if(target == 0){
		        break;
		    }
		}
	}

	// 左下
	turnover_list.clear();
	if(board[y+1][x-1] == 2){
		turnover_list.add(y+1);
		turnover_list.add(x-1);
		for(int y_target = y + 2, x_target = x - 2; y_target < BOARD_LENGTH_MAX && x_target > BOARD_LENGTH_MIN; y_target++, x_target--){
		    target = board[y_target][x_target];
		    if(target == 1){
		       return true;
		    }
		    if(target == 2){
			turnover_list.add(y_target);
			turnover_list.add(x_target);
			continue;
		    }
		    if(target == 0){
		        break;
		    }
		}
	}

	// 右下
	turnover_list.clear();
	if(board[y+1][x+1] == 2){
		turnover_list.add(y+1);
		turnover_list.add(x+1);
		for(int y_target = y + 2, x_target = x + 2; y_target < BOARD_LENGTH_MAX && x_target < BOARD_LENGTH_MAX; y_target++, x_target++){
		    target = board[y_target][x_target];
		    if(target == 1){
		       return true;
		    }
		    if(target == 2){
			turnover_list.add(y_target);
			turnover_list.add(x_target);
			continue;
		    }
		    if(target == 0){
		        break;
		    }
		}
	}

	// 右上
	turnover_list.clear();
	if(board[y-1][x+1] == 2){
		turnover_list.add(y-1);
		turnover_list.add(x+1);
		for(int y_target = y - 2, x_target = x + 2; y_target > BOARD_LENGTH_MIN && x_target < BOARD_LENGTH_MAX; y_target--, x_target++){
		    target = board[y_target][x_target];
		    if(target == 1){
		       return true;
		    }
		    if(target == 2){
			turnover_list.add(y_target);
			turnover_list.add(x_target);
			continue;
		    }
		    if(target == 0){
		        break;
		    }
		}
	}
	return false;
    }

    public static void turnOver(){
	int y = 0;
	int x = 0;

	for(int i = 0; i < turnover_list.size() - 1; i = i + 2){
		y = turnover_list.get(i);
		x = turnover_list.get(i + 1);
		
		if(board[y][x] == 1){
		    board[y][x] = 2;
		}
		if(board[y][x] == 2){
		    board[y][x] = 1;
		}
	}
    }
}
