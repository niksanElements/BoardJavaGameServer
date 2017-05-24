package server.game_01.impl;

import java.util.ArrayList;
import java.util.List;

import server.game.AbstractGameRoom;
import server.game.IGameEngine;
import server.game.IPlayer;

public class DefaultGameEngine implements IGameEngine {
	
	private String gameRoom;
	
	private List<IPlayer> one_one;
	private List<IPlayer> two_two;
	private List<IPlayer> three_three;
	private List<IPlayer> four_four;
	
	private List<AbstractGameRoom> rooms;
	
	public DefaultGameEngine(String gameRoom){
		this.gameRoom = gameRoom;
		
		this.one_one = new ArrayList<>();
		this.two_two = new ArrayList<>();
		this.three_three = new ArrayList<>();
		this.four_four = new ArrayList<>();
		
		this.rooms = new ArrayList<>();
	}

	private void createGame(IPlayer[] players, Mode mode) {
		try {
			AbstractGameRoom game = (AbstractGameRoom)Class.forName(gameRoom).newInstance();
			for(IPlayer player:players){
				player.addGameRoom(game);
			}
			game.createGameRoom(players, mode);
			game.setMode(mode);
			game.setId(rooms.size());
			rooms.add(game);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void setPlayer(IPlayer player, Mode mode) {
		switch (mode) {
		case ONE_ONE:
			this.one_one.add(player);
			break;
		case TWO_TWO:
			this.two_two.add(player);
			break;
		case THREE_THREE:
			this.three_three.add(player);
			break;
		case FOUR_FOUR:
			this.four_four.add(player);
			break;
		default:
			break;
		}
		
		checkForGame(mode);
	}

	private void checkForGame(Mode mode) {
		// TODO game match making
		
	}

	@Override
	public void setGameRoom(String gameRoom) {
		this.gameRoom = gameRoom;
		
	}

}
