package com.dodgegame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter{
	
	Game game;
	
	public Menu(Game game) {
		
	}
	
	public void mousePressed(MouseEvent e) {
			
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
		
	}
	
	private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height) {
		if(mouseX > x && mouseX < x + width) {
			if (mouseY > y  && mouseY < y + height) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void render(Graphics g) {
		Font font = new Font("arial", 1, 50);
		Font font2 = new Font("arial", 1, 30);
		
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Menu", 240, 70);
		
		g.setFont(font2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 270, 190);
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 270, 290);
		
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 270, 390);
	}
}
