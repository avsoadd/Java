import java.awt.Panel;

import javax.swing.JFrame;


//############################################################
//用途：機能拡張のための継承
//     必要な動作を追加して、JFrame＋αのコードを作成
//作成日：2021-08-7
//作成者：SUS 福井
//############################################################

public class guiFrame extends JFrame{

	//############################################################
	//用途：フレームの表示を切り替える
	//引数：なし
	//戻り値：なし
	//作成日：2021-08-7
	//作成者：SUS 福井
	//############################################################
	static public void setFrame() {
		//GUIのフレーム表示
		JFrame frame = new JFrame();

		//名称
		frame.setTitle("HyperOsero");

		//サイズ設定
		frame.setSize(550,650);
		//サイズ可変設定
		frame.setResizable(true);

		Panel panel = GuiPanel.setPanel();
		//フレーム上への部品追加
		frame.add(panel);
//		frame.addWindowListener();
		//クローズボタン設定
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//表示切替
		frame.setVisible(true);
	}


//	//############################################################
//	//用途：機能拡張:フレーム上への部品追加
//	//引数：なし
//	//戻り値：なし
//	//作成日：2021-08-7
//	//作成者：SUS 福井
//	//############################################################
	static public void add(JFrame frame ,Panel panel) {
		frame.add(panel);
	}


//	//############################################################
//	//用途：機能拡張:フレームのリスナー追加
//	//引数：なし
//	//戻り値：なし
//	//作成日：2021-08-7
//	//作成者：SUS 福井
//	//############################################################
	static public void addWindowListener(JFrame frame) {



	}

}
