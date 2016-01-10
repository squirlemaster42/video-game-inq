package com.winfirst.main;

import com.winfirst.game.Game;
import com.winfirst.settings.SettingsGUI;

public class Launcher {
	
	public static void main(String[] args) {
		SettingsGUI settings = new SettingsGUI(300, 300);
		settings.makeSettingsGui();
		
//		Game game = new Game("RPG Game", 720, 480);
//		game.start();
	}
	
	/* 
	 * To do:
	 * Finish Settings GUI and implement
	 * Complete Render Order
	 * 
	 * Done:
	 */
}
