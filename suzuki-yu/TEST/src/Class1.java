import java.util.Scanner;

public class Class1 {
	private int a=1;
	public Class1() {
		System.out.println("Class1は"+a);

	}
	
	protected void show() {
		System.out.println("Class1　show");
	}
	public static void main(String[] args) {
		Class1 a=new Class2();
		Class1 b=new Class1();
	a.show();
	//b.show();
	//Scanner：コンソールに入力できるようにしている
	Scanner sc=new Scanner(System.in);
	System.out.println("文字入力");
	String tmp=sc.next();
	System.out.println("入力値は"+tmp);

	}
	
}
