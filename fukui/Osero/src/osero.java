//############################################################
//システム名：オセロゲーム
//用途：オセロゲーム＿画面表示
//作成日：2021-07-10
//作成者：SUS 福井
//############################################################

public class Osero {

	static String white = " ○ "; //プレイヤー１
	static String black = " ● "; //プレイヤー２
	static String enpty = " E "; //ボードが空

	//ボードのデータ
	static String board[][] = {
			{" 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," E "," E "," E "," E "," E "," E "," E " ," E "}
			,{" 9","10","11","12","13","14","15","16"," E "," E "," E "," E "," E "," E "," E " ," E "}
			,{"17","18","19","20","21","22","23","24"," E "," E "," E "," E "," E "," E "," E " ," E "}
			,{"25","26","27","28","29","30","31","32"," E "," E "," E ",white,black," E "," E " ," E "}
			,{"33","34","35","36","37","38","39","40"," E "," E " ," E ",black,white," E "," E " ," E "}
			,{"41","42","43","44","45","46","47","48"," E "," E " ," E "," E "," E "," E "," E " ," E "}
			,{"49","50","51","52","53","54","55","56"," E "," E "," E "," E "," E "," E "," E " ," E "}
			,{"57","58","59","60","61","62","63","64"," E "," E "," E "," E "," E "," E "," E " ," E "}
	};


	//ボードの描写
	static public void showBoard() {
		//ボードの表示
		System.out.print("__________________________________________________________");
		System.out.println("");

		for(int i = 0; i<board.length; i  ++) {
			for(int j = 0; j<16; j  ++)
				System.out.print("|"+board[i][j]);
			System.out.print("|");//枠線の作成
			System.out.println(""); };//１行下にするため

			System.out.print("__________________________________________________________");
			System.out.println("");
	};

	public String getOseroPropety(int boardNum) {
		String state = "";
		int[] date;
		//ユーザーの入力データ確認
		date = CheckMesod.CheckBanmen(boardNum + 1);

		int y = date[0]; //縦座標
		int x = date[1]; //横座標
		state = board[y][x];
		return state;
	}
}