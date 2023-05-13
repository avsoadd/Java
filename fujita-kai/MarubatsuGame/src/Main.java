
public class Main {
	public static void main(String[] args) {
		char[][] banmen = {
				{' ','1','|','2','|','3'},
				{' ','-','-','-','-','-'},
				{' ','4','|','5','|','6'},
				{' ','-','-','-','-','-'},
				{' ','7','|','8','|','9'}
				};
		Hyouji viewer = new Hyouji();
		viewer.view(banmen);
		MarubatsuPlayer p = new MarubatsuPlayer();
		Npc n = new Npc();
		Checker c = new Checker();
		MarubatsuJudge judgeMan = new MarubatsuJudge();
		for(int line = 0; ;line++) {
			while(true) {
				int pNumber = p.play();
				int[] pList = c.check(pNumber);
				if(Character.isDigit(banmen[pList[0]][pList[1]])) {
				banmen[pList[0]][pList[1]] = 'o';
				break;
				}
			}
			if(judgeMan.judgement('o',banmen)) {
				viewer.view(banmen);
				break;
			}else if(line == 4) {
				System.out.println("引き分け");
				break;
			}
			while(true) {
				int nNumber = n.play();
				int[] pList = c.check(nNumber);
				if(Character.isDigit(banmen[pList[0]][pList[1]])) {
				banmen[pList[0]][pList[1]] = 'x';
				break;
				}
			}
			if(judgeMan.judgement('x',banmen)) {
				viewer.view(banmen);
				break;
			}
			viewer.view(banmen);
		}
	}
}
