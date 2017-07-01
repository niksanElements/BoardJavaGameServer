package server.game_01.impl;

import java.util.ArrayList;

import server.game.AbstractGameRoom;
import server.game.IGameEngine.Mode;
import server.game.IPlayer;
import server.game.board_02.messages.Ingame_MoveFigures;
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
	public void createGameRoom(ArrayList<IPlayer> players, int mode) {
		// TODO setting the game in creating mode
		
	}

	@Override
	public boolean handle(Ingame_MoveFigures message) {
		boolean result = true;
		if(isTheMessageFromValidPlayer(message)){
			if(message.actions.size() == message.from.size()&& 
					message.from.size() == message.to.size())
			{
				for(int i = 0;i < message.to.size() && result == true;i++){
					switch (message.actions.get(i)) {
					case 1:
						result = board.attack(message.from.get(i).x, message.from.get(i).y, 
								message.to.get(i).x, message.to.get(i).y);
						break;
					case 3:
						result = board.move(message.from.get(i).x, message.from.get(i).y, 
								message.to.get(i).x, message.to.get(i).y);
						break;
					case 2:
						result = board.shoot(message.from.get(i).x, message.from.get(i).y, 
								message.to.get(i).x, message.to.get(i).y);
						break;
					case 4:
						result = board.curse(message.from.get(i).x, message.from.get(i).y, 
								message.to.get(i).x, message.to.get(i).y);
						break;
					default:
						result = false;
						break;
					}
				}
			}
			if(result){
				currentPlayer = (currentPlayer + 1)% players.length;
			}
		}
		return result;
	}


	@Override
	public void handle(Object obj) {
		// TODO Auto-generated method stub
	}
	
	// private
	private boolean isTheMessageFromValidPlayer(Ingame_MoveFigures message){
		boolean result = true;
		if(players[currentPlayer].isMyMove()){
			result = false;
		}
		if(result && players[currentPlayer].getName().equals(message.username)){
			result = false;
		}
			
		return true;
	}
	/**
	 * @param move is the message from certain player.
	 * @return int from 1 to 4 to determine the board action wich
	 * the player want's to perform.
	 * 
	 * 1 - attack
	 * 2 - shoot
	 * 3 - move
	 * 4 - curse
	 */
	
}
