package practice;

public class Work3 {

	public static void main(String[] args) {
		
		int[] ary = {1,3,5,10,12,21,42,100};
		for(int i: ary) {
			if((i % 2) == 0) {
				System.out.println("配列の値は" + i);
			}
		}
	}
}
