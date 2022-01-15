import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//############################################################
//システム名：オセロゲーム
//用途：各種チェック処理
//作成日：2021-07-10
//作成者：SUS 福井
//############################################################
public class CheckMesod {

	//############################################################
	//用途：1~64の値に応じて、それに対応する画面の番地を配列で返す
	//     例：１→［0,8]に変換して返す
	//引数：1~64の値
	//作成日：2021-07-10
	//作成者：SUS 福井
	//############################################################
	static public int[] CheckBanmen(int stone) {

		int date[] = new int[2];  //オセロの位置情報

		//入力内容に応じて数値を切り分け
	    //y軸の設定
		if(1 <= stone && 8 >= stone ) {
			date[0] = 0;
		}else if(9 <= stone && 16 >= stone ){
			date[0] = 1;
		}else if(17 <= stone && 24 >= stone ){
			date[0] = 2;
		}else if(25 <= stone && 32 >= stone ){
			date[0] = 3;
		}else if(33 <= stone && 40 >= stone ){
			date[0] = 4;
		}else if(41 <= stone && 48 >= stone ){
			date[0] = 5;
		}else if(49 <= stone && 56 >= stone ){
			date[0] = 6;
		}else if(57 <= stone && 64 >= stone ){
			date[0] = 7;
		}

	    //x軸の設定
		if(stone == 1 || stone == 9 || stone == 17 || stone == 25
				|| stone == 33 || stone == 41 || stone == 49 || stone == 57 ) {
			date[1] = 8;
		}
		if(stone == 2 || stone == 10 || stone == 18 || stone == 26
				  || stone == 34 || stone == 42 || stone ==50  || stone == 58 ) {
			date[1] = 9;
		}
		if(stone == 3 || stone == 11 || stone == 19 || stone == 27
				  || stone == 35 || stone == 43 || stone == 51 || stone == 59 ) {
			date[1] = 10;
		}
		if(stone == 4 || stone == 12 || stone == 20 || stone == 28
				  || stone == 36 || stone == 44 || stone == 52 || stone == 60 ) {
			date[1] = 11;
		}
		if(stone == 5 || stone == 13 || stone == 21 || stone == 29
				  || stone == 37 || stone == 45 || stone == 53 || stone == 61 ) {
			date[1] = 12;
		}
		if(stone == 6 || stone == 14 || stone == 22 || stone == 30
				  || stone == 38 || stone == 46 || stone == 54 || stone == 62 ) {
			date[1] = 13;
		}
		if(stone == 7 || stone == 15 || stone == 23 || stone == 31
				  || stone == 39 || stone == 47 || stone == 55 || stone == 63 ) {
			date[1] = 14;
		}
		if(stone == 8 || stone == 16 || stone == 24 || stone == 32
				  || stone == 40 || stone == 48 || stone == 56 || stone == 64 ) {
			date[1] = 15;
		}
		return date;
	}


	//############################################################
	//用途：盤面に石が置かれていない場所があるかをチェックする
	//引数：なし
	//戻り値：ある場合：true
	//       ない場合:false
	//作成日：2021-07-10
	//作成者：SUS 福井
	//############################################################
	static public boolean checkEnpty() {
		//盤面に石が置かれているかの判断フラグ
		boolean enptyResult = false;

		for(int checkPoint =1; checkPoint<=64; checkPoint++) {
			int[] date = CheckMesod.CheckBanmen(checkPoint);
			int y = date[0];  //縦座標
			int x = date[1];  //横座標

			if(Osero.board[y][x].equals(Osero.enpty)) {
				enptyResult = true;
			}
		}
		return enptyResult;

	}

