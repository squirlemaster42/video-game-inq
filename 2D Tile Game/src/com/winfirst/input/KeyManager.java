package com.winfirst.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean p1Up, p1Down, p2Up, p2Down, up, down, left, right;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		p2Up = keys[KeyEvent.VK_UP];
		p2Down = keys[KeyEvent.VK_DOWN];
		p1Up = keys[KeyEvent.VK_W];
		p1Down = keys[KeyEvent.VK_S];

		up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	
}
