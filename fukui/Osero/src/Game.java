
public class Game {
	public static void main(String[] args) {

	for(int x=0; x<=30; x++) {


		osero.showBoard();
		player.setStone();
		osero.showBoard();
		player.rev_setStone();
		osero.showBoard();}


	int count=0;

	for(int i = 0; i<osero.board.length; i  ++) {
	      for(int j = 0; j<osero.board.length; j  ++) {
	    	  if(osero.board[i][j].equals(osero.white)) {
	    		  count++;}
	    	  }
	      }

	if(count>32) {
	    System.out.println("プレイヤー○の勝利！！");
	}else {
		System.out.println("プレイヤー●の勝利！！");
	}
  }
}



