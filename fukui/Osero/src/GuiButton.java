import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GuiButton extends JButton implements ActionListener{
	public static int choiceNum = 0;
	GuiButton button;
	ButtonProperty BTProperty = new ButtonProperty();
	int idNum;
	boolean roopFlg = true;
	//############################################################
	//用途：ボタンの表示設定
	//引数：なし
	//戻り値：ボタンの要素
	//作成日：2021-08-7
	//作成者：SUS 福井
	//############################################################
	public GuiButton setButton(int indexNum) {
//	JButton button = new JButton();
	button = new GuiButton();
	button.setBackground(Color.DARK_GRAY);
	button.addActionListener(this);
	button.setVisible(true);
	button.setFont(new Font("Arial", Font.BOLD, 30));
	if(indexNum == 28 || indexNum == 37) {
		button.setText("○");
	}
	if(indexNum == 29 || indexNum == 36) {
		button.setText("●");
	}
	//ボタンID設定
	button.SetButtonID(indexNum);
	//buttonProperty BTProperty = new buttonProperty();
	BTProperty.setButtonProperty(indexNum);
	return button;
	}

	//############################################################
		//用途：ボタンの押下時の動き
		//引数：アクションイベント
		//戻り値：なし
		//作成日：2021-11-7
		//作成者：SUS 福井
		//############################################################
	public void actionPerformed(ActionEvent e){
		//押されたボタンがNULLなら動く
		GuiPanel guipanel = new GuiPanel();

		if(button.getText().equals("")) {
			//ボタンの位置を取得
			int BTnumber = BTProperty.getButtonPropety();
			//((GuiPanel)button.getParent()).callcheck(BTnumber);
			choiceNum = BTnumber;
			Player.setStone(Osero.white,Osero.black);
			Osero.showBoard();
			if(Player.EnemyFig == 0) {
				((GuiPanel)button.getParent()).callcheck();
				((GuiPanel)button.getParent()).labelChange(1);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e1) {
//					// TODO 自動生成された catch ブロック
//					e1.printStackTrace();
//				}
				//プレイヤーの選択に間違いがなければエネミーターン開始、
				Enemy.setEnemeyStone(Osero.black,Osero.white);
				((GuiPanel)button.getParent()).callcheck();
				((GuiPanel)button.getParent()).labelChange(2);
				Osero.showBoard();
			}else{
				((GuiPanel)button.getParent()).labelChange(3);
				Player.EnemyFig = 0;
			};
			//Enpty存在チェック
			roopFlg = CheckMesod.checkEnpty();

			if(!roopFlg) {
				((GuiPanel)button.getParent()).labelChange(4);

			}

		}
	}
	public void SetButtonID(int idNum) {
		this.idNum = idNum;
	}
}
