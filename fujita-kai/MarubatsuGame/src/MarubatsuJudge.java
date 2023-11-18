
public class MarubatsuJudge {
	public boolean judgement(char marubatu ,char[][] list) {
		String player;
		if(marubatu == 'o') {
			player = "あなた";
		}else {
			player = "NPC";
		}
		if(list[0][1] == list[0][3] && list[0][3] == list[0][5]) {
			System.out.println(player + "の勝ち");
			return true;
		}else if(list[2][1] == list[2][3] && list[2][3] == list[2][5]) {
			System.out.println(player + "の勝ち");
			return true;
		}else if(list[4][1] == list[4][3] && list[4][3] == list[4][5]) {
			System.out.println(player + "の勝ち");
			return true;
		}else if(list[0][1] == list[2][1] && list[2][1] == list[4][1]) {
			System.out.println(player + "の勝ち");
			return true;
		}else if(list[0][3] == list[2][3] && list[2][3] == list[4][3]) {
			System.out.println(player + "の勝ち");
			return true;
		}else if(list[0][5] == list[2][5] && list[2][5] == list[4][5]) {
			System.out.println(player + "の勝ち");
			return true;
		}else if(list[0][1] == list[2][3] && list[2][3] == list[4][5]) {
			System.out.println(player + "の勝ち");
			return true;
		}else if(list[0][5] == list[2][3] && list[2][3] == list[4][1]) {
			System.out.println(player + "の勝ち");
			return true;
		}else {
			return false;
		}
	}
}
