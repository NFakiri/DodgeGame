package com.dodgegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}

	@Override
	public void tick() {
		x += velocityX;
		y += velocityY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 48);
		y = Game.clamp(y, 0, Game.HEIGHT - 70);
	}

	@Override
	public void render(Graphics g) {
		if (id == ID.Player) g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	

}
