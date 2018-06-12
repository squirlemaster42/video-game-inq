package com.winfirst.pacman;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Ghost extends Entity{
	private int arrRow;
	private int arrCol;
	private Pacman player;
	private int[][] path;
		
	public Ghost (Handler handler, float x, float y, int width, int height, int row, int col, Pacman player, int[][] map) {
		super(handler, x, y, width, height);
		this.arrRow = row;
		this.arrCol = col;
		this.player = player;
		this.path = map;
	}
			
	public void tick() {
		if (player.getX() < x && canMoveUp(path)) {
			x -= 2;

		}
		else if (player.getX() > x && canMoveDown(path)) {
			x += 2;

		}
		if (player.getY() < y && canMoveLeft(path)) {
			y -= 2;
	
		}
		else if (player.getY() > y && canMoveRight(path)) {
			y += 2;
			
		}
		
		/*if(checkEntityCollision(x, y, Pacman player)){
            xMove ;
        }

        if(checkEntityCollision(x, y, Pacman player)){
            yMove *= -1;
        }

		*/
	}
	public boolean canMoveUp(int[][] path) {
		if (path[arrRow - 1][arrCol] == 5)
			return false;
		else {
			if (arrRow > 0) {
			path[arrRow][arrCol] = 0;
			path[arrRow - 1][arrCol] = 2;
			}
			return true;
		}
	}
	
	public boolean canMoveDown(int[][] path) {
		if (path[arrRow + 1][arrCol] == 5)
			return false;
		else {
			if (arrRow < 30) {
			path[arrRow][arrCol] = 0;
			path[arrRow + 1][arrCol] = 2;
			}
			return true;
		}
			
	}
	
	public boolean canMoveLeft(int[][] path) {
		if (path[arrRow][arrCol - 1] == 5)
			return false;
		else {
			if (arrCol > 0) {
			path[arrRow][arrCol] = 0;
			path[arrRow][arrCol - 1] = 2;
			}
			return true;
		}
	}
	
	public boolean canMoveRight(int[][] path) {
		if (path[arrRow][arrCol + 1] == 5)
			return false;
		else {
			if (arrCol < 26) {
			path[arrRow][arrCol] = 0;
			path[arrRow][arrCol + 1] = 2;
			}
			return true;
		}
	}
	
	
	public void render(Graphics g) {
	      g.setColor(Color.RED);
	      g.fillRect((int) x, (int) y, width, height);

	}
	
	

	
}