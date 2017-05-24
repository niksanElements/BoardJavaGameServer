package server.game_01.impl;

import server.communication.BoardAction;
import server.game.AbstractGameRoom;
import server.game.IGameEngine;
import server.game.IGameEngine.Mode;
import server.game.IPlayer;
import server.game_01.impl.Board.Shape;

public class DefaultBoardGameRoom extends AbstractGameRoom {
	
	public final static int DEFAULT_SEGMENTS = 20;
	public final static Board.Shape DEFAULT_SAPE = Shape.HEX;

	private Board board;
	private int currentPlayer;

	public DefaultBoardGameRoom() {
		super();
		currentPlayer = 0;
		this.board = new Board(DEFAULT_SAPE, DEFAULT_SEGMENTS);
	}

	@Override
	public void onDisconnect(Object obj) {
		// TODO Disconnect event
		
	}

	@Override
	public void close() {
		// TODO close the game room
		
	}

	@Override
	public boolean handle(BoardAction message) {
		boolean result = false;
		if(isTheMessageFromValidPlayer(message)){
			switch (message.getType()) {
			case ATTACK:
				result = board.attack(message.getX(), message.getY(), 
						message.getX1(), message.getY1());
				break;
			case MOVE:
				result = board.move(message.getX(), message.getY(), 
						message.getX1(), message.getY1());
				break;
			case SHOOT:
				result = board.shoot(message.getX(), message.getY(), 
						message.getX1(), message.getY1());
				break;
			case CURSE:
				result = board.curse(message.getX(), message.getY(), 
						message.getX1(), message.getY1());
				break;
			default:
				result = false;
				break;
			}
			if(result){
				currentPlayer = (currentPlayer + 1)% players.length;
			}
		}
		return result;
	}

	@Override
	public void createGameRoom(IPlayer players[],IGameEngine mode) {
		status = Status.CREATING;
		// TODO Implement connection with the database for getting the figures attributes.
		
	}

	@Override
	public void handle(Object obj) {
		// TODO Auto-generated method stub
	}
	
	// private
	private boolean isTheMessageFromValidPlayer(BoardAction msg){
		boolean result = true;
		if(players[currentPlayer].isMyMove()){
			result = false;
		}
		if(result && players[currentPlayer].getId() != msg.getId()){
			result = false;
		}
			
		return true;
	}
	
}
