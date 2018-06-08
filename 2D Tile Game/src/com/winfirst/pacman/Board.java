package com.winfirst.pacman;

import com.winfirst.utils.Handler;

import java.awt.*;

public class Board {
	
	private Handler handler;
	private Pacman player;
	private int [][] path;
	
	public Board(Handler handler) {
		this.handler = handler;
		this.player = new Pacman(handler, 50.0, 50.0, 10, 10, 0, 0);
		
	}
	
	public void tick() {
		player.tick();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
		player.render(g);
	}
	
}
