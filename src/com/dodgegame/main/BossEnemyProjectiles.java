package com.dodgegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemyProjectiles extends GameObject{
	
	private Handler handler;
	Random r = new Random();

	public BossEnemyProjectiles(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velocityX = (r.nextInt(5 - -5) + -5);
		velocityY = 5;
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	
	public void tick() {
		x += velocityX;
		y += velocityY;
		
		// set the bounds of the NPC within JFrame
		//if (x <= 0 || x >= Game.WIDTH - 32) velocityX *= -1; 
		//if (y <= 0 || y >= Game.HEIGHT - 52) velocityY *= -1; 
		
		if (y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 16, 16);
	}
	
}
