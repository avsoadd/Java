
public class Test2 {
	public String s = "AAA";
	public Test2(String s) {
		this.s=s;
	}
	public void show() {
		System.out.println("sは"+s);
		Test1 t=new Test1(345);
		int a=t.a;
		t.show();
	}

}
