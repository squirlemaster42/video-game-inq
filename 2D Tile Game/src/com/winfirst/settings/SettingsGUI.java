package com.winfirst.settings;

import javax.swing.JFrame;

//To be implemented
public class SettingsGUI {
	
	private int guiWidth;
	private int guiHeight;
	
	public void makeSettingsGui(){
		JFrame frame = new JFrame("Settings");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public int getGUIWidth(){
		return guiWidth;
	}
	
	public int getGUIHeight(){
		return guiHeight;
	}
}