	//############################################################
	//用途：盤面に石を置ける場所があるかをチェックする
	//引数：なし
	//戻り値：ある場合：true
	//       ない場合:false
	//作成日：2021-07-10
	//作成者：SUS 福井
	//############################################################
	static public boolean passCheck(String stone1, String stone2) {
		int TopStopCheck = 0 ;   	//上方向の確認下限変数
		int RTStopCheck = 0 ;   	//右上方向の確認下限変数
		int RStopCheck = 15 ;   	//右方向の確認下限変数
		int BottomStopCheck = 7 ; 	//下方向の確認下限変数
		int LStopCheck = 8 ;     	//左方向の確認下限変数
		String chgFlg = "false";


		//期待値の格納用のMAP
		Map<Integer, Integer> setMap = new HashMap<>();


		//1~64までの要素を順番にx,yにつめる
		for(int checkPoint =1; checkPoint<=64; checkPoint++) {
			int totalChgCount = 0;
			int[] date = CheckMesod.CheckBanmen(checkPoint);
			int y = date[0];  //縦座標
			int x = date[1];  //横座標

			//各配置場所待値を計算
				//指定箇所がEかのチェック
				if(Osero.board[y][x].equals(Osero.enpty)) {
					//上へ確認
					//上方向の縦座標の下限を設定
					TopStopCheck = 0;
					ArrayList<ArrayList> toplist = new ArrayList<ArrayList>();
					//縦座標が０の場合は処理なし
					if(y != TopStopCheck) {
						for(int i = 1; i<7; i++) {
							//縦座標が０の地点までチェック
							TopStopCheck = y - i;
							if(TopStopCheck > 0) {

								//上が対抗色の場合
								if(Osero.board[y-i][x].equals(stone2)){
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0,y-i);
									chgSton.add(1,x);
									toplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg =  "keep";

									//上が同一色である場合
								}else if(Osero.board[y-i][x].equals(stone1)){

									//chgFlgの確認
									if(chgFlg == "keep") {
										//チェンジ対象を白に変える
										for(int n =0; n<toplist.size(); n++) {
											//変更される数を足す
											totalChgCount = totalChgCount + toplist.size();
										}
										//処理を終了
										break;
									}else if(chgFlg == "false"){
										break;
									}
								}else {
									break;
								}
							}
						}
					}



					//右斜め上へ確認
					TopStopCheck = 0;	//↑上限の初期化
					RStopCheck = 15;	//→上限の初期化
					chgFlg = "false";	//チェンジフラグの初期化
					ArrayList<ArrayList> RTStoplist = new ArrayList<ArrayList>();	//右上変換リスト

					//縦座標が０、右座標が１５の場合は処理なし
					if(y != TopStopCheck || x != RStopCheck) {
						for(int i = 1; i<7; i++) {
							//縦座標が０の地点までチェック
							TopStopCheck = y - i;
							RStopCheck = x + i;
							if(TopStopCheck > 0 ) {
								if(RStopCheck < 15) {
									//右上が対抗色だった場合
									if(Osero.board[y-i][x+i].equals(stone2)){
										ArrayList<Integer> chgSton = new ArrayList<Integer>();
										chgSton.add(0,y-i);
										chgSton.add(1,x+i);
										RTStoplist.add(chgSton);
										//チェンジフラグをキープ状態に変更
										chgFlg =  "keep";
										//上が同一色だった場合
									}else if(Osero.board[y-i][x+i].equals(stone1)){
										//chgFlgの確認
										if(chgFlg == "keep") {
											//チェンジ対象を白に変える
											for(int n =0; n<RTStoplist.size(); n++) {
												//変更される数を足す
												totalChgCount = totalChgCount + RTStoplist.size();
											}
											//処理を終了
											break;
										}else if(chgFlg == "false"){
											break;
										}
									}else {
										break;
									}
								}
							}
						}
					}

					//右へ確認
					RStopCheck = 15;	//→上限の初期化
					chgFlg = "false";	//チェンジフラグの初期化
					ArrayList<ArrayList> RStoplist = new ArrayList<ArrayList>();	//右変換リスト

					//右座標が１５の場合は処理なし
					if(x != RStopCheck) {
						for(int i = 1; i<7; i++) {
							//縦座標が０の地点までチェック
							RStopCheck = x + i;
							if(RStopCheck < 15) {

								//上が対抗色だった場合
								if(Osero.board[y][x+i].equals(stone2)){
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0,y);
									chgSton.add(1,x+i);
									RStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg =  "keep";

									//上が同一色だった場合
								}else if(Osero.board[y][x+i].equals(stone1)){

									//chgFlgの確認
									if(chgFlg == "keep") {
										//チェンジ対象を白に変える
										for(int n =0; n<RStoplist.size(); n++) {
											//変更される数を足す
											totalChgCount = totalChgCount + RStoplist.size();
										}
										//処理を終了
										break;

									}else if(chgFlg == "false"){
										break;
									}

								}else {
									break;
								}
							}
						}
					}

					//右斜め下へ確認
					BottomStopCheck = 7;	//↓上限の初期化
					RStopCheck = 15;	//→上限の初期化
					chgFlg = "false";	//チェンジフラグの初期化
					ArrayList<ArrayList> RBStoplist = new ArrayList<ArrayList>();	//右上変換リスト

					//縦座標が7、右座標が１５の場合は処理なし
					if(y != BottomStopCheck || x != RStopCheck) {
						for(int i = 1; i<7; i++) {
							//縦座標が０の地点までチェック
							BottomStopCheck = y + i;
							RStopCheck = x + i;
							if(BottomStopCheck < 7) {
								if(RStopCheck < 15) {
									//右下が対抗色だった場合
									if(Osero.board[y+i][x+i].equals(stone2)){
										ArrayList<Integer> chgSton = new ArrayList<Integer>();
										chgSton.add(0,y+i);
										chgSton.add(1,x+i);
										RBStoplist.add(chgSton);
										//チェンジフラグをキープ状態に変更
										chgFlg =  "keep";
										//上が同一色だった場合
									}else if(Osero.board[y+i][x+i].equals(stone1)){
										//chgFlgの確認
										if(chgFlg == "keep") {
											//チェンジ対象を同一色に変える
											for(int n =0; n<RBStoplist.size(); n++) {
												//変更される数を足す
												totalChgCount = totalChgCount + RBStoplist.size();
											}
											//処理を終了
											break;
										}else if(chgFlg == "false"){
											break;
										}
									}else {
										break;
									}
								}
							}
						}
					}

					//下への確認
					BottomStopCheck = 7;	//↓上限の初期化
					chgFlg = "false";	//チェンジフラグの初期化
					ArrayList<ArrayList> BottomStoplist = new ArrayList<ArrayList>();	//右変換リスト

					//下座標が７の場合は処理なし
					if(y != BottomStopCheck) {
						for(int i = 1; i<7; i++) {
							//縦座標が０の地点までチェック
							BottomStopCheck = y + i;
							if(BottomStopCheck < 7) {

								//上が対抗色だった場合
								if(Osero.board[y+i][x].equals(stone2)){
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0,y+i);
									chgSton.add(1,x);
									BottomStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg =  "keep";

									//上が同一色だった場合
								}else if(Osero.board[y+i][x].equals(stone1)){

									//chgFlgの確認
									if(chgFlg == "keep") {
										//チェンジ対象を同一色に変える
										for(int n =0; n<BottomStoplist.size(); n++) {
											//変更される数を足す
											totalChgCount = totalChgCount + BottomStoplist.size();
										}
										//処理を終了
										break;
									}else if(chgFlg == "false"){
										break;
									}
								}else {
									break;
								}
							}
						}
					}

