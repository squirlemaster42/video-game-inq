package com.winfirst.states;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

public class MainMenu extends State{

	private Map<Rectangle, State> rectangleStateMap;

	public MainMenu(Handler handler, Map<String, State> stateMap){
		super(handler);
		rectangleStateMap = new HashMap<>();
		rectangleStateMap.put(new Rectangle(71, 129, 405, 96), stateMap.get("Pacman"));
        rectangleStateMap.put(new Rectangle(82, 409, 355, 246), stateMap.get("Tetris"));
        rectangleStateMap.put(new Rectangle(790, 124, 425, 121), stateMap.get("Space"));
        rectangleStateMap.put(new Rectangle(845, 474, 309, 99), stateMap.get("Pong"));
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.mainMenu, 0, 0, null);
	}

}
