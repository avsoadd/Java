package marubatuquizu;

public class hyouzi {
	public void view(char[][] banmen) {
		for(int i=0; i<banmen.length; i++)
		{
			for(int j=0; j<banmen[i].length; j++) {
				System.out.print(banmen[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
