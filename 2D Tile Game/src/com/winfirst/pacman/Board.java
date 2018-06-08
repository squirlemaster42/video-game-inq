package com.winfirst.pacman;

import com.winfirst.utils.Handler;

import java.awt.*;

public class Board {
	
	private Handler handler;
	private Pacman player;
	private int [][] path;
	
	public Board(Handler handler) {
		this.handler = handler;
		this.player = new Pacman(handler, 500.0f, 500.0f, 25, 25, 0, 0);
		path = new int [30][27];
		
	}
	
	public int [][] buildMap(int[][] a) {
		/*
		 * Creates first row wall
		 */
		for (int wall1 = 0; wall1 <= a[0].length; wall1++) {
			a[0][wall1] = 5;
			}
		/*
		 * creates wall for first column
		 */
		for(int colwall = 0; colwall < 11; colwall++)
			a[colwall][0] = 5;
		for(int colwall = 20; colwall < a.length; colwall++)
			a[colwall][0] = 5;
		
		/*
		 * creates wall for last column
		 */
		
		for(int colwall = 0; colwall < 11; colwall++)
			a[colwall][26] = 5;
		for(int colwall = 20; colwall < a.length; colwall++)
			a[colwall][26] = 5;
		/*
		 * First Row
		 */
		for (int dotLine = 1; dotLine < 13; dotLine++) {
			a[1][dotLine] = 1;
		}
		a[1][13] = 5;
		for (int dotLine = 14; dotLine < 26; dotLine++) {
			a[1][dotLine] = 1;
		}
		
		/*
		 * Last Rows
		 */
		for (int dotLine = 1; dotLine < 26; dotLine++)
			a[31][dotLine] = 1;
		for (int dotLine = 1; dotLine < a[30].length - 1; dotLine++)
			a[30][dotLine] = 1;
		return a;
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
