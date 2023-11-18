package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class marubatu {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//ユーザの手を取得
		user_hand = user_hand();
		
		//NPCの手を取得
		npc_hand = npc_hand();
		
		user_insert(user_hand);
	
		
		insert_result();
			
	 
    

	}
	//盤面を表す２次元配列
	static int [][] ban = new int[2][2]; //{{0,0,0},{0,0,0},{0,0,0}};
	static int user_hand;
	static int npc_hand;
	
	List <Integer> list = new ArrayList();
	
	

	
    //NPCの手
    public static int npc_hand (){
	   
			Random random = new Random();
			
			int num = random.nextInt(9);
			
			return num;
   }
    
 
    //ユーザの手を入力※
  	public static int user_hand(){
  		Scanner scanner = new Scanner(System.in);
  	
  		System.out.println("あなたの取りたい場所を選択してください（入力方法:1から9の数字）");
  		int num = Integer.parseInt(scanner.next());
  		return num;
  	}
  	
  	//盤面への入力
  	public static void user_insert(int num) {
  		if(num == 1) {
  			ban[0][0] = 1;
  			
  		}else if(num == 2) {
  			ban[0][1] = 1;
  			
  		}else if(num ==3) {
  			ban[0][2] = 1;
  			
  		}else if(num == 4) {
  			ban[1][0] = 1;
  			
  		}else if(num == 5) {
  			ban[1][1] = 1;
  			
  		}else if(num == 6) {
  			ban[1][2] = 1;
  			
  		}else if(num == 7) {
  			ban[2][0] = 1;
  			
  		}else if(num == 8) {
  			ban[2][1] = 1;
  			
  		}else if(num == 9) {
  			ban[2][2] = 1;
  		}
  	}
  	
  	//盤面への入力
  	public static void npc_insert(int num) {
  		if(num == 1) {
  			ban[0][0] = 0;
  			
  		}else if(num == 2) {
  			ban[0][1] = 0;
  			
  		}else if(num ==3) {
  			ban[0][2] = 0;
  			
  		}else if(num == 4) {
  			ban[1][0] = 0;
  			
  		}else if(num == 5) {
  			ban[1][1] = 0;
  			
  		}else if(num == 6) {
  			ban[1][2] = 0;
  			
  		}else if(num == 7) {
  			ban[2][0] = 0;
  			
  		}else if(num == 8) {
  			ban[2][1] = 0;
  			
  		}else if(num == 9) {
  			ban[2][2] = 0;
  		}
  	}
  	
  	public static void insert_result() {
  		for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
             if (ban[i][j] == 1) {
             	System.out.println("盤面["+ i +"]["+ j +"]に入力しました");
             }
         }
  		}
  	}
}
