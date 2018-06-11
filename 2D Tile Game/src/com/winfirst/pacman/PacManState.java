package com.winfirst.pacman;

import com.winfirst.states.State;
import com.winfirst.utils.Handler;

import java.awt.Graphics;

public class PacManState extends State{
	
	private Board board;
	
	public PacManState (Handler handler) {
		super(handler);
		board = new Board(handler);
		
	}
	
	public void tick() {
		board.tick();
	}
	
	public void render(Graphics g) {
		board.render(g);
		
	}
}