					//左斜め下への確認
					BottomStopCheck = 7;	//↓上限の初期化
					LStopCheck = 8;			//←上限の初期化
					chgFlg = "false";	//チェンジフラグの初期化
					ArrayList<ArrayList> LBStoplist = new ArrayList<ArrayList>();	//右上変換リスト

					//縦座標が7、左座標が8の場合は処理なし
					if(y != BottomStopCheck || x != LStopCheck) {
						for(int i = 1; i<7; i++) {
							//縦座標が０の地点までチェック
							BottomStopCheck = y + i;
							LStopCheck = x - i;
							if(BottomStopCheck < 7) {
								if(LStopCheck > 8) {
									//右下が対抗色だった場合
									if(Osero.board[y+i][x-i].equals(stone2)){
										ArrayList<Integer> chgSton = new ArrayList<Integer>();
										chgSton.add(0,y+i);
										chgSton.add(1,x-i);
										LBStoplist.add(chgSton);
										//チェンジフラグをキープ状態に変更
										chgFlg =  "keep";
										//上が同一色だった場合
									}else if(Osero.board[y+i][x-i].equals(stone1)){
										//chgFlgの確認
										if(chgFlg == "keep") {
											//チェンジ対象を同一色に変える
											for(int n =0; n<LBStoplist.size(); n++) {
												//変更される数を足す
												totalChgCount = totalChgCount + LBStoplist.size();
											}
											//処理を終了
											break;
										}else if(chgFlg == "false"){
											break;
										}
									}else {
										break;
									}
								}
							}
						}
					}

