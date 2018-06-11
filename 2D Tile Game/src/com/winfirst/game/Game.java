package com.winfirst.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

import com.winfirst.graphics.Display;
import com.winfirst.graphics.GameCamera;
import com.winfirst.input.KeyManager;
import com.winfirst.input.MouseManager;
import com.winfirst.pacman.PacManState;
import com.winfirst.pong.PongState;
import com.winfirst.space.SpaceState;
import com.winfirst.states.GameState;
import com.winfirst.states.MainMenu;
import com.winfirst.states.State;
import com.winfirst.tetris.TetrisState;
import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

public class Game implements Runnable{
	
	private Display display;
	
	private int width, height;
	public String title;
	
	public boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	private State pongState;
	private State spaceState;
	private State tetrisState;
	private State pacManState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		pongState = new PongState(handler);
		spaceState = new SpaceState(handler);
		tetrisState = new TetrisState(handler);
		pacManState = new PacManState(handler);
		Map<String, State> stateMap = new HashMap<>();
		stateMap.put("Tetris", tetrisState);
		stateMap.put("Pacman", pacManState);
		stateMap.put("Pong", pongState);
		stateMap.put("Space", spaceState);
		menuState = new MainMenu(handler, stateMap);
		//State.setState(pacManState);
		State.setState(menuState);
	}
	
	
	public void tick(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	public void render(){
		  bs = display.getCanvas().getBufferStrategy();
		  
		  if(bs == null){
			  display.getCanvas().createBufferStrategy(3);
			  return;
		  }
		  
		  g = bs.getDrawGraphics();
		  
		  g.clearRect(0, 0, width, height);
		  
		  if(State.getState() != null){
				State.getState().render(g);
		  }
		  
		  bs.show();
		  g.dispose();
	}
	
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println(ticks);
				ticks = 0;
				timer = 0;
			}
			
		} 
		
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}

	public MouseManager getMouseManager(){
	    return mouseManager;
    }

    public void setState(State state){
	    State.setState(state);
    }

	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public Display getDisplay(){
	    return display;
    }

	public Thread getThread(){
		return thread;
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