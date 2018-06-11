package com.winfirst.pacman;

import com.winfirst.utils.Handler;

import java.awt.*;

public class Board {
	
	private Handler handler;
	private Pacman player;
	private Ghost ghost1;
	private Ghost ghost2;
	private Ghost ghost3;
	private Ghost ghost4;
	private int[][] path;
	
	public Board(Handler handler) {
		this.handler = handler;
		this.player = new Pacman(handler, 500.0f, 500.0f, 25, 25, 0, 0);
		this.ghost1 = new Ghost(handler, 600.0f, 500.0f, 25, 25, 0, 0, player);
		this.ghost2 = new Ghost(handler, 650.0f, 500.0f, 25, 25, 0, 0, player);
		this.ghost3 = new Ghost(handler, 700.0f, 500.0f, 25, 25, 0, 0, player);
		this.ghost4 = new Ghost(handler, 750.0f, 500.0f, 25, 25, 0, 0, player);
		path = new int [31][27];
		
		
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
		
		//  First half of walls in maze part
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
		
		for(int wall = 6; wall < 8; wall ++) {
			for (int wallcol = 10; wallcol < 18; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 6; wall < 13; wall ++) {
			for (int wallcol = 19; wallcol < 21; wallcol ++)
				a[wall][wallcol] = 5;
		}
		for(int wall = 9; wall < 11; wall ++) {
			for (int wallcol = 9; wallcol < 12; wallcol ++)
				a[wall][wallcol] = 5;
		}
		for(int wall = 8; wall < 11; wall ++) {
			a[wall][13] = 5;
			a[wall][14] = 5;
		}
		for(int wall = 6; wall < 13; wall ++) {
			for (int wallcol = 19; wallcol < 21; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 9; wall < 11; wall ++) {
			for (int wallcol = 16; wallcol < 20; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 15; wall < 20; wall ++) {
			for (int wallcol = 7; wallcol < 9; wallcol ++)
				a[wall][wallcol] = 5;
		}
		for(int wall = 15; wall < 20; wall ++) {
			for (int wallcol = 19; wallcol < 21; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 18; wall < 20; wall ++) {
			for (int wallcol = 10; wallcol < 18; wallcol ++)
				a[wall][wallcol] = 5;
		}
		// second half
		
		for(int wall = 21; wall < 23; wall ++) {
			for (int wallcol = 2; wallcol < 6; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 21; wall < 23; wall ++) {
			for (int wallcol = 7; wallcol < 12; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 19; wall < 23; wall ++) {
			a[wall][13] = 5;
			a[wall][14] = 5;
		}
		
		for(int wall = 21; wall < 23; wall ++) {
			for (int wallcol = 16; wallcol < 21; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 21; wall < 23; wall ++) {
			for (int wallcol = 22; wallcol < 26; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 23; wall < 26; wall ++) {
			for (int wallcol = 4; wallcol < 6; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 23; wall < 26; wall ++) {
			for (int wallcol = 22; wallcol < 24; wallcol ++)
				a[wall][wallcol] = 5;
		}
		for(int wall = 24; wall < 26; wall ++) {
			for (int wallcol = 25; wallcol < 26; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 24; wall < 26; wall ++) {
			for (int wallcol = 0; wallcol < 3; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 24; wall < 26; wall ++) {
			for (int wallcol = 10; wallcol < 18; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 26; wall < 29; wall ++) {
			a[wall][13] = 5;
			a[wall][14] = 5;
		}
		
		for(int wall = 27; wall < 29; wall ++) {
			for (int wallcol = 2; wallcol < 12; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 27; wall < 29; wall ++) {
			for (int wallcol = 16; wallcol < 26; wallcol ++)
				a[wall][wallcol] = 5;
		}
		
		for(int wall = 24; wall < 27; wall ++) {
			for (int wallcol = 7; wallcol < 9; wallcol ++)
				a[wall][wallcol] = 5;
		}
		for(int wall = 24; wall < 27; wall ++) {
			for (int wallcol = 19; wallcol < 21; wallcol ++)
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
		ghost1.tick();
		ghost2.tick();
		ghost3.tick();
		ghost4.tick();
		/*
		if(checkEntityCollision(x, 0, player)){
            player.setY(-50);
        }

        if(checkEntityCollision(ghost1.getX(), ghost1.getY(), player)){
            player.setY(-50);
        }
*/
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
		ghost1.render(g);
		ghost2.render(g);
		ghost3.render(g);
		ghost4.render(g);
		
	}
	

}