					//左への確認
					LStopCheck = 8;		//←上限の初期化
					chgFlg = "false";	//チェンジフラグの初期化
					ArrayList<ArrayList> LStoplist = new ArrayList<ArrayList>();	//右変換リスト

					//左座標が8の場合は処理なし
					if(x != LStopCheck) {
						for(int i = 1; i<7; i++) {
							//縦座標が8の地点までチェック
							LStopCheck = x - i;
							if(LStopCheck > 8) {

								//上が対抗色だった場合
								if(Osero.board[y][x-i].equals(stone2)){
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0,y);
									chgSton.add(1,x-i);
									LStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg =  "keep";

									//上が同一色だった場合
								}else if(Osero.board[y][x-i].equals(stone1)){

									//chgFlgの確認
									if(chgFlg == "keep") {
										//チェンジ対象を同一色に変える
										for(int n =0; n<LStoplist.size(); n++) {
											//変更される数を足す
											totalChgCount = totalChgCount + LStoplist.size();
										}
										//処理を終了
										break;

									}else if(chgFlg == "false"){
										break;
									}
								}else {
									break;
								}
							}
						}
					}

					//左斜め上への確認
					TopStopCheck = 0;	//↑上限の初期化
					LStopCheck = 8;			//←上限の初期化
					chgFlg = "false";	//チェンジフラグの初期化
					ArrayList<ArrayList> LTStoplist = new ArrayList<ArrayList>();	//右上変換リスト

					//縦座標が0、左座標が8の場合は処理なし
					if(y != TopStopCheck || x != LStopCheck) {
						for(int i = 1; i<7; i++) {
							//縦座標が０,左座標が8の地点までチェック
							TopStopCheck = y - i;
							LStopCheck = x - i;
							if(TopStopCheck > 0 )  {
								if(LStopCheck > 8) {
									//右下が対抗色だった場合
									if(Osero.board[y-i][x-i].equals(stone2)){
										ArrayList<Integer> chgSton = new ArrayList<Integer>();
										chgSton.add(0,y-i);
										chgSton.add(1,x-i);
										LTStoplist.add(chgSton);
										//チェンジフラグをキープ状態に変更
										chgFlg =  "keep";
										//上が同一色だった場合
									}else if(Osero.board[y-i][x-i].equals(stone1)){
										//chgFlgの確認
										if(chgFlg == "keep") {
											//チェンジ対象を同一色に変える
											for(int n =0; n<LTStoplist.size(); n++) {
												//変更される数を足す
												totalChgCount = totalChgCount + LTStoplist.size();
											}
											//処理を終了
											break;
										}else if(chgFlg == "false"){
											break;
										}
									}else {
										break;
									}
								}
							}
						}
					}
				}
			//8方向の変更される石の数をマップへ格納する
			//期待値が０以上であれば格納する・
			if(totalChgCount>0) {
				setMap.put(checkPoint, totalChgCount);
			}
		}

		//置く場所がなくパスされる場合
		if(setMap.size() == 0) {
			return false;
		}else {
			return true;
		}
	}

	//############################################################
	//用途：button、pannelの位置判定
	//引数：番地（１〜６４）
	//戻り値：インデックス値
	//作成日：2021-10-9
	//作成者：SUS 福井
	//############################################################
	static public int[][] indexNum() {


		int[][] indexDate = new int[64][4];
		int setSize = 60;
		int setSixeY = 120;
		//x番地設定
		int xNum =1;

		for(int indexNum = 0; indexNum<64; indexNum++) {
			//x番地設定初期化
			if(xNum == 9) {
				xNum =1;
			}
			if(indexNum>=0 && indexNum < 8) {
				indexDate[indexNum][0]=(setSize * (xNum) - 30);
				indexDate[indexNum][1]=setSixeY;
				indexDate[indexNum][2]=setSize;
				indexDate[indexNum][3]=setSize;
			}else if(indexNum>=8 && indexNum < 16) {
				indexDate[indexNum][0]=(setSize * (xNum) - 30);
				indexDate[indexNum][1]=setSixeY + setSize;
				indexDate[indexNum][2]=setSize;
				indexDate[indexNum][3]=setSize;
			}else if(indexNum>=16 && indexNum < 24) {
				indexDate[indexNum][0]=(setSize * (xNum) - 30);
				indexDate[indexNum][1]=setSixeY + (setSize*2);
				indexDate[indexNum][2]=setSize;
				indexDate[indexNum][3]=setSize;
			}else if(indexNum>=24 && indexNum < 32) {
				indexDate[indexNum][0]=(setSize * (xNum) - 30);
				indexDate[indexNum][1]=setSixeY + (setSize*3);
				indexDate[indexNum][2]=setSize;
				indexDate[indexNum][3]=setSize;
			}else if(indexNum>=32 && indexNum < 40) {
				indexDate[indexNum][0]=(setSize * (xNum) - 30);
				indexDate[indexNum][1]=setSixeY + (setSize*4);
				indexDate[indexNum][2]=setSize;
				indexDate[indexNum][3]=setSize;
			}else if(indexNum>=40 && indexNum < 48) {
				indexDate[indexNum][0]=(setSize * (xNum) - 30);
				indexDate[indexNum][1]=setSixeY + (setSize*5);
				indexDate[indexNum][2]=setSize;
				indexDate[indexNum][3]=setSize;
			}else if(indexNum>=48 && indexNum < 56) {
				indexDate[indexNum][0]=(setSize * (xNum) - 30);
				indexDate[indexNum][1]=setSixeY + (setSize*6);
				indexDate[indexNum][2]=setSize;
				indexDate[indexNum][3]=setSize;
			}else if(indexNum>=56 && indexNum < 64) {
				indexDate[indexNum][0]=(setSize * (xNum) - 30);
				indexDate[indexNum][1]=setSixeY + (setSize*7);
				indexDate[indexNum][2]=setSize;
				indexDate[indexNum][3]=setSize;
			}
			xNum++;
		}


		return indexDate;
	}

	//############################################################
		//用途：各オセロ石の数を計算する
		//引数：なし
		//戻り値:[0][1] =[○の数][●の数]
		//作成日：2021-07-10
		//作成者：SUS 福井
		//############################################################
		static public int[] countOsero() {
			//盤面に石が置かれているかの判断フラグ
			int retcount[] = new int[2];
			int whiteCount = 0;
			int blackCount = 0;

			for(int checkPoint =1; checkPoint<=64; checkPoint++) {
				int[] date = CheckMesod.CheckBanmen(checkPoint);
				int y = date[0];  //縦座標
				int x = date[1];  //横座標

				if(Osero.board[y][x].equals(Osero.white)) {
					whiteCount++;
				}else if (Osero.board[y][x].equals(Osero.black)) {
					blackCount++;
				}
			}
			retcount[0] = whiteCount;
			retcount[1] = blackCount;
			return retcount;

		}
}
