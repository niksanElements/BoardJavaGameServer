package server.test.game_01.main_app;


import java.io.IOException;
import java.net.Socket;

import server.AbstrctClientExecutor;
import server.game.IGameEngine;
import server.game_01.impl.DefaultGameEngine;
import server.impl.DefaultListener;
import server.utils.Logger;

public class GameListener extends DefaultListener {
	
	private IGameEngine gameEngine;
	
	public GameListener(String gameRoom) {
		super();
		this.gameEngine = new DefaultGameEngine(gameRoom);
	}
	
	@Override
	public void run(){
		isRunning = true;
		while(isRunning){
			 Socket socket = null;
             try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				Logger.error(e.getMessage());
			}
            GameExecutor conn = null;
             
			if(socket != null){
				conn = new GameExecutor();
				conn.setSocket(socket);
				conn.setGameEngine(gameEngine);
			}
			if(conn != null){
				executor.execute(conn);
			}
			
			if(serverSocket.isClosed()){
				isRunning = false;
			}
		}
	}
}
