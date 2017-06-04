package server.communication;


import java.io.Serializable;

import server.utils.BoardJavaGameServerConfig;

@SuppressWarnings("serial")
public abstract class Message implements Serializable {
	
	private int playerId;
	
	 /* Message types */
	public static enum MESSAGE_TYPES { 
		MESSAGE,
		LOGIN, 
		GAME_REQUEST, GAME_STARTED, USER_STATISTICS, RANKING,
		GAME_END, MOVE_FIGURE, END_TURN,
		/* Chat mode */
		CHAT_MESSAGE
	}
	
	public Message(int playerId){
		this.playerId = playerId;
	}
	
	public abstract Message.MESSAGE_TYPES getType();

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
}
