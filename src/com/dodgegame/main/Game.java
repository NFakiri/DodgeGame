package com.dodgegame.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -4205364525572216790L;

	// Height and Width dimensions of the Window
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawn;
	private Menu menu;
	
	public enum STATE {
		Menu,
		Help,
		Game,
		End
	};
	
	public STATE gameState = STATE.Menu;

	// Constructor method creating, creating new Window object.
	public Game() {
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		
		AudioPlayer.load();
		
		AudioPlayer.getMusic("music").loop();
		
		new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
		
		spawn = new Spawn(handler, hud);
		r = new Random();
		
		if (gameState == STATE.Game) {
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 52), ID.BasicEnemy, handler));
		} else { 
			for (int i = 0; i < 18; i++) {
				handler.addObject(new MenuParticle(r.nextInt(WIDTH - 32), r.nextInt(HEIGHT - 52), ID.MenuParticle, handler));
			}
		}
	}

	// Start the thread
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	// Stop the thread
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS " + frames);
				frames = 0;
			}
		}
	}


	private void tick() {
		if (gameState == STATE.Game) {
			if (!paused) {
				hud.tick();
				spawn.tick();
				handler.tick();
				
				if (HUD.HEALTH <= 0) {
					gameState = STATE.End;
					handler.objectList.clear();
					for (int i = 0; i < 18; i++) {
						handler.addObject(new MenuParticle(r.nextInt(WIDTH - 32), r.nextInt(HEIGHT - 52), ID.MenuParticle, handler));
					}
				}
			}
			
		} else if (gameState == STATE.Menu || gameState == STATE.End) {
			menu.tick();
			handler.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if (paused) {
			g.setColor(Color.white);
			g.drawString("PAUSED", 100, 100);
		}
		
		if (gameState == STATE.Game) {
			hud.render(g);
		} else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}

	public static void main(String[] args) {
		new Game();
	}

}
