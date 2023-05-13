package janken;

public class Main {

	public static void main(String[] args) {
		int tmp = 1000;
		int tmp2 = 1;
		
		tmp = tmp + tmp2;
		
		System.out.println("tmp :" + tmp);
		
		String strTmp = "hogehoge";
		
		System.out.println(strTmp);
		
		int[] tmpList = {1,2,3};
		
		for(int iTmp : tmpList) {
			System.out.println( "iTmp:"+ iTmp);
		}
		for(int i = 0; i < tmpList.length;i++) {
			System.out.println("[temList:]" + i + tmpList[i]);
		}
		//条件分岐処理
		System.out.println("条件分岐処理");
		if(tmpList[0] == 1) {
			System.out.println("if文の条件成立");
		}else if(tmpList[0] == 2) {
			System.out.println("else-if文の条件成立");
		}else {
			System.out.println("else文の条件成立");
		}
		
		label:
		for (int i = tmpList.length -1; i >= 0 ;i--) {
			switch(tmpList[i]) {
			case 1:
				strTmp = "case 1";
				System.out.println("case 1文の条件成立"+strTmp);
				break;
				
			case 2:
				strTmp="case 2";
				System.out.println("case 2文の条件成立"+strTmp);
				break;
			
			default:
				if(true) {
				System.out.println("default文の条件成立");
				break label;
				}
			}
			
		}
		
		int [] tmpList2 = tmpList.clone(); 
		System.out.println(tmpList2);
		System.out.println(tmpList);
	}

}
