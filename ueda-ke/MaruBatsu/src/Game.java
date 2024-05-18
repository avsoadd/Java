import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		
		boolean continued=true;
		Random random = new Random();
		int flg[]=new int[9];
		String winner[] =new String[2];
		winner[0]="プレイヤー";
		winner[1]="コンピュータ";
		int turn=0;
		
		while(continued)
		{
			Generate(flg);
			
			System.out.println("マスを選択してください(0～8)");
			
			Scanner scanner = new Scanner(System.in);
			String pass = scanner.nextLine();
			
			while(pass==""||Integer.parseInt(pass)<0||Integer.parseInt(pass)>=9)
			{
				System.out.println("入力値は0～8です");
				
				scanner = new Scanner(System.in);
				pass = scanner.nextLine();
			}
			
			while(flg[Integer.parseInt(pass)]!=0)
			{
				System.out.println("すでに埋まっています");
				
				scanner = new Scanner(System.in);
				pass = scanner.nextLine();
			}
			
			flg[Integer.parseInt(pass)]=1;
			
			if(Judge(flg)!=1)
			{
				Generate(flg);
				System.out.println(winner[flg[Judge(flg)]-1]+"の勝利です");
				break;
			}
			
			turn+=1;
			if(turn==5)
			{
				Generate(flg);
				System.out.println("引き分けです");
				break;
			}
			
			int npcpass = random.nextInt(9);
			
			while(flg[npcpass]==1||flg[npcpass]==2)
			{
				npcpass = random.nextInt(9);
			}
			
			flg[npcpass]=2;
			
			if(Judge(flg)!=1)
			{
				Generate(flg);
				System.out.println(winner[flg[Judge(flg)]-1]+"の勝利です");
				break;
			}
			
		}
	}
	
	public static Integer Judge(int flg[]) {
		if(flg[4]!=0&&((flg[4]==flg[0]&&flg[4]==flg[8])||(flg[4]==flg[1]&&flg[4]==flg[7])||(flg[4]==flg[2]&&flg[4]==flg[6])||(flg[4]==flg[3]&&flg[4]==flg[5])))
		{
			return 4;
		}
		
		if(flg[0]!=0&&((flg[0]==flg[1]&&flg[0]==flg[2])||(flg[0]==flg[3]&&flg[0]==flg[6])))
		{
			return 0;
		}
		
		if(flg[8]!=0&&((flg[8]==flg[5]&&flg[8]==flg[2])||(flg[8]==flg[7]&&flg[8]==flg[6])))
		{
			return 8;
		}
		return 1;
	}
	
	public static void Generate(int flg[]){
		
		for(int i=0;i<9;i++)
		{
			
			if(i%3==0||i==0)
			{
				System.out.println(" ― ― ―");
			}
			
			System.out.printf("|");
			
			if(flg[i]==0)
			{
				System.out.printf("　");
			}
			else if(flg[i]==1)
			{
				System.out.printf("〇");
			}
			else if(flg[i]==2)
			{
				System.out.printf("×");
			}
				
			if((i+1)%3==0)
			{
				System.out.println("|");
			}
				
			if(i==8)
			{
				System.out.println(" ― ― ―");
			}
		}
		
	}
}
