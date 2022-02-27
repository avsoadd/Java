package mainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Shooting {
	public static ShootingFrame shootingFrame;
	public static boolean loop;
	
	public static void main(String[] args) {
		shootingFrame = new ShootingFrame();
		loop = true;
		
		
		
		//FPS
		long startTime;
		long fpsTime = 0;
		int fps = 60;
		int FPS = 0;
		int FPSCount = 0;
		Graphics gra = shootingFrame.panel.image.getGraphics();
		
		//GAME
		int playerX = 0, playerY = 0;
		ArrayList<Bullet> bullets = new ArrayList<>();
		ArrayList<Enemy> enemies = new ArrayList<>();
		
		
		EnumShootingScrean screan = EnumShootingScrean.START;
		
		
		
		while(loop) {
			if((System.currentTimeMillis() - fpsTime) >= 1000) {
				fpsTime = System.currentTimeMillis();
				FPS = FPSCount;
				FPSCount = 0;
			}
			FPSCount ++;
			startTime = System.currentTimeMillis();
			
			gra.setColor(Color.WHITE);
			gra.fillRect(0, 0, 500, 500); 
			
			switch(screan) {
			case START:
				gra.setColor(Color.BLACK);
				Font font = new Font("SansSerif", Font.PLAIN, 50);
				gra.setFont(font);
				FontMetrics metrics = gra.getFontMetrics(font);
				gra.drawString("Shooting", 250 - (metrics.stringWidth("Shooting") / 2), 100);
				font = new Font("SansSerif", Font.PLAIN, 20);
				gra.setFont(font);
				metrics = gra.getFontMetrics(font);
				gra.drawString("Sress SPACR to Start", 250 - (metrics.stringWidth("Sress SPACR to Start") / 2), 150);
				if(Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
					screan = EnumShootingScrean.GAME;

					bullets = new ArrayList<>();
					enemies = new ArrayList<>();
					playerX = 235;
					playerY = 400;
					
				}
				
				break;
			case GAME:
				gra.setColor(Color.BLUE);
				gra.fillRect(playerX + 10, playerY, 10, 10);
				gra.fillRect(playerX, playerY + 10, 30, 10);
				
				for(Bullet bullet:bullets) {
					gra.setColor(Color.BLUE);
					gra.fillRect(bullet.x, bullet.y, 5, 5);
					bullet.y -=10;
				}
				
				
				if(Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && playerX>0) playerX-=3;
				if(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && playerX<455) playerX+=3;
				if(Keyboard.isKeyPressed(KeyEvent.VK_UP) && playerY>50) playerY-=3;
				if(Keyboard.isKeyPressed(KeyEvent.VK_DOWN) && playerY<430) playerY+=3;
				
				
				if(Keyboard.isKeyPressed(KeyEvent.VK_A)) {
					bullets.add(new Bullet(playerX + 12, playerY));
				}
				break;
			case GAME_OVER:
				break;
			}
			
			gra.setColor(Color.BLACK);
			gra.setFont(new Font("SansSerif", Font.PLAIN, 10));
			gra.drawString(FPS + "FPS", 0, 460);
			
			
			shootingFrame.panel.draw();
			try {
				long runTime = System.currentTimeMillis() - startTime;
				if (runTime<(1000 / fps)) {
					Thread.sleep(1000 / fps - runTime);
				}
					
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
