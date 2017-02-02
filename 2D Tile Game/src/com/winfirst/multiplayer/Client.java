package com.winfirst.multiplayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.winfirst.entity.Entity;

public class Client implements Runnable{
	private Socket socket;
	private int port;
	private String ip;
	private boolean running;
	private Thread thread;
	private PrintWriter pw;
	private ArrayList<Entity> entArr;
	
	public Client(int port, String ip){
		this.port = port;
		this.ip = ip;
		this.running = false;
		entArr = new ArrayList<>();
		try {
			this.socket = new Socket(ip, port);
			this.pw = new PrintWriter(socket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init(){
		pw.println("Connected");
	}
	
	private void writePosition(Position position){
		pw.println(position.toString());
	}

	@Override
	public void run() {
		init();
		
		while(running){
			entArr.forEach((e) -> writePosition(new Position(e.getX(), e.getY())));
		}
	}
	
	public void addEntity(Entity e){
		entArr.add(e);
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
