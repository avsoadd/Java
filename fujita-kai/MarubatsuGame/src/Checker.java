
public class Checker {
	public int[] check(int number) {
		int ijList[] = new int[2];
		switch(number) {
		case 1:
			ijList[0] = 0;ijList[1] = 1;
			break;
		case 2:
			ijList[0] = 0;ijList[1] = 3;
			break;
		case 3:
			ijList[0] = 0;ijList[1] = 5;
			break;
		case 4:
			ijList[0] = 2;ijList[1] = 1;
			break;
		case 5:
			ijList[0] = 2;ijList[1] = 3;
			break;
		case 6:
			ijList[0] = 2;ijList[1] = 5;
			break;
		case 7:
			ijList[0] = 4;ijList[1] = 1;
			break;
		case 8:
			ijList[0] = 4;ijList[1] = 3;
			break;
		case 9:
			ijList[0] = 4;ijList[1] = 5;
			break;
		}
		return ijList;
	}
}
