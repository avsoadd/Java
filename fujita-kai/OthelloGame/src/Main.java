
public class Main {
	static int ban[][] = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 2, 1, 0, 0, 0 }, { 0, 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
	static boolean putStone[][] = { 
			{ false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false }, { false, false, false, false, false, false, false, false } };


	public static void main(String[] args) {
		
	}
	public void check(int color , int pP[]) {
		int anColor = 0;
		if(color == 1) {
			anColor = 2;
		}else {
			anColor = 1;
		}
		if(ban[pP[0]][pP[1]] == 0) {
			if(ban[pP[0]-1][pP[1]-1] == anColor || ban[pP[0]-1][pP[1]] == anColor || ban[pP[0]-1][pP[1]+1] == anColor ||
					ban[pP[0]][pP[1]-1] == anColor || ban[pP[0]][pP[1]+1] == anColor ||
					ban[pP[0]+1][pP[1]-1] == anColor || ban[pP[0]+1][pP[1]] == anColor || ban[pP[0]+1][pP[1]+1] == anColor) {
				putStone[pP[0]][pP[1]] = true;
			}
		}
	}
}
