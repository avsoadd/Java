package marubatsu;

import java.util.*;

public class Main {

    public static void main(String[] args) {
		Random r = new Random();
		Scanner scan = new Scanner(System.in);

	    int[][] field = {{0,0,0}
                         ,{0,0,0}
	                     ,{0,0,0}};

		printField(field);

		for(int i =0;i<5 ;i++){
			System.out.println("COMの番です。");

			while(true){
				int com_i = r.nextInt(3);
				int com_j = r.nextInt(3);

				System.out.println(com_i);

				if(field[com_i][com_j] == 0){
					field[com_i][com_j] = 1;
					break;
				}
			}


			printField(field);

			if(hantei(field)==1){
				System.out.println("COMの勝ちです");
				break;
			}

			if(i==4){
				break;
			}

			System.out.println("あなたの番です。");
			System.out.println("手を入力してください。");


			while(true){
				String[] player = scan.nextLine().split("");
				int player_i = Integer.parseInt(player[0]);
				int player_j = Integer.parseInt(player[1]);


				if(field[player_i][player_j] == 0){
					field[player_i][player_j] = 2;
					break;
				}else{
					System.out.println("もう一度入力してください");
				}
			}


			printField(field);

			if(hantei(field)==2){
				System.out.println("あなたの勝ちです");
				break;
			}

		}






    }

    public static void printField(int[][] field){
		for(int i = 0; i < 3 ; i++){
			for(int j = 0; j<3; j++){
				if(field[i][j] == 0) {
					if (j != 2) {
						System.out.print("・　");
					} else {
						System.out.println("・");
					}
				}else if (field[i][j] == 1) {
					if (j != 2) {
						System.out.print("●　");
					} else {
						System.out.println("●");
					}
				} else if (field[i][j] == 2) {
					if (j != 2) {
						System.out.print("×　");
					} else {
						System.out.println("×");
					}
				}


			}

		}
    }


    public static int hantei(int[][] field){
    	if(field[0][0] == field[0][1] && field[0][0] == field[0][2] && field[0][0]==1
		  || field[1][0] == field[1][1] && field[1][0] == field[1][2] && field[1][0]==1
		  || field[2][0] == field[2][1] && field[2][0] == field[2][2] && field[2][0]==1
		  || field[0][0] == field[1][0] && field[0][0] == field[2][0] && field[0][0]==1
		  || field[0][1] == field[1][1] && field[0][1] == field[2][1] && field[0][1]==1
		  || field[0][2] == field[1][2] && field[0][2] == field[2][2] && field[0][2]==1
		  || field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0]==1
		  || field[0][2] == field[1][1] && field[0][2] == field[2][0] &&field[0][2]==1){
			return 1;
		}else if(field[0][0] == field[0][1] && field[0][0] == field[0][2] && field[0][0]==2
				|| field[1][0] == field[1][1] && field[1][0] == field[1][2] && field[1][0]==2
				|| field[2][0] == field[2][1] && field[2][0] == field[2][2] && field[2][0]==2
				|| field[0][0] == field[1][0] && field[0][0] == field[2][0] && field[0][0]==2
				|| field[0][1] == field[1][1] && field[0][1] == field[2][1] && field[0][1]==2
				|| field[0][2] == field[1][2] && field[0][2] == field[2][2] && field[0][2]==2
				|| field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0]==2
				|| field[0][2] == field[1][1] && field[0][2] == field[2][0] &&field[0][2]==2){
			return 2;
		}else{

            return 0;

		}


    }







}
