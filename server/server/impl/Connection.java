package server.impl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import server.game.board_02.messages.Message;


public class Connection {
	private static Map<String, ObjectOutputStream> connections = 
			new HashMap<String, ObjectOutputStream>();
	
	
	public static void add(String name,ObjectOutputStream out){
		synchronized (connections) {
			connections.put(name, out);
		}
	}
	
	public static void send(String name,Message msg){
		synchronized (connections) {
			try {
				connections.get(name).writeObject(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
