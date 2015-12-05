package com.winfirst.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.winfirst.graphics.Display;
import com.winfirst.graphics.ImageLoader;
import com.winfirst.graphics.SpriteSheet;

public class Game implements Runnable{
	
	private Display display;
	
	public int width, height;
	public String title;
	
	public boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage test;
	private SpriteSheet sheet;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init(){
		display = new Display(title, width, height); 
		test = ImageLoader.loadImage("/textures/sheet.png");
		sheet = new SpriteSheet(test);
	}
	
	public void tick(){
		
	}
	
	public void render(){
		  bs = display.getCanvas().getBufferStrategy();
		  
		  if(bs == null){
			  display.getCanvas().createBufferStrategy(3);
			  return;
		  }
		  
		  g = bs.getDrawGraphics();
		  
		  g.clearRect(0, 0, width, height);
		  
		  g.drawImage(sheet.crop(0, 0, 32, 32), 5, 5, null);
		  
		  bs.show();
		  g.dispose();
	}
	
	public void run() {
		init();
		
		while(running){
			tick();
			render();
		} 
		
		stop();
	}
	
	public synchronized void start(){
		if(running)return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
