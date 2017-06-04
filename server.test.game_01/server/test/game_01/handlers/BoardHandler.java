package server.test.game_01.handlers;

import server.IHandler;
import server.game.IPlayer;
import server.game.board_02.messages.Ingame_EndGame;
import server.game.board_02.messages.Ingame_EndTurn;
import server.game.board_02.messages.Ingame_GameStarted;
import server.game.board_02.messages.Ingame_GameSync;
import server.game.board_02.messages.Ingame_MoveFigures;
import server.game.board_02.messages.Ingame_RemoveFigures;
import server.game.board_02.messages.Message;
import server.game.board_02.messages.Message.MESSAGETYPE;
import server.game.board_02.messages.Success;
import server.impl.Connection;

public class BoardHandler implements IHandler {
	
	private IPlayer player;
	

	@Override
	public void handel(Message msg) {
		if(msg instanceof Ingame_MoveFigures){
			boolean result = player.setMessage(msg);
			if(result){
				// TODO action during wrong player request
			}
		}
		if(msg instanceof Ingame_RemoveFigures){
			// TODO implementation of remove figure
		}
		if(msg instanceof Ingame_GameSync){
		
		}
		if(msg instanceof Ingame_EndTurn){
			
		}
		if(msg instanceof Ingame_EndGame){
			
		}	
	}
}
