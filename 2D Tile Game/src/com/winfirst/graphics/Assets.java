package com.winfirst.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player, tree, dirt, grass, mainMenu;
	private static final int width = 32, height = 32;
	
	public static void init(){
		SpriteSheet ground = new SpriteSheet(ImageLoader.loadImage("/textures/ground.png"));
		SpriteSheet character = new SpriteSheet(ImageLoader.loadImage("/textures/largerImage.png"));
		SpriteSheet MainMenu = new SpriteSheet(ImageLoader.loadImage("/textures/MainMenu.png"));
		
		grass = ground.crop(0, 0, width, height);
		dirt = ground.crop(width, 0, width, height);
		player = character.crop(0, 0, 14, 44);
		tree = character.crop(25, 3, 34, 41);
		mainMenu = MainMenu.crop(0, 0, 640, 360);
	}

}
