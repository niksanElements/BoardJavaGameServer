package server.game.events;

import server.communication.BoardAction;

public interface IListener {
	
	public void handle(Object obj);

	public boolean handle(BoardAction message);
	
}
