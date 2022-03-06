package mainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

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
		EnumShootingScreen screen = EnumShootingScreen.START;

		//GAME
		int playerX = 0, playerY = 0;
		int bulletInterval = 0;
		int score = 0;
		int level = 0;
		long levelTimer = 0;
		ArrayList<Bullet> bullets_player = new ArrayList<>();
		ArrayList<Bullet> bullets_enemy = new ArrayList<>();
		ArrayList<Enemy> enemies = new ArrayList<>();
		Random random = new Random();
		
		
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
			
			switch(screen) {
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
					screen = EnumShootingScreen.GAME;
					
					bullets_player = new ArrayList<>();
					bullets_enemy = new ArrayList<>();
					enemies = new ArrayList<>();
					playerX = 235;
					playerY = 400;
					score = 0;
					level = 0;
					
				}
				
				break;
			case GAME:
				if (System.currentTimeMillis() - levelTimer > 10 * 1000) {
					levelTimer = System.currentTimeMillis();
					level ++;
				}
				
				
				gra.setColor(Color.BLUE);
				gra.fillRect(playerX + 10, playerY, 10, 10);
				gra.fillRect(playerX, playerY + 10, 30, 10);
				
				for(int i = 0; i < bullets_player.size();i++) {
					Bullet bullet = bullets_player.get(i);
					gra.setColor(Color.BLUE);
					gra.fillRect(bullet.x, bullet.y, 5, 5);
					bullet.y -=10;
					
					if(bullet.y<0) {
						bullets_player.remove(i);
						i--;
					}
					
					for (int l = 0; l < enemies.size(); l++) {
						Enemy enemy = enemies.get(l);
						if(bullet.x >= enemy.x && bullet.x <= enemy.x + 30 &&
								bullet.y >= enemy.y && bullet.y < enemy.y + 20) {
							enemies.remove(l);
							score += 10;
						}
					}
					
				}
				
				
				gra.setColor(Color.RED);
				
				
				
				for (int i = 0; i < enemies.size(); i++) {
					Enemy enemy = enemies.get(i);
					gra.fillRect(enemy.x, enemy.y, 30, 10);
					gra.fillRect(enemy.x + 10, enemy.y + 10, 10, 10);
					
					enemy.y += 3;
					if(enemy.y > 500) enemies.remove(i);
					if(random.nextInt(level<50?80 - level:30)== 1) bullets_enemy.add(new Bullet(enemy.x, enemy.y));
					if((enemy.x >= playerX && enemy.x <= playerX + 30 &&
							enemy.y >= playerY && enemy.y <= playerY + 20)||
						(enemy.x + 30 >= playerX && enemy.x + 30 <= playerX + 30 &&
							enemy.y + 20 >= playerY && enemy.y + 20 <= playerY + 20)) {
							screen = EnumShootingScreen.GAME_OVER;
							score += (level - 1) * 100;
						}
					}
				
				if(random.nextInt(level<10?30 - level:30)== 1) enemies.add(new Enemy(random.nextInt(450), 0));
				
				for(int i = 0; i < bullets_enemy.size();i++) {
					Bullet bullet = bullets_enemy.get(i);
					gra.setColor(Color.RED);
					gra.fillRect(bullet.x, bullet.y, 5, 5);
					bullet.y +=10;
					
					if(bullet.y>500) {bullets_enemy.remove(i); i--;}
					if(bullet.x >= playerX && bullet.x <= playerX + 30 &&
						bullet.y >= playerY && bullet.y <= playerY + 20) {
						screen = EnumShootingScreen.GAME_OVER;
						score += (level - 1) * 100;
					}
				}
				
				if(Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && playerX>0) playerX-=5;
				if(Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && playerX<455) playerX+=5;
				if(Keyboard.isKeyPressed(KeyEvent.VK_UP) && playerY>50) playerY-=5;
				if(Keyboard.isKeyPressed(KeyEvent.VK_DOWN) && playerY<430) playerY+=5;
				
				
				if(Keyboard.isKeyPressed(KeyEvent.VK_A)&&bulletInterval==0) {
					bullets_player.add(new Bullet(playerX + 12, playerY));
					bulletInterval = 8;
				}
				
				if(bulletInterval>0) bulletInterval--;
				
				gra.setColor(Color.BLACK);
				gra.setFont(new Font("SansSerif", Font.PLAIN, 20));
				gra.drawString("SCORE:" + score, 10, 20);
				gra.drawString("LEVEL:" + level, 10, 40);
				
				break;
			case GAME_OVER:
				gra.setColor(Color.BLACK);
				font = new Font("SansSerif", Font.PLAIN, 50);
				gra.setFont(font);
				metrics = gra.getFontMetrics(font);
				gra.drawString("Game Over", 250 - (metrics.stringWidth("Game Over") / 2), 100);				
				
				font = new Font("SansSerif", Font.PLAIN, 20);
				gra.setFont(font);
				metrics = gra.getFontMetrics(font);
				gra.drawString("Score: " + score, 250 - (metrics.stringWidth("Score: " + score) / 2), 150);				
				gra.drawString("Press ESC to Return Start Screen", 250 - (metrics.stringWidth("Press ESC to Return Start Screen") / 2), 200);				
				
				if (Keyboard.isKeyPressed(KeyEvent.VK_ESCAPE)) {
					screen = EnumShootingScreen.START;
				}
				
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
