package com.dodgegame.main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		//hud.setScore(hud.getScore() + 1);
		
		if (hud.getScore() % 100 == 0) {
			hud.setLevel(hud.getLevel() + 1);
		
			/*
		if (hud.getLevel() == 2) {
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 52), ID.BasicEnemy, handler));
		} else if (hud.getLevel() == 3) {
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 52), ID.BasicEnemy, handler));
		} else if (hud.getLevel() == 4) {
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 52), ID.FastEnemy, handler));
		} else if (hud.getLevel() == 5) {
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 52), ID.SmartEnemy, handler));
			} */
		
		}
		
	}
}
	
