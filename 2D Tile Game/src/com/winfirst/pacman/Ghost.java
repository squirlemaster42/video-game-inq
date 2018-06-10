package com.winfirst.pacman;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Ghost extends Entity{
	private int arrRow;
	private int arrCol;
	private Pacman player;

		
	public Ghost (Handler handler, float x, float y, int width, int height, int row, int col, Pacman player) {
		super(handler, x, y, width, height);
		this.arrRow = row;
		this.arrCol = col;
		this.player = player;
	}
			
	public void tick() {
		if (player.getX() < x)
			x -= 2;
		else if (player.getX() > x)
			x += 2;
		if (player.getY() < y)
			y -= 2;
		else if (player.getY() > y)
			y += 2;
		
		/*if(checkEntityCollision(x, y, Pacman player)){
            xMove ;
        }

        if(checkEntityCollision(x, y, Pacman player)){
            yMove *= -1;
        }

		*/
		
	
	
	}
	public void render(Graphics g) {
	      g.setColor(Color.RED);
	      g.fillRect((int) x, (int) y, width, height);

	}
	
	

	
}