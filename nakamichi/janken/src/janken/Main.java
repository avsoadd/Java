package janken;

public class Main {

	public static void main(String[] args) {
		int tmp = 1000;
		int tmp2 =1;
		tmp = tmp +tmp2;
	//	System.out.println("tmp :" +tmp);
		
		int[] tmpList = {1,2,3};
		
		for(int i=tmpList.length -1;i>=0;i--)
		{
			if(tmpList[i] == 1)
			{
				System.out.println("if文の条件成立");
			}
			else if(tmpList[i] == 2)
			{
				System.out.println("else if文の条件成立");
			}
			
			else
			{
				System.out.println("else文の条件成立");
			}

		}
		
		for(int i=tmpList.length -1;i>=0;i--)
		{
			switch(tmpList[i])
			{
			
			case 1:
				System.out.println("case 1文の条件成立");
				break;
				
			case 2:
				System.out.println("case 2文の条件成立");
				break;
				
			case 3:
				System.out.println("case 3文の条件成立");
				break;
				
			default:
				System.out.println("default文の条件成立");
				break;
			}
		}
		
		
		
	
	}
	
	

}
