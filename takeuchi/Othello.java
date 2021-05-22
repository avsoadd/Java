import java.io.*;
public class Othello {
	static Player p1,p2,pw;//プレイヤー
	static int[][] ban = { //盤面 0=無し 1=黒 2=白 3=置ける
		{0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,1,2,0,0,0},
        {0,0,0,2,1,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0}};
	public static void main(String[] args) throws IOException {
		String[] kazu = {"１","２","３","４","５","６","７","８"};
		String[] color = {"","黒","白","現在置ける場所"};
		int[] status = new int[4];//盤面の状況を格納
		int tate,yoko = 0;//コマを置く縦位置、横位置
		int failed_cnt = 0; //2回おけなかったらゲーム終了
		p1 = new Player('h',1);//プレイヤー1 黒
		p2 = new Player('h',2);//プレイヤー1 白
		pw = p1;//作業用オブジェクト
		while(true){//ゲームメインループ
			for(int i = 0 ; i < status.length ; i++){//配列の初期化
				status[i] = 0;
			}
			for(int i=0 ; i < ban.length ; i++){ //置ける位置の初期化
				for(int j = 0 ; j < ban[i].length ; j++){
					if(ban[i][j] == 3){
						ban[i][j] = 0;
					}
				}
			}
			//置ける場所チェック
			for(int i = 0 ; i < ban.length ; i++){//縦のループ
				for(int j = 0 ; j < ban[i].length ; j++){//横のループ
					if(ban[i][j] == 0){//コマが置かれていない場所をチェック
						if(check_change(i,j,pw.color,"check")){//置ける時
							ban[i][j] = 3;
						}
					}
				}
			}
		}
	}
