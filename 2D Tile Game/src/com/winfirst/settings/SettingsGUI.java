package com.winfirst.settings;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

//To be implemented
public class SettingsGUI {
	
	private int guiWidth;
	private int guiHeight;
	private String[] size;
	private int width;
	private int height;
	private String[] displayDims;
	
	public SettingsGUI(int width, int height){
		this.width = width;
		this.height = height;
		
		displayDims = new String[] {"640, 480", "720, 576", "1280, 720", "1920, 1080"};
		
		size = new String[4];
		size[0] = "640 480";
		size[1] = "720 576";
		size[2] = "1280 720";
		size[3] = "1920 1080";
	}
	
	public void makeSettingsGui(){
		JFrame frame = new JFrame("Settings");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JLabel label = new JLabel("Chose A Dimension");
		JComboBox<String> dimList = new JComboBox<>(displayDims);
		JButton button = new JButton("Click to lock in size");
		
		frame.add(label);
		frame.add(dimList);
		frame.add(button);
	}
	
	public int getGUIWidth(){
		return guiWidth;
	}
	
	public int getGUIHeight(){
		return guiHeight;
	}
}
