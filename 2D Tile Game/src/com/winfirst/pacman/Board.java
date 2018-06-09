package com.winfirst.pacman;

import com.winfirst.utils.Handler;

import java.awt.*;

public class Board {
	
	private Handler handler;
	private Pacman player;
	private int[][] path;
	
	public Board(Handler handler) {
		this.handler = handler;
		this.player = new Pacman(handler, 500.0f, 500.0f, 25, 25, 0, 0);
		path = new int [30][27];
		
	}
	
	public int[][] buildMap(int[][] a) {
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
		
		// walls in maze part
		for(int wall = 2; wall < 5; wall ++) {
			for (int wallcol = 2; wallcol < 6; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 2; wall < 5; wall ++) {
			for (int wallcol = 7; wallcol < 12; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for (int wall = 1; wall < 5; wall++) {
			a[wall][13] = 5;
			a[wall][14] = 5;
		}
		
		for(int wall = 2; wall < 5; wall ++) {
			for (int wallcol = 16; wallcol < 21; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 2; wall < 5; wall ++) {
			for (int wallcol = 22; wallcol < 26; wallcol ++)
				a[wall][wallcol] = 5;
		}

		// WORKING ON NOW
		for(int wall = 6; wall < 8; wall ++) {
			for (int wallcol = 2; wallcol < 6; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 6; wall < 13; wall ++) {
			for (int wallcol = 7; wallcol < 9; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 6; wall < 8; wall ++) {
			for (int wallcol = 22; wallcol < 26; wallcol ++)
				a[wall][wallcol] = 5;
		}
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
		
		for(int wallLine = 2; wallLine < 6; wallLine++)
			a[2][wallLine] = 5;
		
		
		// fills rest of blanks with dots
		// Not taking into account the side openings yet
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; row++) {
				if(a[row][col] == 0 && !(row <= 19 && row >= 10))
					a[row][col] = 1;
			}
		}	
		
		a[3][1] = 4;
		a[3][25] = 4;
		a[23][1] = 4;
		a[23][25] = 4;
			
		return a;
	}
	public void tick() {
		player.tick();
	}
	
	public boolean isWon(int [][] lst) {
		int numDots = 0;
		for (int row = 0; row < lst.length; row++) {
			for (int col = 0; col < lst[row].length; row++) {
				if(lst[row][col] == 1) {
					numDots++;
				}
			}
		}
		if (numDots > 0)
			return false;
		
		else return true;
		}

	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
		player.render(g);
	}
	
}
