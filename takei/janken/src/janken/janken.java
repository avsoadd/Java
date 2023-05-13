package janken;
import java.util.Random;

public class janken {
	public static void main(String[] args) {
		String[] hands = { "グー", "チョキ", "パー" };
	    Random r = new Random();
		
	    
		switch(num) {
		
		case 1:
			repeat:
			if(hands[r.nextInt(3)] == 1) {
				System.out.println("引き分け");
				
			}else if(hands[r.nextInt(3)] == args[0]) {
				
				}
		case 2:
			repeat1:
			if(hands[r.nextInt(3)] == args[0]) {
				System.out.println("引き分け");
			}
		case 3	:
			repeat2:
			if(hands[r.nextInt(3)] == args[0]) {
				System.out.println("引き分け");
			}
		default :
			
			
			}
		}
		
	}
	    

	


