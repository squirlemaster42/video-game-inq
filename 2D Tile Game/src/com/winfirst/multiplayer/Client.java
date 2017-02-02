package com.winfirst.multiplayer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
	private Socket socket;
	private int port;
	private String ip;
	private boolean running;
	private Thread thread;
	
	public Client(int port, String ip){
		this.port = port;
		this.ip = ip;
		this.running = false;
		try {
			this.socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init(){
		
	}

	@Override
	public void run() {
		init();
		
		while(running){
			
		}
	}
	
	public synchronized void start(){
		if(!running){
			this.thread = new Thread(this);
			this.thread.start();
			running = true;
		}
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

	public Socket getSocket() {
		return socket;
	}

	public int getPort() {
		return port;
	}

	public String getIp() {
		return ip;
	}

	public boolean isRunning() {
		return running;
	}

	public Thread getThread() {
		return thread;
	}	

}
