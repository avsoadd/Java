package mainPackage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class ShootingFrame extends JFrame{
	public ShootingPanel panel;
	
	
	public ShootingFrame() {
		
		panel = new ShootingPanel();
		
		this.add(panel);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				Shooting.loop = true;
			}
		});
		
		
		this.addKeyListener(new Keyboard());
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Shooting");
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
