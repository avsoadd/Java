import java.awt.Color;

import javax.swing.JLabel;

public class GuiLabel extends JLabel{

	//############################################################
	//用途：ラベルの表示を切り替える
	//引数：なし
	//戻り値：なし
	//作成日：2021-08-7
	//作成者：SUS 福井
	//############################################################
	public static JLabel setLabel() {
		JLabel label = new JLabel("oseroLabel");
		label.setText("<html><body>ゲーム開始！<br>あなたのターンです（先手石：○）勝ちを目指して石をおきましょう！</body></html>");
		label.setVisible(true);
		label.setBounds(50,20,500,100);
		label.setBackground(Color.blue);
		return label;
	}
}
