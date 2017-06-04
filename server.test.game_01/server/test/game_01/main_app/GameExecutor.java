package server.test.game_01.main_app;

import server.AbstrctClientExecutor;
import server.game.IGameEngine;
import server.game.board_02.messages.Message;
import server.test.game_01.handlers.BoardHandler;
import server.test.game_01.handlers.GameHandler;
import server.test.game_01.handlers.Login;

public class GameExecutor extends AbstrctClientExecutor {
	
	private IGameEngine gameEngine;

	@Override
	protected Message decode(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHandlers() {
		this.login = new Login();
		this.handlers.add(new GameHandler(gameEngine));
		this.handlers.add(new BoardHandler());
		
	}

	@Override
	public void setLogin() {
		// TODO Auto-generated method stub
		
	}
	
	public void setGameEngine(IGameEngine gameEngine){
		this.gameEngine = gameEngine;
	}

}
