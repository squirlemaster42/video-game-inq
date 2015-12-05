package com.winfirst.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.winfirst.graphics.Display;

public class Game implements Runnable{
	
	private Display display;
	
	public int width, height;
	public String title;
	
	public boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init(){
		display = new Display(title, width, height);
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
		  
		  g.fillRect(0, 0, width, height);
		  
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
