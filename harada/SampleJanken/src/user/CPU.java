package user;

public class CPU extends User {
	static int mCnt = 1;

	public CPU() {
		super("CPU"+mCnt);
		mCnt++;
	}
}
