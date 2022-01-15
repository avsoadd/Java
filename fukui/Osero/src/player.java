import java.util.ArrayList;

//############################################################
//システム名：オセロゲーム
//用途：プレイヤーの石設置
//   石を置く場所を入力させて、その場所に応じた石をひっくり返す
//引数：stone1:プレイヤーの石の色　stone2:対戦相手の石の色
//作成日：2021-07-10
//作成者：SUS 福井
//############################################################

public class Player {
	public static int EnemyFig = 0;
	static public void setStone(String stone1, String stone2) {

		int point; //ユーザー入力の設置位置
		boolean turnEnd = true; //置けなかった場合のフラグ
		boolean noChgFlg = true; //何もひっくり返せない場合のフラグ
		String stoneColer = "";
		String white_x; //石の位置

		//ユーザー入力設定
		//BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		//石の色の設定
		if (stone1.equals(Osero.white)) {
			stoneColer = "○";
		} else {
			stoneColer = "●";
		}

		//石の位置をプレイヤーに決定させる
		/*while (turnEnd) {*/
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("あなたの番です");
			System.out.println("【先手石：" + stoneColer + "】");
			System.out.println("↓↓↓↓↓置く場所を決めて下さい↓↓↓↓↓");

			//入力された数字を元に盤面の番地を割り出す
			/*			try {
							white_x = br1.readLine();
							//入力内容のチェック
							point = Integer.valueOf(white_x).intValue();
							if(point < 1 || point > 64) {
								System.out.println("↓↓↓↓↓置く場所が不正です↓↓↓↓↓");
								continue;
							}
						}catch (NumberFormatException ne) {
							System.out.println("↓↓↓↓↓入力が不正です↓↓↓↓↓");
							continue;
						}*/

			int[] date;
			//ユーザーの入力データ確認
			int indexNum = GuiButton.choiceNum;
			date = CheckMesod.CheckBanmen(indexNum);

			int y = date[0]; //縦座標
			int x = date[1]; //横座標
			int TopStopCheck = 0; //上方向の確認下限変数
			int RTStopCheck = 0; //右上方向の確認下限変数
			int RStopCheck = 15; //右方向の確認下限変数
			int BottomStopCheck = 7; //下方向の確認下限変数
			int LStopCheck = 8; //左方向の確認下限変数
			String chgFlg = "false";

			//指定箇所がEかのチェック
			if (Osero.board[y][x].equals(Osero.enpty)) {
				//上へ確認
				//上方向の縦座標の下限を設定
				TopStopCheck = 0;
				ArrayList<ArrayList> toplist = new ArrayList<ArrayList>();
				//縦座標が０の場合は処理なし
				if (y != TopStopCheck) {
					for (int i = 1; i < 7; i++) {
						//縦座標が０の地点までチェック
						TopStopCheck = y - i;
						if (TopStopCheck > 0) {

							//上が相手色だった場合
							if (Osero.board[y - i][x].equals(stone2)) {
								ArrayList<Integer> chgSton = new ArrayList<Integer>();
								chgSton.add(0, y - i);
								chgSton.add(1, x);
								toplist.add(chgSton);
								//チェンジフラグをキープ状態に変更
								chgFlg = "keep";

								//上が自分の色だった場合
							} else if (Osero.board[y - i][x].equals(stone1)) {

								//chgFlgの確認
								if (chgFlg == "keep") {
									//チェンジ対象を白に変える
									for (int n = 0; n < toplist.size(); n++) {
										ArrayList stone = toplist.get(n);
										Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
										Osero.board[y][x] = stone1;
										noChgFlg = false;
									}
									//処理を終了
									break;

								} else if (chgFlg == "false") {
									break;
								}

							} else {
								break;
							}
						}
					}
				}

				//右斜め上へ確認
				TopStopCheck = 0; //↑上限の初期化
				RStopCheck = 15; //→上限の初期化
				chgFlg = "false"; //チェンジフラグの初期化
				ArrayList<ArrayList> RTStoplist = new ArrayList<ArrayList>(); //右上変換リスト

				//縦座標が０、右座標が１５の場合は処理なし
				if (y != RTStopCheck || x != RStopCheck) {
					for (int i = 1; i < 7; i++) {
						//縦座標が０の地点までチェック
						TopStopCheck = y - i;
						RStopCheck = x + i;
						if (TopStopCheck > 0) {
							if (RStopCheck < 15) {
								//右上が相手色だった場合
								if (Osero.board[y - i][x + i].equals(stone2)) {
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0, y - i);
									chgSton.add(1, x + i);
									RTStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg = "keep";
									//上が自分の色だった場合
								} else if (Osero.board[y - i][x + i].equals(stone1)) {
									//chgFlgの確認
									if (chgFlg == "keep") {
										//チェンジ対象を自分の色に変える
										for (int n = 0; n < RTStoplist.size(); n++) {
											ArrayList stone = RTStoplist.get(n);
											Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
											Osero.board[y][x] = stone1;
											noChgFlg = false;
										}
										//処理を終了
										break;
									} else if (chgFlg == "false") {
										break;
									}
								} else {
									break;
								}
							}
						}
					}
				}

				//右へ確認
				RStopCheck = 15; //→上限の初期化
				chgFlg = "false"; //チェンジフラグの初期化
				ArrayList<ArrayList> RStoplist = new ArrayList<ArrayList>(); //右変換リスト

				//右座標が１５の場合は処理なし
				if (x != RStopCheck) {
					for (int i = 1; i < 7; i++) {
						//縦座標が０の地点までチェック
						RStopCheck = x + i;
						if (RStopCheck < 15) {
							//上が相手色だった場合
							if (Osero.board[y][x + i].equals(stone2)) {
								ArrayList<Integer> chgSton = new ArrayList<Integer>();
								chgSton.add(0, y);
								chgSton.add(1, x + i);
								RStoplist.add(chgSton);
								//チェンジフラグをキープ状態に変更
								chgFlg = "keep";

								//上が自分の色だった場合
							} else if (Osero.board[y][x + i].equals(stone1)) {

								//chgFlgの確認
								if (chgFlg == "keep") {
									//チェンジ対象を自分の色に変える
									for (int n = 0; n < RStoplist.size(); n++) {
										ArrayList stone = RStoplist.get(n);
										Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
										Osero.board[y][x] = stone1;
										noChgFlg = false;
									}
									//処理を終了
									break;

								} else if (chgFlg == "false") {
									break;
								}

							} else {
								break;
							}
						}
					}
				}

				//右斜め下へ確認
				BottomStopCheck = 7; //↓上限の初期化
				RStopCheck = 15; //→上限の初期化
				chgFlg = "false"; //チェンジフラグの初期化
				ArrayList<ArrayList> RBStoplist = new ArrayList<ArrayList>(); //右上変換リスト

				//縦座標が7、右座標が１５の場合は処理なし
				if (y != BottomStopCheck || x != RStopCheck) {
					for (int i = 1; i < 7; i++) {
						//縦座標が０の地点までチェック
						BottomStopCheck = y + i;
						RStopCheck = x + i;
						if (BottomStopCheck < 7) {
							if (RStopCheck < 15) {
								//右下が相手色だった場合
								if (Osero.board[y + i][x + i].equals(stone2)) {
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0, y + i);
									chgSton.add(1, x + i);
									RBStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg = "keep";
									//上が自分の色だった場合
								} else if (Osero.board[y + i][x + i].equals(stone1)) {
									//chgFlgの確認
									if (chgFlg == "keep") {
										//チェンジ対象を自分の色に変える
										for (int n = 0; n < RBStoplist.size(); n++) {
											ArrayList stone = RBStoplist.get(n);
											Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
											Osero.board[y][x] = stone1;
											noChgFlg = false;
										}
										//処理を終了
										break;
									} else if (chgFlg == "false") {
										break;
									}
								} else {
									break;
								}
							}
						}
					}
				}

