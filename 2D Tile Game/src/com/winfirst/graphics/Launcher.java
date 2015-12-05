package com.winfirst.graphics;

import com.winfirst.game.Game;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("RPG Game", 640, 360);
		game.start();   
		
	}
}
