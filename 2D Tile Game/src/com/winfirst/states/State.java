package com.winfirst.states;

import java.awt.Graphics;

import com.winfirst.utils.Handler;

public abstract class State {
	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//Manager
	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}

}