				//下への確認
				BottomStopCheck = 7; //↓上限の初期化
				chgFlg = "false"; //チェンジフラグの初期化
				ArrayList<ArrayList> BottomStoplist = new ArrayList<ArrayList>(); //右変換リスト
				//下座標が７の場合は処理なし
				if (y != BottomStopCheck) {
					for (int i = 1; i < 7; i++) {
						//縦座標が０の地点までチェック
						BottomStopCheck = y + i;
						if (BottomStopCheck < 7) {
							//上が相手色だった場合
							if (Osero.board[y + i][x].equals(stone2)) {
								ArrayList<Integer> chgSton = new ArrayList<Integer>();
								chgSton.add(0, y + i);
								chgSton.add(1, x);
								BottomStoplist.add(chgSton);
								//チェンジフラグをキープ状態に変更
								chgFlg = "keep";
								//上が自分の色だった場合
							} else if (Osero.board[y + i][x].equals(stone1)) {
								//chgFlgの確認
								if (chgFlg == "keep") {
									//チェンジ対象を自分の色に変える
									for (int n = 0; n < BottomStoplist.size(); n++) {
										ArrayList stone = BottomStoplist.get(n);
										Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
										Osero.board[y][x] = stone1;
										noChgFlg = false;
									}
									//処理を終了
									break;
								} else if (chgFlg == "false") {
									break;
								}
							} else {
								break;
							}
						}
					}
				}

