
public class janken {
	public static void main(String[] args){
		System.out.println("じゃんけんで勝つ回数を決めてください。");
		int count = new java.util.Scanner(System.in).nextInt();
		int cnt = 0;
		
		while(cnt<count){
			System.out.println("出す手を選択してください。");
			System.out.println("グー：0, チョキ：1, パー：2");
			
			int playerHand = new java.util.Scanner(System.in).nextInt();
			if(playerHand<0 || playerHand>2) {
				System.out.println("入力値が正しくありません。");
				continue;
			}
			
			int npcHand = new java.util.Random().nextInt(3);
			
			showHand(playerHand,npcHand);
			cnt = judge(playerHand,npcHand,cnt);
			System.out.println();
		}

	}
	
	
	//プレイヤーとnpcの手の表示
	public static void showHand(int playerHand, int npcHand) {
		String playerHandStr;
		String npcHandStr;
		
		if(playerHand==0 ) {
			playerHandStr = "グー";
		}else if(playerHand==1) {
			playerHandStr = "チョキ";
		}else {
			playerHandStr = "パー";
		}
		
		if(npcHand==0 ) {
			npcHandStr = "グー";
		}else if(npcHand==1) {
			npcHandStr = "チョキ";
		}else {
			npcHandStr = "パー";
		}
		
		System.out.println("プレイヤー："+playerHandStr+", npc："+npcHandStr);
	}
	
	
	//勝敗の判断と実行回数の変更
	public static int judge(int playerHand, int npcHand, int cnt) {
		if((playerHand==0 && npcHand==1) || (playerHand==1 && npcHand==2) || (playerHand==2 && npcHand==0)) {
			System.out.println("プレイヤーの勝利！");
			cnt++;
			return cnt;
		}else if((playerHand==0 && npcHand==2) || (playerHand==1 && npcHand==0) || (playerHand==2 && npcHand==1)){
			System.out.println("プレイヤーの敗北...");
			return cnt;
		}else {
			System.out.println("あいこ。もう一度!");
			return cnt;
		}
	}

}
