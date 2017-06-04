package server.test.game_01.main_app;

import server.impl.Server;

public class GameServer {
	
	public static final String PATH_EXECUTOR = "server.test.game_01.main_app.GameListener";
	public static final String PATH_GAMEROOM = "server.game_01.impl.DefaultBoardGameRoom";
	
	public static void main(String[] args) {
		Server server = new Server(9003);
		
		GameListener gameListener = new GameListener(PATH_GAMEROOM);
		server.setListener(gameListener);
		server.start();
		
	}
}
