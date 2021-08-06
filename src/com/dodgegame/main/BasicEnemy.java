package com.dodgegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		
		velocityX = 5;
		velocityY = 5;
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	
	public void tick() {
		x += velocityX;
		y += velocityY;
		
		// set the bounds of the NPC within JFrame
		if (x <= 0 || x >= Game.WIDTH - 32) velocityX *= -1; 
		
		if (y <= 0 || y >= Game.HEIGHT - 52) velocityY *= -1; 
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
}
