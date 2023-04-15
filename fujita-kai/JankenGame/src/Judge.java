
public class Judge {
	public int judgement(int npc ,int player) {
		if(npc == player) {
			return 0;
		} else if((npc == 2 && player == 0)) {
			return 1;
		} else if(npc == 0 && player == 2){
			return 2;
		} else if(npc < player) {
			return 1;
		} else {
			return 2;
		}
	}
}
