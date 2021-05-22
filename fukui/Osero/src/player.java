import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class player {

	//○の設置
	static public void setStone() {

		 boolean turnEnd = true; //置けなかった場合のフラグ

		 String white_x; //○のX位置
		 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		 String white_y; //○のY位置
		 BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));


		 //○の位置をプレイヤーに決定させる
		 while(turnEnd) {
		 try {

			  System.out.println("【先手石：○】");
		   	  System.out.println("↓↓↓↓↓X軸の置く場所を決めて下さい↓↓↓↓↓");

              //入力された数字を元に盤面の番地を割り出す
			  white_x = br1.readLine();
			  int x = Integer.valueOf(white_x).intValue();
			  int[] date = checkMesod.checkBanmen(x);

			if(osero.board[date[1]][date[2]].equals(osero.enpty)) {
			 	//ひっくり返す処理
				 //上へ確認
			    for(int i = 1; i<7; i++) {
			    	int t=y-i-1;
						if(1<=t) {
							if(osero.board[y-i][x].equals(osero.black)){
			                if(osero.board[t][x].equals(osero.white)){
			            	   for(int k=0; k<=i; k++) {
			            		   osero.board[y][x] = osero.white;
				               //○にひっくり返す
			            		   osero.board[y-k][x] = osero.white;
				   			    turnEnd = false;}
			   			     }else {turnEnd = false;}
							}
						   }
						  }

			   	 //右斜め上へ確認
				if(osero.board[y-1][x+1].equals(osero.black)){
					osero.board[y][x] = osero.white;
			   	 for(int i = 1; i<7; i++) {
			   		int t=y-1-i;
			   		 int j=x+1+i;
			   	if(1<=t&&j<=8) {
			     if(osero.board[y-1][x+1].equals(osero.black)) {
			    	 if(osero.board[t][j].equals(osero.white)){
			    		 for(int k=0; k<=i; k++) {
				            //○にひっくり返す
			    			 osero.board[y-k][x+k] = osero.white;
				   			turnEnd = false;}
			    		 }
			    	    }
			           }
			   	      }
			         }

			     //右へ確認
			   	if(osero.board[y][x+1].equals(osero.black)){
			   		osero.board[y][x] = osero.white;
			   	 for(int i = 1; i<7; i++) {
			   		int j=x+1+i;
				   	 if(j<=8) {
			          if(osero.board[y][x+1].equals(osero.black)) {
			    	   if(osero.board[y][j].equals(osero.white)){
			    		 for(int k=0; k<=i; k++) {

			    			 //○にひっくり返す
			    			 osero.board[y][x+k] = osero.white;
				   			turnEnd = false;}
			    		 }
			    	    }
			           }
				   	  }
			   	     }

			     //右斜め下へ確認
	  			if(osero.board[y+1][x+1].equals(osero.black)){
	  				osero.board[y][x] = osero.white;
		     	   	for(int i = 1; i<7; i++) {
		     	   	int t=y+1+i;
		     	   	int j=x+1+i;
				   	if(t<=8&&j<=8) {
			    if(osero.board[y+1][x+1].equals(osero.black)) {
			    	if(osero.board[t][j].equals(osero.white)){
			    		for(int k=0; k<=i; k++) {
			            //○にひっくり返す
			    			osero.board[y+k][x+k] = osero.white;
			   			turnEnd = false;}
			    	}
			       }
			      }
				 }
		     	}

		     	 //下への確認
		        if(osero.board[y+1][x].equals(osero.black)){
		        	osero.board[y][x] = osero.white;
		     	   	for(int i = 1; i<7; i++) {
		     	   	int t=y+1+i;
				   	if(t<=8) {
			    if(osero.board[y+1][x].equals(osero.black)) {
			    	if(osero.board[t][x].equals(osero.white)){
			    		for(int k=0; k<=i; k++) {
			            //○にひっくり返す
			    			osero.board[y+k][x] = osero.white;
			   			turnEnd = false;}
			    	}
			       }
			      }
				 }
		     	}

		        //左斜め下への確認
		     	if(osero.board[y+1][x-1].equals(osero.black)){
		     		osero.board[y][x] = osero.white;
		     	   	for(int i = 1; i<7; i++) {
		     	   	int t=y+1+i;
		     	   	int j=x-1-i;
				   	if(t<=8&&1<=j) {
			    if(osero.board[y+1][x-1].equals(osero.black)) {
			    	if(osero.board[t][j].equals(osero.white)){
			    		for(int k=0; k<=i; k++) {
			            //○にひっくり返す
			    			osero.board[y+k][x-k] = osero.white;
			   			turnEnd = false;}
			    	}
			       }
			      }
				 }
		     	}

		     	   //左への確認
		     	  if(osero.board[y][x-1].equals(osero.black)){
		     		 osero.board[y][x] = osero.white;
		     	   	for(int i = 1; i<7; i++) {
		     	   	int j=x-1-i;
				   	if(1<=j) {
			       if(osero.board[y][x-1].equals(osero.black)) {
			    	 if(osero.board[y][j].equals(osero.white)){
			    		for(int k=0; k<=i; k++) {
			            //○にひっくり返す
			    			osero.board[y][x-k] = osero.white;
			   			turnEnd = false;}
			    	}
			       }
			      }
		     	 }
		     	}

		     	  //左斜め上への確認
		     	 if(osero.board[y-1][x-1].equals(osero.black)){
		     		osero.board[y][x] = osero.white;
		     	   	for(int i = 1; i<7; i++) {
		     	   	int t=y-1-i;
	     	   		int j=x-1-i;
	     	     if(1<=t&&1<=j) {
			      if(osero.board[y-1][x-1].equals(osero.black)) {
			    	if(osero.board[t][j].equals(osero.white)){
			    		for(int k=0; k<=i; k++) {
			            //○にひっくり返す
			    			osero.board[y-k][x-k] = osero.white;
			   			turnEnd = false;}
			    	}
			       }
			      }
	     	     }
		     	}
			   }
		      } catch (IOException e) {
			   // TODO 自動生成された catch ブロック
			   e.printStackTrace();}
	  }
	}

	//●の位置
	static public void rev_setStone() {

		 boolean turnEnd = true; //置けなかった場合のフラグ

		 String black_x; //●のX位置
		 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		 String black_y; //●のY位置
		 BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

		//●の位置をプレイヤーに決定させる
		 while(turnEnd) {
		 try {
			    System.out.println("【後手石：●】");
				System.out.println("↓↓↓↓↓X軸の置く場所を決めて下さい↓↓↓↓↓");

				black_x = br1.readLine();
				int x = Integer.valueOf(black_x).intValue();

				System.out.println("↓↓↓↓↓Y軸の置く場所を決めて下さい↓↓↓↓↓");

				black_y = br2.readLine();
				int y = Integer.valueOf(black_y).intValue();

				if(osero.board[y][x].equals(osero.enpty)) {
				 	//ひっくり返す処理
					 //上へ確認
				   	if(osero.board[y-1][x].equals(osero.white)){
				   		osero.board[y][x] = osero.black;
				     for(int i = 1; i<7; i++) {
				    int t=y-1-i;
					if(1<=t) {
				     if(osero.board[t][x].equals(osero.black)){
				    	 for(int k=0; k<=i; k++) {
				            //○にひっくり返す
				    		 osero.board[y-k][x] = osero.black;
				   			turnEnd = false;}
				    	 }
				        }
					   }
				      }

				   	 //右斜め上へ確認
					if(osero.board[y-1][x+1].equals(osero.white)){
						osero.board[y][x] = osero.black;
				   	 for(int i = 1; i<7; i++) {
				   		 int t=y-1-i;
				   		 int j=x+1+i;
				   	if(1<=t&&j<=8) {
				     if(osero.board[y-1][x+1].equals(osero.white)) {
				    	 if(osero.board[t][j].equals(osero.black)){
				    		 for(int k=0; k<=i; k++) {
					            //○にひっくり返す
				    			 osero.board[y-k][x+k] = osero.black;
					   			turnEnd = false;}
				    		 }
				    	    }
				           }
				   	      }
				   	     }

				     //右へ確認
				   	if(osero.board[y][x+1].equals(osero.white)){
				   		osero.board[y][x] = osero.black;
				   	 for(int i = 1; i<7; i++) {
				   		int j=x+1+i;
					   	if(j<=8) {
				     if(osero.board[y][x+1].equals(osero.white)) {
				    	 if(osero.board[y][j].equals(osero.black)){
				    		 for(int k=0; k<=i; k++) {
					            //○にひっくり返す
				    			 osero.board[y][x+k] = osero.black;
					   			turnEnd = false;}
				    		 }
				    	    }
				           }
					   	  }
				   	     }

				     //右斜め下へ確認
		  			if(osero.board[y+1][x+1].equals(osero.white)){
		  				osero.board[y][x] = osero.black;
			     	   	for(int i = 1; i<7; i++) {
			     	   	int t=y+1+i;
			     	   	int j=x+1+i;
					   	if(t<=8&&j<=8) {
				    if(osero.board[y+1][x+1].equals(osero.white)) {
				    	if(osero.board[t][j].equals(osero.black)){
				    		for(int k=0; k<=i; k++) {
				            //○にひっくり返す
				    			osero.board[y+k][x+k] = osero.black;
				   			turnEnd = false;}
				    	  }
				    	 }
				        }
					   }
			     	  }

			     	  //下への確認
			     	if(osero.board[y+1][x].equals(osero.white)){
			     		osero.board[y][x] = osero.black;
			     	   	for(int i = 1; i<7; i++) {
			     	   	int t=y+1+i;
					   	if(t<=8) {
				    if(osero.board[y+1][x].equals(osero.white)) {
				    	if(osero.board[t][x].equals(osero.black)){
				    		for(int k=0; k<=i; k++) {
				            //○にひっくり返す
				    			osero.board[y+k][x] = osero.black;
				   			turnEnd = false;}
				    	  }
				    	 }
				        }
					   }
			     	  }

			     	   //左斜め下への確認
			     	   if(osero.board[y+1][x-1].equals(osero.white)){
			     		  osero.board[y][x] = osero.black;
			     	   	for(int i = 1; y+1+i<5; i++) {
			     	   	int t=y+1+i;
			     	   	int j=x-1-i;
					   	if(t<=8&&1<=j) {
				       if(osero.board[y+1][x-1].equals(osero.white)) {
				         if(osero.board[t][j].equals(osero.black)){
				    		for(int k=0; k<=i; k++) {
				            //○にひっくり返す
				    			osero.board[y+k][x-k] = osero.black;
				   			turnEnd = false;}
				    	}
				       }
				      }
					 }
			     	}

			     	   //左への確認
			     	  if(osero.board[y][x-1].equals(osero.white)){
			     		 osero.board[y][x] = osero.black;
			     	   	for(int i = 1; i<7; i++) {
			     	   		int j=x-1-i;
			           if(1<=j) {
				        if(osero.board[y][x-1].equals(osero.white)) {
				    	 if(osero.board[y][j].equals(osero.black)){
				    		for(int k=0; k<=i; k++) {
				            //○にひっくり返す
				    			osero.board[y][x-k] = osero.black;
				   			turnEnd = false;}
				    	}
				       }
				      }
			         }
			     	}

			     	  //左斜め上への確認
			     	 if(osero.board[y-1][x-1].equals(osero.white)){
			     		osero.board[y][x] = osero.black;
			     	   	for(int i = 1; i<7; i++) {
			     	   		int t=y-1-i;
			     	   		int j=x-1-i;
			     	if(1<=t&&1<=j) {
				    if(osero.board[y-1][x-1].equals(osero.white)) {
				    	if(osero.board[t][j].equals(osero.black)){
				    		for(int k=0; k<=i; k++) {
				            //○にひっくり返す
				    			osero.board[y-k][x-k] = osero.black;
				   			turnEnd = false;}
				    	}
				       }
				      }
			     	 }
			     	}
				   }
			      } catch (IOException e) {
				   // TODO 自動生成された catch ブロック
				   e.printStackTrace();}
		  }
		}
	}


