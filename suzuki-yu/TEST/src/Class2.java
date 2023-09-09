
public class Class2 extends Class1 {
	private int a=3;
	public Class2() {
		System.out.println("Class2は"+a);
	}
	protected void show() {
		System.out.println("Class2　show");
		super.show();
	}
}
