package com.dodgegame.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	
	private float alpha = 1; 
	private float particleLife; // life is a value between 0.001 and 0.1
	
	
	private Handler handler;
	private Color color;
	
	private int height, width;
	
	public Trail(int x, int y, ID id, Color color, int height, int width, float particleLife, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.height = height;
		this.width = width;
		this.particleLife = particleLife;
	}

	@Override
	public void tick() {
		if (alpha > particleLife) {
			alpha -= particleLife - 0.0001f;
		} else {
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect(x, y, height, width);
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
	
}
