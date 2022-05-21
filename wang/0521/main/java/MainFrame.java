import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainFrame extends JFrame implements KeyListener {
	int[][]datas={
			{0,2,2,4},
			{2,2,4,0},
			{0,8,2,4},
			{0,32,0,64}

	};

	public MainFrame() {
		initFrame();
		paintView();

		//listen
		this.addKeyListener(this);

		setVisible(true);
	}

	/**
	 * windowの初期化設定
	 *
	 */
	public void initFrame() {

		//superのメソッドを使用するため、削除でOK
		setSize(514,538);
		setTitle("2048");
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(3);

		setLayout(null);

	}

	/**
	 * 画面を描画
	 *
	 */

	public void paintView() {

		//remove all
		getContentPane().removeAll();

		for(int i = 0; i<4; i++) {
			for(int j =0; j<4; j++) {
				JLabel image = new JLabel(new ImageIcon("D:\\2048\\"+datas[i][j]+".png"));
				image.setBounds(50 + 100*j, 50+ 100 * i, 100, 100);
				super.getContentPane().add(image);
			}
		}

		JLabel bg = new JLabel(new ImageIcon("D:\\2048\\bg.png"));
		bg.setBounds(40, 40, 420, 420);
		super.getContentPane().add(bg);

		getContentPane().repaint();

	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		int KeyCode = e.getKeyCode();

		if(KeyCode == KeyEvent.VK_UP) {
			MoveToTheTop();

		}else if(KeyCode == KeyEvent.VK_DOWN ){
			MoveToTheBottom();

		}else if(KeyCode == KeyEvent.VK_LEFT){
			datas=MoveToTheLeft();
            MoveToTheLeft();


		}else if(KeyCode == KeyEvent.VK_RIGHT){
			MoveToTheRight();
		}

		paintView();
		CheckResult();
	}

	public void CheckResult(){
       int[][] check=MoveToTheLeft();
       if(check == datas) {
    	   System.out.print("gameover");
       }

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public int[][] MoveToTheLeft() {
		int[][] temp = datas.clone();
		for(int m = 0; m<temp.length; m++) {

			//０でない項目を左に移動
			int[]arr = new int[4];
			int index= 0;
			for ( int x = 0; x<temp[m].length; x++){
				if(temp[m][x] != 0) {
					arr[index] = temp[m][x];
					index++;
				}
			}
			temp[m]=arr;

			for (int x =0; x < 3; x++) {
				//隣の項目と比較し、同じものを足す
				if(temp[m][x] ==temp[m][x+1]) {
					temp[m][x] *=2;

					//次の項目を前に移動し、最後に０を足す
					for(int j =x+1; j<3; j++ ) {
						temp[m][j]=temp[m][j+1];
					}
					temp[m][3]=0;
				}
		}
		}
//戻り値設定？


		System.out.println("left");
		return temp;
	}

	public void MoveToTheRight() {
		for(int m = 0; m<datas.length; m++) {

			//０でない項目を右に移動
			int[]arr = new int[4];
			int index= 3;
			for ( int x = datas[m].length-1; x>=0; x--){
				if(datas[m][x] != 0) {
					arr[index] = datas[m][x];
					index--;
				}
			}
			datas[m]=arr;

			for (int x =3; x >0; x--) {
				//隣の項目と比較し、同じものを足す
				if(datas[m][x] ==datas[m][x-1]) {
					datas[m][x] *=2;

					//次の項目を後ろに移動し、先頭に０を足す
					for(int j =x-1; j>0; j-- ) {
						datas[m][j]=datas[m][j-1];
					}
					datas[m][0]=0;
				}
		}
		}
        paintView();
		System.out.println("right");
	}

	public void MoveToTheTop() {
		Clockwise();
		MoveToTheLeft();
		AntiClockwise();
        paintView();
		System.out.println("up");

	}

	public void MoveToTheBottom() {
		AntiClockwise();
		MoveToTheLeft();
		Clockwise();
	    paintView();
		System.out.println("down");
	}

    public void AntiClockwise() {
    	int[][]newArr= new int[4][4];


		for(int i = 0; i<4; i++) {
			for(int j=0; j<4;j++) {

				newArr[j][3-i]=datas[i][j];

			}
		}
		datas=newArr;

    }

    public void Clockwise() {
    	int[][]newArr= new int[4][4];


		for(int i = 0; i<4; i++) {
			for(int j=0; j<4;j++) {

				newArr[3-j][i]=datas[i][j];

			}
		}
		datas=newArr;
    }

//    public boolean CheckLeft() {
//    	int[][] temp= new int[4][4];
//    	temp=datas;
//    	MoveToTheLeft();
//    	boolean flag = true;
//    	if(temp == datas){
//    		flag = false;
//
//    	}
//		return flag;
//
//    }
}

