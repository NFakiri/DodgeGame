package com.dodgegame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// All key events for player 1.
				if (keyPressed == KeyEvent.VK_W) tempObject.setVelocityY(-5);
				if (keyPressed == KeyEvent.VK_S) tempObject.setVelocityY(5);
				if (keyPressed == KeyEvent.VK_A) tempObject.setVelocityX(-5);
				if (keyPressed == KeyEvent.VK_D) tempObject.setVelocityX(5);
			}
			
			if (tempObject.getId() == ID.Player2) {
				// All key events for player 2
				if (keyPressed == KeyEvent.VK_UP) tempObject.setVelocityY(-5);
				if (keyPressed == KeyEvent.VK_DOWN) tempObject.setVelocityY(5);
				if (keyPressed == KeyEvent.VK_LEFT) tempObject.setVelocityX(-5);
				if (keyPressed == KeyEvent.VK_RIGHT) tempObject.setVelocityX(5);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// All key events for player 1.
				if (keyPressed == KeyEvent.VK_W) tempObject.setVelocityY(0);
				if (keyPressed == KeyEvent.VK_S) tempObject.setVelocityY(0);
				if (keyPressed == KeyEvent.VK_A) tempObject.setVelocityX(0);
				if (keyPressed == KeyEvent.VK_D) tempObject.setVelocityX(0);
			}
			
			if (tempObject.getId() == ID.Player2) {
				// All key events for player 2
				if (keyPressed == KeyEvent.VK_UP) tempObject.setVelocityY(0);
				if (keyPressed == KeyEvent.VK_DOWN) tempObject.setVelocityY(0);
				if (keyPressed == KeyEvent.VK_LEFT) tempObject.setVelocityX(0);
				if (keyPressed == KeyEvent.VK_RIGHT) tempObject.setVelocityX(0);
			}
		}
	}
}
