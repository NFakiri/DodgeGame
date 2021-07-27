package com.dodgegame.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -4205364525572216790L;
	
	// Height and Width dimensions of the Window
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;

	// Constructor method creating, creating new Window object.
	public Game() {
		new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
	}
	
	public synchronized void start() {
		
	}
	
	public void run() {
		
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
