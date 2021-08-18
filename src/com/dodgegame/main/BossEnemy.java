package com.dodgegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject{
	
	private Handler handler;
	Random r = new Random();
	
	private int timer = 80;
	private int timer2 = 50;

	public BossEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velocityX = 0;
		velocityY = 2;
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 96, 96);
	}

	
	public void tick() {
		x += velocityX;
		y += velocityY;

		if (timer <= 0) velocityY = 0;
		else timer--;
		
		if (timer <= 0) timer2--;
		if (timer2 <= 0)
		{
			if(velocityX == 0) velocityX = 2;
			int spawn = r.nextInt(10);
			if (spawn == 0) handler.addObject(new BossEnemyProjectiles((int) x + 48, (int) y + 48, ID.BasicEnemy, handler));
		}
		
		// set the bounds of the NPC within JFrame
		if (x <= 0 || x >= Game.WIDTH - 96) velocityX *= -1; 
		//if (y <= 0 || y >= Game.HEIGHT - 52) velocityY *= -1; 
		
		 //handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.01f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 96, 96);
	}
	
}
