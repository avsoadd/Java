package janken;

import java.util.Random;
import java.util.Scanner;

public class jankenprog {

	public static void main(String[] args) {
		
		int Count = 0;
		
		String data1 ="勝ち";
		
		String data2 ="あいこ";
		
		String data3 ="負け";
		
		
			int usernum = GetUser();
			
			int GetCPUnum = GetCPU();
		
			String getResult = GetResult(usernum,GetCPUnum);
			
			showResult(usernum,GetCPUnum,getResult);
			
			while(Count < 5)
			{
				
				if(getResult.equals(data1))
				{
					Count++;
				
					int usernum1 = GetUser();
					
					int GetCPUnum1 = GetCPU();
				
					String getResult1 = GetResult(usernum1,GetCPUnum1);
					
					showResult(usernum1,GetCPUnum1,getResult1);
				}
				
				if(getResult.equals(data2))
				{
                    int usernum1 = GetUser();
					
					int GetCPUnum1 = GetCPU();
				
					String getResult1 = GetResult(usernum1,GetCPUnum1);
					
					showResult(usernum1,GetCPUnum1,getResult1);
		
				}
				if(getResult.equals(data3))
				{
                    int usernum1 = GetUser();
					
					int GetCPUnum1 = GetCPU();
				
					String getResult1 = GetResult(usernum1,GetCPUnum1);
					
					showResult(usernum1,GetCPUnum1,getResult1);
				
				}
					
			}
	}
	
	public static int GetUser()
	{
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		while(true)
		{
			System.out.println("あなたの手を入力してください < ");
			System.out.println("0 : グー , 1 : チョキ , 2 : パー");
			
			if(scanner.hasNextInt()) {
				
				int number = scanner.nextInt();
				
				if(number <= -1 || number >= 3)
				{
					System.out.println("入力できる数字は0～2までです");
					continue;
				}else {
					return number;
				}
			}else {
				System.out.println("入力できるのは整数だけです");
				scanner.next();
			}
		}
	}
	
	
	public static int GetCPU()
	{
		Random r = new Random();
		
		return r.nextInt(3);
	}
	
	public static String GetResult(int user,int cpu)
	{
		String reslut = "" ;
		
		if((user == 0 && cpu == 1 )|| (user == 1 && cpu == 2) || (user == 2 && cpu == 0))
		{
			reslut = "勝ち";
			
		}else if((user == 0 && cpu == 0) || (user == 1 && cpu == 1) || (user == 2 && cpu == 2))
         {
			reslut = "あいこ";
         }
		else
		{
			reslut = "負け";
		}
		
		return reslut;	
	}
	
	public static void showResult(int user,int pc,String result) {
		System.out.println("プレイヤーの手:"+user);
		System.out.println("pcの手:"+pc);
		System.out.println("勝敗:"+result);
	}
}
