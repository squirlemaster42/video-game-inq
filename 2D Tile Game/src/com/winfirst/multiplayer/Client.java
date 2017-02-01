package com.winfirst.multiplayer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
	private Socket socket;
	private int port;
	private String ip;
	
	public Client(int port, String ip){
		this.port = port;
		this.ip = ip;
		try {
			this.socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
	}

}
