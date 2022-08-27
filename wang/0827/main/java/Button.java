import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Button {
	//memo用

	public static void main(String[] args) {
		int[][] datas = {
				{ 0, 2, 2, 4 },
				{ 2, 2, 4, 4 },
				{ 0, 8, 2, 4 },
				{ 0, 32, 0, 64 }

		};

		JFrame frame = new JFrame();
		frame.setSize(514, 538);
		frame.setTitle("2048");
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(3);

		frame.setLayout(null);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel image = new JLabel(new ImageIcon("D:\\2048\\" + datas[i][j] + ".png"));
				image.setBounds(50 + 100 * j, 50 + 100 * i, 100, 100);
				frame.getContentPane().add(image);
			}
		}

		JLabel bg = new JLabel(new ImageIcon("D:\\2048\\bg.png"));
		bg.setBounds(40, 40, 420, 420);
		frame.getContentPane().add(bg);

		frame.setVisible(true);

	}

}
