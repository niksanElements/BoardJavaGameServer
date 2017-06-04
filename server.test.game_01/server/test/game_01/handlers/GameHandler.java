package server.test.game_01.handlers;

import server.IHandler;
import server.game.IGameEngine;
import server.game.IPlayer;
import server.game.board_02.messages.Lobby_NewGameRequest;
import server.game.board_02.messages.Message;
import server.game_01.impl.DefaultPlayer;

public class GameHandler implements IHandler {
	
	private IGameEngine gameEngine;
	private IPlayer player;
	
	public GameHandler(IGameEngine gameEngine) {
		this.gameEngine = gameEngine;
		this.player = null;
	}

	@Override
	public void handel(Message msg) {
		if(msg instanceof Lobby_NewGameRequest) {
			Lobby_NewGameRequest request = (Lobby_NewGameRequest) msg;
			
			player = new DefaultPlayer(msg.username);
			
			gameEngine.setPlayer(player, request.boardShape);
			
		}
	}

}
