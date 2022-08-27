
public class Demo {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[][] arr = {
				{ 2, 0, 2, 0 },
				{ 2, 2, 2, 0 },
				{ 2, 0, 3, 8 },
				{ 2, 2, 4, 4 }
		};

		int[][] temp = arr.clone();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(temp[i][j]);
			}
		}

		//arr[m][x]
		//flagをたてる（do while）たてたらループ継続　立てなかったらループを抜ける
		//		  for(int m =0 ; m < arr.length-1; m++) {
		//			int x =0;
		//			boolean flag=true;
		//			do{
		//				if(arr[m][x] == 0) {
		//					arr[m][x]=arr[m+1][x];
		//					arr[m+1][x]=0;
		//				}
		//				x++;
		//
		//			}while(flag=true&&x<4);
		//		  }

		//        for(int count = 0; count<3; count++) {
		//        for(int m =0 ; m < arr.length-1; m++) {
		//        	//０でない項目を上に移動
		//
		//        	for (int x =0; x<4; x++){
		//				if(arr[m][x] == 0) {
		//					arr[m][x]=arr[m+1][x];
		//					arr[m+1][x]=0;
		//
		//				}
		//        	}
		//
		//        	}
		//        }
		//
		//        for(int m =0 ; m < arr.length-1; m++) {
		//
		//			for (int x =0; x < 3; x++) {
		//				//下の項目と比較し、同じものを足す
		//
		//				if(arr[m][x] == arr[m+1][x]) {
		//					arr[m][x] *=2;
		//
		//					//次の項目を上に移動し、一番下に０を足す
		//					for(int j =m+1; j<2; j++ ) {
		//						arr[j][x]=arr[j+1][x];
		//					}
		//
		//					arr[3][x]=0;
		//				}
		//
		//
		//			}
		//        }
		//
		//		for(int i =0; i < arr.length; i++) {
		//			for(int n = 0; n<arr[i].length; n++) {
		//			System.out.print(arr[i][n]);
		//			}
		//			System.out.println();
		//		}

	}

}

//引数で方向を渡すもOK
