package server.game_01.impl;

import server.communication.BoardAction;
import server.communication.Message;
import server.game.AbstractGameRoom;
import server.game.IPlayer;
import server.game.events.IDisconnect;
import server.game.events.IListener;

public class DefaultPlayer implements IPlayer {
	
	private IListener listener;
	private IDisconnect disconnect;
	
	private int id;
	private String name;
	private int emailId;
	private boolean move;
	
	
	public DefaultPlayer(int id,String name) {
		this.id = id;
		this.name = name;
		this.emailId = 0;
		this.move = false;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int uniqueKey) {
		id = uniqueKey;
		
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
		boolean result = false;;
		if(msg instanceof BoardAction){
			result = this.listener.handle((BoardAction)msg);
		}
		
		return result;
	}

}
