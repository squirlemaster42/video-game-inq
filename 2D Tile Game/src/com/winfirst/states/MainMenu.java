package com.winfirst.states;

import java.awt.Graphics;

import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

public class MainMenu extends State{

	public MainMenu(Handler handler){
		super(handler);
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.mainMenu, 0, 0, null);
	}

}
