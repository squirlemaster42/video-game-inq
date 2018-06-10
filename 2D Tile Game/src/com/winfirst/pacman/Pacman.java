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
		}
		if (handler.getKeyManager().down) {
			ymove = 3;
			xmove = 0;
		}
		if (handler.getKeyManager().left) {
			xmove = -3;
			ymove = 0;
		}
		if (handler.getKeyManager().right) {
			xmove = 3;
			ymove = 0;
		}
		x += xmove;
		y += ymove;
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
