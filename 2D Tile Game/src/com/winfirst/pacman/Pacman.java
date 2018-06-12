package com.winfirst.pacman;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Pacman extends Entity {
	private int arrRow;
	private int arrCol;
	private int xmove;
	private int ymove;
	public Pacman (Handler handler, float x, float y, int width, int height, int row, int col) {
		super(handler, x, y, width, height);
		this.arrRow = row;
		this.arrCol = col;
	}
		
	public void tick() {
		if (handler.getKeyManager().up) {
			ymove = -3;
			xmove = 0;
			arrRow --;
		}
		if (handler.getKeyManager().down) {
			ymove = 3;
			xmove = 0;
			arrRow ++;
		}
		if (handler.getKeyManager().left) {
			xmove = -3;
			ymove = 0;
			arrCol --;
		}
		if (handler.getKeyManager().right) {
			xmove = 3;
			ymove = 0;
			arrCol ++;
		}
		x += xmove;
		y += ymove;
	}
	public boolean canMoveUp(int[][] path) {
		if (path[arrRow - 1][arrCol] == 5)
			return false;
		else
			return true;
	}
	
	public boolean canMoveDown(int[][] path) {
		if (path[arrRow + 1][arrCol] == 5)
			return false;
		else
			return true;
	}
	
	public boolean canMoveLeft(int[][] path) {
		if (path[arrRow][arrCol - 1] == 5)
			return false;
		else
			return true;
	}
	
	public boolean canMoveRight(int[][] path) {
		if (path[arrRow][arrCol + 1] == 5)
			return false;
		else
			return true;
	}
	public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y, width, height);
	}
	
	public int getXmove() {
		return xmove;
	}
	public int getYmove() {
		return ymove; 
	}

}
