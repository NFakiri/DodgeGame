package com.dodgegame.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -4205364525572216790L;

	// Height and Width dimensions of the Window
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;

	// Constructor method creating, creating new Window object.
	public Game() {
		new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
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

	}

	public static void main(String[] args) {
		new Game();
	}

}
