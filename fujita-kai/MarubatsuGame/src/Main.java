
public class Main {
	public static void main(String[] args) {
		String[][] banmen = {
				{" ","1","|","2","|","3"},
				{" ","-","-","-","-","-"},
				{" ","4","|","5","|","6"},
				{" ","-","-","-","-","-"},
				{" ","7","|","8","|","9"}
				};
		for(int i = 0;i < banmen.length;i++) {
			for(int j = 0; j < banmen[i].length;j++) {
				System.out.print(banmen[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
