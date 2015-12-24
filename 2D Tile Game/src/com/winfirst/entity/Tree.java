package com.winfirst.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.winfirst.tile.Assets;
import com.winfirst.tile.Tile;
import com.winfirst.utils.Handler;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH * 3, Tile.TILEHEIGHT * 3);
		
		//Fix Bounds
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = 64;
	}

	@Override
	public void tick() { 
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()) , (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
	}

}
