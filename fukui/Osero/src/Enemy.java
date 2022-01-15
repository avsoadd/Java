import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


//############################################################
//システム名：オセロゲーム
//用途：エネミーの石設置
//   　自動で有効設置場所を判断し、石を配置する。
//引数：stone1:自身の石の色　stone2:対戦相手の石の色
//作成日：2021-07-10
//作成者：SUS 福井
//############################################################
public class Enemy {

	static public void setEnemeyStone(String stone1, String stone2) {

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
//			while(checkEnd) {
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

								//上が黒だった場合
								if(Osero.board[y-i][x].equals(stone2)){
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0,y-i);
									chgSton.add(1,x);
									toplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg =  "keep";

									//上が白だった場合
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
									//右上が黒だった場合
									if(Osero.board[y-i][x+i].equals(stone2)){
										ArrayList<Integer> chgSton = new ArrayList<Integer>();
										chgSton.add(0,y-i);
										chgSton.add(1,x+i);
										RTStoplist.add(chgSton);
										//チェンジフラグをキープ状態に変更
										chgFlg =  "keep";
										//上が白だった場合
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

								//上が黒だった場合
								if(Osero.board[y][x+i].equals(stone2)){
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0,y);
									chgSton.add(1,x+i);
									RStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg =  "keep";

									//上が白だった場合
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
									//右下が黒だった場合
									if(Osero.board[y+i][x+i].equals(stone2)){
										ArrayList<Integer> chgSton = new ArrayList<Integer>();
										chgSton.add(0,y+i);
										chgSton.add(1,x+i);
										RBStoplist.add(chgSton);
										//チェンジフラグをキープ状態に変更
										chgFlg =  "keep";
										//上が白だった場合
									}else if(Osero.board[y+i][x+i].equals(stone1)){
										//chgFlgの確認
										if(chgFlg == "keep") {
											//チェンジ対象を白に変える
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

								//上が黒だった場合
								if(Osero.board[y+i][x].equals(stone2)){
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0,y+i);
									chgSton.add(1,x);
									BottomStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg =  "keep";

									//上が白だった場合
								}else if(Osero.board[y+i][x].equals(stone1)){

									//chgFlgの確認
									if(chgFlg == "keep") {
										//チェンジ対象を白に変える
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
									//右下が黒だった場合
									if(Osero.board[y+i][x-i].equals(stone2)){
										ArrayList<Integer> chgSton = new ArrayList<Integer>();
										chgSton.add(0,y+i);
										chgSton.add(1,x-i);
										LBStoplist.add(chgSton);
										//チェンジフラグをキープ状態に変更
										chgFlg =  "keep";
										//上が白だった場合
									}else if(Osero.board[y+i][x-i].equals(stone1)){
										//chgFlgの確認
										if(chgFlg == "keep") {
											//チェンジ対象を白に変える
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

								//上が黒だった場合
								if(Osero.board[y][x-i].equals(stone2)){
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0,y);
									chgSton.add(1,x-i);
									LStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg =  "keep";

									//上が白だった場合
								}else if(Osero.board[y][x-i].equals(stone1)){

									//chgFlgの確認
									if(chgFlg == "keep") {
										//チェンジ対象を白に変える
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
									//右下が黒だった場合
									if(Osero.board[y-i][x-i].equals(stone2)){
										ArrayList<Integer> chgSton = new ArrayList<Integer>();
										chgSton.add(0,y-i);
										chgSton.add(1,x-i);
										LTStoplist.add(chgSton);
										//チェンジフラグをキープ状態に変更
										chgFlg =  "keep";
										//上が白だった場合
									}else if(Osero.board[y-i][x-i].equals(stone1)){
										//chgFlgの確認
										if(chgFlg == "keep") {
											//チェンジ対象を白に変える
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
			System.out.println("(CPU)置く場所がないため、パスしました。");
			System.out.println("");
			System.out.println("");
		}else {
			//マップからランダムで石を置く値を決定する。
			//LISTにMAPからKEYの一覧を取得
			ArrayList<Integer> getPointList = new ArrayList<Integer>();
			for (Integer key : setMap.keySet()) {
				getPointList.add(key);
			}
			//取得リストからランダムで一つ値をGET
			int getPoint = new Random().nextInt(getPointList.size());
			//設定する座標の位置
			int setStonePoint = getPointList.get(getPoint);

			//石の変更処置
			String result = setEnemeyStone(setStonePoint,stone1 ,stone2);
		}

	}

	//石の置き換え実行
	static public String setEnemeyStone(Integer setPoint, String stone1 , String stone2) {
		String result = "false";
		int[] date = CheckMesod.CheckBanmen(setPoint);
		int y = date[0];  //縦座標
		int x = date[1];  //横座標
		int TopStopCheck = 0 ;   	//上方向の確認下限変数
		int RTStopCheck = 0 ;   	//右上方向の確認下限変数
		int RStopCheck = 15 ;   	//右方向の確認下限変数
		int BottomStopCheck = 7 ; //下方向の確認下限変数
		int LStopCheck = 8 ;     	//左方向の確認下限変数
		String chgFlg = "false";
		String stoneColer ="";


		//石の色の設定
	 	if(stone1.equals(Osero.white)) {
	 		stoneColer = "○";
	 	}else {
	 		stoneColer = "●";
	 	}

	 	System.out.println("");
	 	System.out.println("");
	 	System.out.println("");

		System.out.println("【後手石：" + stoneColer + "】");
	   	System.out.println("↓↓↓↓↓相手が置く場所を決めています。お待ちください。↓↓↓↓↓");
	   	System.out.println("〜〜〜〜〜〜〜〜〜~〜〜〜〜〜〜結果〜〜~〜〜〜〜〜〜〜〜〜〜〜〜〜");
	   	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

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

					//上が黒だった場合
					if(Osero.board[y-i][x].equals(stone2)){
						ArrayList<Integer> chgSton = new ArrayList<Integer>();
						chgSton.add(0,y-i);
						chgSton.add(1,x);
						toplist.add(chgSton);
						//チェンジフラグをキープ状態に変更
						chgFlg =  "keep";

						//上が白だった場合
					}else if(Osero.board[y-i][x].equals(stone1)){

						//chgFlgの確認
						if(chgFlg == "keep") {
							//チェンジ対象を白に変える
							for(int n =0; n<toplist.size(); n++) {
								ArrayList stone = toplist.get(n);
								Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
								Osero.board[y][x] = stone1;
							}
							//処理を終了
							break;

						}else if(chgFlg == "false"){
							break;
						}
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
						//右上が黒だった場合
						if(Osero.board[y-i][x+i].equals(stone2)){
							ArrayList<Integer> chgSton = new ArrayList<Integer>();
							chgSton.add(0,y-i);
							chgSton.add(1,x+i);
							RTStoplist.add(chgSton);
							//チェンジフラグをキープ状態に変更
							chgFlg =  "keep";
							//上が白だった場合
						}else if(Osero.board[y-i][x+i].equals(stone1)){
							//chgFlgの確認
							if(chgFlg == "keep") {
								//チェンジ対象を白に変える
								for(int n =0; n<RTStoplist.size(); n++) {
									ArrayList stone = RTStoplist.get(n);
									Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
									Osero.board[y][x] = stone1;
								}
								//処理を終了
								break;
							}else if(chgFlg == "false"){
								break;
							}
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

					//上が黒だった場合
					if(Osero.board[y][x+i].equals(stone2)){
						ArrayList<Integer> chgSton = new ArrayList<Integer>();
						chgSton.add(0,y);
						chgSton.add(1,x+i);
						RStoplist.add(chgSton);
						//チェンジフラグをキープ状態に変更
						chgFlg =  "keep";

						//上が白だった場合
					}else if(Osero.board[y][x+i].equals(stone1)){

						//chgFlgの確認
						if(chgFlg == "keep") {
							//チェンジ対象を白に変える
							for(int n =0; n<RStoplist.size(); n++) {
								ArrayList stone = RStoplist.get(n);
								Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
								Osero.board[y][x] = stone1;
							}
							//処理を終了
							break;

						}else if(chgFlg == "false"){
							break;
						}

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
						//右下が黒だった場合
						if(Osero.board[y+i][x+i].equals(stone2)){
							ArrayList<Integer> chgSton = new ArrayList<Integer>();
							chgSton.add(0,y+i);
							chgSton.add(1,x+i);
							RBStoplist.add(chgSton);
							//チェンジフラグをキープ状態に変更
							chgFlg =  "keep";
							//上が白だった場合
						}else if(Osero.board[y+i][x+i].equals(stone1)){
							//chgFlgの確認
							if(chgFlg == "keep") {
								//チェンジ対象を白に変える
								for(int n =0; n<RBStoplist.size(); n++) {
									ArrayList stone = RBStoplist.get(n);
									Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
									Osero.board[y][x] = stone1;
								}
								//処理を終了
								break;
							}else if(chgFlg == "false"){
								break;
							}
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

					//上が黒だった場合
					if(Osero.board[y+i][x].equals(stone2)){
						ArrayList<Integer> chgSton = new ArrayList<Integer>();
						chgSton.add(0,y+i);
						chgSton.add(1,x);
						BottomStoplist.add(chgSton);
						//チェンジフラグをキープ状態に変更
						chgFlg =  "keep";

						//上が白だった場合
					}else if(Osero.board[y+i][x].equals(stone1)){

						//chgFlgの確認
						if(chgFlg == "keep") {
							//チェンジ対象を白に変える
							for(int n =0; n<BottomStoplist.size(); n++) {
								ArrayList stone = BottomStoplist.get(n);
								Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
								Osero.board[y][x] = stone1;
							}
							//処理を終了
							break;
						}else if(chgFlg == "false"){
							break;
						}
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
						//右下が黒だった場合
						if(Osero.board[y+i][x-i].equals(stone2)){
							ArrayList<Integer> chgSton = new ArrayList<Integer>();
							chgSton.add(0,y+i);
							chgSton.add(1,x-i);
							LBStoplist.add(chgSton);
							//チェンジフラグをキープ状態に変更
							chgFlg =  "keep";
							//上が白だった場合
						}else if(Osero.board[y+i][x-i].equals(stone1)){
							//chgFlgの確認
							if(chgFlg == "keep") {
								//チェンジ対象を白に変える
								for(int n =0; n<LBStoplist.size(); n++) {
									ArrayList stone = LBStoplist.get(n);
									Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
									Osero.board[y][x] = stone1;
								}
								//処理を終了
								break;
							}else if(chgFlg == "false"){
								break;
							}
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

					//上が黒だった場合
					if(Osero.board[y][x-i].equals(stone2)){
						ArrayList<Integer> chgSton = new ArrayList<Integer>();
						chgSton.add(0,y);
						chgSton.add(1,x-i);
						LStoplist.add(chgSton);
						//チェンジフラグをキープ状態に変更
						chgFlg =  "keep";

						//上が白だった場合
					}else if(Osero.board[y][x-i].equals(stone1)){

						//chgFlgの確認
						if(chgFlg == "keep") {
							//チェンジ対象を白に変える
							for(int n =0; n<LStoplist.size(); n++) {
								ArrayList stone = LStoplist.get(n);
								Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
								Osero.board[y][x] = stone1;
							}
							//処理を終了
							break;

						}else if(chgFlg == "false"){
							break;
						}

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
						//右下が黒だった場合
						if(Osero.board[y-i][x-i].equals(stone2)){
							ArrayList<Integer> chgSton = new ArrayList<Integer>();
							chgSton.add(0,y-i);
							chgSton.add(1,x-i);
							LTStoplist.add(chgSton);
							//チェンジフラグをキープ状態に変更
							chgFlg =  "keep";
							//上が白だった場合
						}else if(Osero.board[y-i][x-i].equals(stone1)){
							//chgFlgの確認
							if(chgFlg == "keep") {
								//チェンジ対象を白に変える
								for(int n =0; n<LTStoplist.size(); n++) {
									ArrayList stone = LTStoplist.get(n);
									Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
									Osero.board[y][x] = stone1;
								}
								//処理を終了
								break;
							}else if(chgFlg == "false"){
								break;
							}
						}
					}
				}
			}
		}




		return result;
	}

}
