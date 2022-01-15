//############################################################
//システム名：オセロゲーム
//用途：オセロゲーム＿メイン処理
//作成日：2021-07-10
//作成者：SUS 福井
//############################################################

public class Game {
	public static void main(String[] args) {

		//盤面（GUI）に作成
		guiFrame.setFrame();

		//処理の継続フラグ、盤面のEnptyが存在しなくなるまで繰り返す
		boolean roopFlg = true;

		//初期画面表示
		Osero.showBoard();
		/*//盤面のEnptyが存在しなくなるまで繰り返す
		while(roopFlg){

			//パスチェック
			if(checkMesod.passCheck(osero.white,osero.black)) {
				//プレイヤーターン開始
				player.setStone(osero.white,osero.black);
				System.out.println("〜〜〜〜〜〜〜〜〜〜~〜〜〜〜〜結果〜〜~〜〜〜〜〜〜〜〜〜〜〜〜〜");
				osero.showBoard();
			}else {
				System.out.println("置ける場所がないため、パスされました。");
				System.out.println("");
				System.out.println("");
				osero.showBoard();
			}
			//Enpty存在チェック
			roopFlg = checkMesod.checkEnpty();
			if(!roopFlg) {
				break;
			}


			//エネミーターン開始
			Enemy.setEnemeyStone(osero.black,osero.white);
			osero.showBoard();

			//Enpty存在チェック
			roopFlg = checkMesod.checkEnpty();
			if(!roopFlg) {
				break;
			}
		}

		//勝者の判断
		int count=0;
		for(int i = 0; i<osero.board.length; i  ++) {
		      for(int j = 0; j<osero.board.length; j  ++) {
		    	  if(osero.board[i][j].equals(osero.white)) {
		    		  count++;
				  }
			  }
		  }

		if(count>32) {
		    System.out.println("プレイヤーの勝利！！");
		}else {
			System.out.println("CPUの勝利！！");
		}*/
	}
}



