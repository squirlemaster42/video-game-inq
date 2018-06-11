package com.winfirst.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
        rectangleStateMap.put(new Rectangle(789, 122, 425, 130), stateMap.get("Space"));
        rectangleStateMap.put(new Rectangle(844, 474, 309, 99), stateMap.get("Pong"));
	}
	
	@Override
	public void tick() {
        for(Map.Entry<Rectangle, State> entry : rectangleStateMap.entrySet()){
            if(entry.getKey().contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY()) && handler.getMouseManager().isLeftPressed()){
                handler.getGame().setState(rectangleStateMap.get(entry.getKey()));
            }
        }
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.mainMenu, 0, 0, null);

		g.setColor(Color.GREEN);
		for(Map.Entry<Rectangle, State> entry : rectangleStateMap.entrySet()){
		    if(entry.getKey().contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())){
		        g.fillRect(entry.getKey().x, entry.getKey().y, entry.getKey().width, entry.getKey().height);
            }
        }
	}

}
