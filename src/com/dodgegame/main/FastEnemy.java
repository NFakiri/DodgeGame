package com.dodgegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{
	
	private Handler handler;

	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velocityX = 2;
		velocityY = 9;
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
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.02f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 16, 16);
	}
	
}
