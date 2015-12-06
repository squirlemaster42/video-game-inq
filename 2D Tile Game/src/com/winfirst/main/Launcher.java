package com.winfirst.main;

import com.winfirst.game.Game;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("RPG Game", 1280, 720);
		game.start();   
		
	}
}
