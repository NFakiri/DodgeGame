package com.dodgegame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.dodgegame.main.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	Game game;
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		
		this.game = game;
		
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
		
		if (keyPressed == KeyEvent.VK_P) {
			if (game.gameState == STATE.Game) {
				if (Game.paused) game.paused = false;
				else Game.paused = true;
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
				if (keyPressed == KeyEvent.VK_W) keyDown[0] = false;
				if (keyPressed == KeyEvent.VK_S) keyDown[1] = false;
				if (keyPressed == KeyEvent.VK_A) keyDown[2] = false; 
				if (keyPressed == KeyEvent.VK_D) keyDown[3] = false;
				
				// Vertical movement - If W or S are not being pressed, set velocity Y to 0.
				if (!keyDown[0] && !keyDown[1]) tempObject.setVelocityY(0);
				
				// Horizontal movement - If A or D are not being pressed, set velocity X to 0.
				if (!keyDown[2] && !keyDown[3]) tempObject.setVelocityX(0);
			}
		}
	}
}
