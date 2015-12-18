package com.winfirst.sound;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	private String path;
	private Clip clip;
	private File file;
	
	public Sound(String path){
		this.path = path;
		
		file = new File(path);
	}
	
	public void playSound(){
		try{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength() / 1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Getters and Setters
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
