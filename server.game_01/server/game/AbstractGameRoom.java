package server.game;

import server.game.events.IListener;

import java.util.ArrayList;

import server.game.IGameEngine.Mode;
import server.game.events.IDisconnect;

public abstract class AbstractGameRoom implements IListener, IDisconnect{
	
	protected IPlayer players[];
	protected Status status;
	protected int mode;
	private int id;
	
	public AbstractGameRoom()
	{
		status = Status.NOT_CREATED;
	}
	
	/**
	 * session status types
	 */
	public enum Status
	{
		NOT_CREATED,CREATED,CREATING
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPlayers(IPlayer players[]){
		this.players = players;
	}
	
	public void setMode(int mode){
		this.mode = mode;
	}
	
	public abstract void createGameRoom(ArrayList<IPlayer> players,int mode);

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return this.status;
	}
	
	public abstract void close();
	
	
}
