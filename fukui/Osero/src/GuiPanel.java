import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GuiPanel extends Panel {

	//############################################################
	//用途：盤面の変更を反映する
	//引数：なし
	//戻り値：なし
	//作成日：2021-08-7
	//作成者：SUS 福井
	//############################################################
	public void callcheck() {
		Osero osero = new Osero();
		Component[] components = getComponents();

		//画面データ読み込み
		for(int t = 0; t<64; t++) {
			String banSt = osero.getOseroPropety(t);
			if(banSt != " E ") {
				((JButton) components[t]).setText(banSt);
			}
		}
	}
	//############################################################
	//用途：表示文章を変更する
	//引数：ステータスNumber
	//戻り値：なし
	//作成日：2021-08-7
	//作成者：SUS 福井
	//############################################################
	public void labelChange(int stateNum) {
		Component[] components = getComponents();
		switch(stateNum) {
			case 1:
				((JLabel) components[64]).setText("相手が置く場所を考えています");
				break;
			case 2:
				((JLabel) components[64]).setText("次に置く場所をクリックしてください。");
				break;
			case 3:
				((JLabel) components[64]).setText("そこに置くことはできません");
				break;
			//結果の確認
			case 4:
				 int reg[] = CheckMesod.countOsero();
				 String white = String.valueOf(reg[0]);
				 String black = String.valueOf(reg[1]);
				 String winer;
				 if(reg[0] > reg[1]) {
					 winer = "あなたの勝利です！";
				 }else {
					 winer = "あなたの負けです！";
				 }
				 ((JLabel) components[64]).setText("<html><body>○：" + white + "<br>●："
						 						  + black + "<br>" + winer + "</body></html>");
				break;
		}

	}
	//############################################################
	//用途：フレームの表示を切り替える
	//引数：なし
	//戻り値：なし
	//作成日：2021-08-7
	//作成者：SUS 福井
	//############################################################
	 public static GuiPanel setPanel( ) {
		//GUIのフレーム表示
		GuiPanel panel = new GuiPanel();
		GuiLabel guiLabel = new GuiLabel();
		panel.setLayout(null);
		//サイズ設定
		panel.setSize(700,800);
		//背景色
		panel.setBackground(Color.LIGHT_GRAY);
			//ボタンとラベルの設定
			int[][] indexDate = new int[64][4];
			indexDate = CheckMesod.indexNum();
			for(int i = 0; i<64; i++) {
				GuiButton GuiButton = new GuiButton();
				//ボタンの配置場所設定
				JButton button = GuiButton.setButton(i + 1);
				button.setBounds(indexDate[i][0], indexDate[i][1], indexDate[i][2], indexDate[i][3]);
				//パネルへのセット
				panel.add(button);
		}
		JLabel label = guiLabel.setLabel();
		panel.add(label);
		//表示切替
		panel.setVisible(true);
		return panel;
	}
//	//############################################################
//	//用途：機能拡張:フレーム上への部品追加
//	//引数：なし
//	//戻り値：なし
//	//作成日：2021-08-7
//	//作成者：SUS 福井
//	//############################################################
	public static void add(Panel panel , JButton button) {
		panel.add(button);
	}

}



