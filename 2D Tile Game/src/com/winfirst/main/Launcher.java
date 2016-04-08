package com.winfirst.main;

import com.winfirst.game.Game;

public class Launcher {
	
	public static void main(String[] args) {
//		SettingsGUI settings = new SettingsGUI(300, 300);
//		settings.makeSettingsGui();
		
		Game game = new Game("RPG Game", 1280, 720);
		game.start();
	}
	
	/* 
	 * To do:
	 * Finish Settings GUI and implement
	 * 
	 */
}
