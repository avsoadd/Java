
public class JavaBeginner {

    public static void main(String[] args) {

    	String[] str;
    	str = new String[3];
    	str[0] = "野球";
    	str[1] = "サッカー";
    	str[2] = "バスケ";

    	String a1 = str[0];
    	String a2 = str[1];
    	String a3 = str[2];

    	System.out.println("a1の値は"+a1);
    	System.out.println("a2の値は"+a2);
    	System.out.println("a3の値は"+a3);

    	int[] i;
    	i = new int[3];
    	i[0] = 4;
    	i[1] = 20;
    	i[2] = 57;
    	int b1 = i[0];
    	long b2 = i[1];
    	byte b3 =(byte) i[2];
    	System.out.println("b1の値は"+b1);
    	System.out.println("b2の値は"+b2);
    	System.out.println("b1の値は"+b3);
    }

}
