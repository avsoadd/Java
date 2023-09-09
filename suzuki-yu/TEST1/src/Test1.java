import java.util.ArrayList;
import java.util.List;

import Test.Test3;

public class Test1 {
	public int a = 12;
	public Test1(int a) {
		this.a=a;
	}
	public void show() {
		System.out.println("aの値は"+a);
	}
	public static void main(String[] args) {
		Test1 s=new Test1(123); 
		s.show();
		int a=s.a;

		Test2 t=new Test2("987");
		t.show();
		Test3 e=new Test3();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		for(int i:list) {
			if(i < 3) {
				continue;
			}
			System.out.println(i);
		}
	}

}
