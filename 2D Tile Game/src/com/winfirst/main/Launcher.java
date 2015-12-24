package com.winfirst.main;

import com.winfirst.game.Game;
import com.winfirst.sound.Sound;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("RPG Game", 720, 480);
		game.start();
	}
}
