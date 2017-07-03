package server.game.events;

import server.game.board_02.messages.Ingame_MoveFigures;

public interface IListener {
	
	public void handle(Object obj);

	public boolean handle(Ingame_MoveFigures message);
	
}
