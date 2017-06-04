package server.game_01.impl;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.communication.BoardAction;
import server.game.AbstractGameRoom;
import server.game.IPlayer;
import server.game.board_02.messages.Ingame_MoveFigures;
import server.game.board_02.messages.Message;
import server.game.events.IDisconnect;
import server.game.events.IListener;

public class DefaultPlayer implements IPlayer {
	
	private IListener listener;
	private IDisconnect disconnect;
	
	private String name;
	private int emailId;
	private boolean move;
	
	private Socket socket;
	
	public DefaultPlayer(String name) {
		this.name = name;
		this.emailId = 0;
		this.move = false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public int getEmailId() {
		return emailId;
	}

	@Override
	public void setEmailId(int emailId) {
		this.emailId = emailId;
		
	}

	@Override
	public void addGameRoom(AbstractGameRoom gameRoom) {
		listener = gameRoom;
		disconnect = gameRoom;
	}

	@Override
	public void removeGameRoom() {
		listener = null;
		disconnect = null;
		
	}

	@Override
	public int[] getFiguresIds() {
		// TODO connect with the player and get his id's of figures
		return null;
	}

	@Override
	public boolean isMyMove() {
		return move;
	}

	@Override
	public void setMyMove(boolean flag) {
		this.move = flag;
		
	}

	@Override
	public void logout() {
		this.disconnect.onDisconnect(this);
		
	}

	@Override
	public boolean setMessage(Message msg) {
		boolean result = false;
		
		if(msg instanceof Ingame_MoveFigures){
			result = this.listener.handle((Ingame_MoveFigures)msg);
		}
		
		return result;
	}

	@Override
	public void sendMessage(Message msg) {
		try {
			new ObjectOutputStream(this.socket.getOutputStream()).writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
