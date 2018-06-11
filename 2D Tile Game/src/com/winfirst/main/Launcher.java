package com.winfirst.main;

import com.winfirst.game.Game;

public class Launcher {
	
	public static void main(String[] args) {
//		SettingsGUI settings = new SettingsGUI(300, 300);
//		settings.makeSettingsGui();
		
		Game game = new Game("Video Games in America", 1280, 720);
		game.start();
	}
	
	/* 
	 * To do:
	 * Finish Settings GUI and implement
	 * 
	 * Done:
	 * Complete Render Order
	 * Fixed Tree Bounds
	 * Added Settings GUI class
	 * Added No Movement Animation
	 */
}
