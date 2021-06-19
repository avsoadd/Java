public class Player {
	private String name;
	private int winCount;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getWinCount() {
		return winCount;
	}

	public void getResult(boolean result) {
		if (result == true) {
			winCount += 1;
		}
	}
}