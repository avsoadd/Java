
public class demoClockwise {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//clockwise:   newarr[j][3-i]=arr[i][j]
		//anticlockwise: newarr[3-j][i]=arr[i][j]

		int[][]arr= {
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4},
				{1,2,3,4}
		};
		int[][]newArr= new int[4][4];


		for(int i = 0; i<4; i++) {
			for(int j=0; j<4;j++) {

				newArr[3-j][i]=arr[i][j];

			}

		}

		arr=newArr;

		for(int i = 0; i<4; i++) {
			for(int j=0; j<4;j++) {
        System.out.print(arr[i][j]+"");
			}
			System.out.println();
		}
	}

}
