package com.dodgegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).getId() == ID.Player) {
				player = handler.objectList.get(i);
			}
		}
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	
	public void tick() {
		x += velocityX;
		y += velocityY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
		
		velocityX = (int) Math.round((-1.0/distance) * diffX);
		velocityY = (int) Math.round((-1.0/distance) * diffY);
		
		// set the bounds of the NPC within JFrame
		if (x <= 0 || x >= Game.WIDTH - 32) velocityX *= -1; 
		if (y <= 0 || y >= Game.HEIGHT - 52) velocityY *= -1; 
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.02f, handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 16, 16);
	}
	
}
