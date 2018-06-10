package com.winfirst.pacman;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Ghost extends Entity{
	private int arrRow;
	private int arrCol;
		
	public Ghost (Handler handler, float x, float y, int width, int height, int row, int col) {
		super(handler, x, y, width, height);
		this.arrRow = row;
		this.arrCol = col;
	}
			
	public void tick() {
	}
	
	public void render(Graphics g) {
	      g.setColor(Color.RED);
	      g.fillRect((int) x, (int) y, width, height);

	}
}