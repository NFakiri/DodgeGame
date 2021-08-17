package com.dodgegame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		for (int i = 0; i < keyDown.length; i++) {
			keyDown[i] = false;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		
		for (int i = 0; i < handler.objectList.size(); i++) {
			GameObject tempObject = handler.objectList.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// All key events for player 1.
				if (keyPressed == KeyEvent.VK_W) { tempObject.setVelocityY(-5); keyDown[0] = true; }
				if (keyPressed == KeyEvent.VK_S) { tempObject.setVelocityY(5); keyDown[1] = true; }
				if (keyPressed == KeyEvent.VK_A) { tempObject.setVelocityX(-5); keyDown[2] = true; }
				if (keyPressed == KeyEvent.VK_D) { tempObject.setVelocityX(5); keyDown[3] = true; }
			}
		}
		
		if (keyPressed == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		
		for (int i = 0; i < handler.objectList.size(); i++) {
			GameObject tempObject = handler.objectList.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// All key events for player 1.
				if (keyPressed == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelocityY(0);
				if (keyPressed == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelocityY(0);
				if (keyPressed == KeyEvent.VK_A) keyDown[2] = false;  //tempObject.setVelocityX(0);
				if (keyPressed == KeyEvent.VK_D) keyDown[3] = false; //tempObject.setVelocityX(0);
				
				// Vertical movement.
				if (!keyDown[0] && !keyDown[1]) tempObject.setVelocityY(0);
				
				// Horizontal movement.
				if (!keyDown[2] && !keyDown[3]) tempObject.setVelocityX(0);
			}
		}
	}
}