				//左斜め下への確認
				BottomStopCheck = 7; //↓上限の初期化
				LStopCheck = 8; //←上限の初期化
				chgFlg = "false"; //チェンジフラグの初期化
				ArrayList<ArrayList> LBStoplist = new ArrayList<ArrayList>(); //右上変換リスト

				//縦座標が7、左座標が8の場合は処理なし
				if (y != BottomStopCheck || x != LStopCheck) {
					for (int i = 1; i < 7; i++) {
						//縦座標が０の地点までチェック
						BottomStopCheck = y + i;
						LStopCheck = x - i;
						if (BottomStopCheck < 7) {
							if (LStopCheck > 8) {
								//右下が相手色だった場合
								if (Osero.board[y + i][x - i].equals(stone2)) {
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0, y + i);
									chgSton.add(1, x - i);
									LBStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg = "keep";
									//上が自分の色だった場合
								} else if (Osero.board[y + i][x - i].equals(stone1)) {
									//chgFlgの確認
									if (chgFlg == "keep") {
										//チェンジ対象を自分の色に変える
										for (int n = 0; n < LBStoplist.size(); n++) {
											ArrayList stone = LBStoplist.get(n);
											Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
											Osero.board[y][x] = stone1;
											noChgFlg = false;
										}
										//処理を終了
										break;
									} else if (chgFlg == "false") {
										break;
									}
								} else {
									break;
								}
							}
						}
					}
				}
				//左への確認
				LStopCheck = 8; //←上限の初期化
				chgFlg = "false"; //チェンジフラグの初期化
				ArrayList<ArrayList> LStoplist = new ArrayList<ArrayList>(); //右変換リスト

				//左座標が8の場合は処理なし
				if (x != LStopCheck) {
					for (int i = 1; i < 7; i++) {
						//縦座標が8の地点までチェック
						LStopCheck = x - i;
						if (LStopCheck > 8) {
							//上が相手色だった場合
							if (Osero.board[y][x - i].equals(stone2)) {
								ArrayList<Integer> chgSton = new ArrayList<Integer>();
								chgSton.add(0, y);
								chgSton.add(1, x - i);
								LStoplist.add(chgSton);
								//チェンジフラグをキープ状態に変更
								chgFlg = "keep";
								//上が自分の色だった場合
							} else if (Osero.board[y][x - i].equals(stone1)) {
								//chgFlgの確認
								if (chgFlg == "keep") {
									//チェンジ対象を自分の色に変える
									for (int n = 0; n < LStoplist.size(); n++) {
										ArrayList stone = LStoplist.get(n);
										Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
										Osero.board[y][x] = stone1;
										noChgFlg = false;
									}
									//処理を終了
									break;
								} else if (chgFlg == "false") {
									break;
								}
							} else {
								break;
							}
						}
					}
				}

				//左斜め上への確認
				TopStopCheck = 0; //↑上限の初期化
				LStopCheck = 8; //←上限の初期化
				chgFlg = "false"; //チェンジフラグの初期化
				ArrayList<ArrayList> LTStoplist = new ArrayList<ArrayList>(); //右上変換リスト

				//縦座標が0、左座標が8の場合は処理なし
				if (y != TopStopCheck || x != LStopCheck) {
					for (int i = 1; i < 7; i++) {
						//縦座標が０,左座標が8の地点までチェック
						TopStopCheck = y - i;
						LStopCheck = x - i;
						if (TopStopCheck > 0) {
							if (LStopCheck > 8) {
								//右下が相手色だった場合
								if (Osero.board[y - i][x - i].equals(stone2)) {
									ArrayList<Integer> chgSton = new ArrayList<Integer>();
									chgSton.add(0, y - i);
									chgSton.add(1, x - i);
									LTStoplist.add(chgSton);
									//チェンジフラグをキープ状態に変更
									chgFlg = "keep";
									//上が自分の色だった場合
								} else if (Osero.board[y - i][x - i].equals(stone1)) {
									//chgFlgの確認
									if (chgFlg == "keep") {
										//チェンジ対象を自分の色に変える
										for (int n = 0; n < LTStoplist.size(); n++) {
											ArrayList stone = LTStoplist.get(n);
											Osero.board[(int) stone.get(0)][(int) stone.get(1)] = stone1;
											Osero.board[y][x] = stone1;
											noChgFlg = false;
										}
										//処理を終了
										break;
									} else if (chgFlg == "false") {
										break;
									}
								} else {
									break;
								}
							}
						}
					}
				}
			} else {
				System.out.println("そこに置くことはできません。");
				EnemyFig = 1;
				//continue;
			}

			if (noChgFlg) {
				System.out.println("そこに置くことはできません。");
				EnemyFig = 1;
				//continue;
			} else {
				turnEnd = false;
			}
		//}
	}

}
