package server.game_01.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import server.game.AbstractGameRoom;
import server.game.IGameEngine;
import server.game.IPlayer;

public class DefaultGameEngine implements IGameEngine {
	
	private String gameRoom;
	
	private Queue<IPlayer> two_two;
	private Queue<IPlayer> three_three;
	private Queue<IPlayer> four_four;
	private Queue<IPlayer> six_six;
	
	private List<AbstractGameRoom> rooms;
	
	public DefaultGameEngine(String gameRoom){
		this.gameRoom = gameRoom;
		
		this.two_two = new LinkedList<>();
		this.three_three = new LinkedList<>();
		this.four_four = new LinkedList<>();
		this.six_six = new LinkedList<>();
		
		this.rooms = new ArrayList<>();
	}

	private void createGame(ArrayList<IPlayer> players, int mode) {
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
	public void setPlayer(IPlayer player, int mode) {
		switch (mode) {
		case 2:
			this.two_two.add(player);
			break;
		case 3:
			this.three_three.add(player);
			break;
		case 4:
			this.four_four.add(player);
			break;
		case 6:
			this.six_six.add(player);
		default:
			break;
		}
		
		checkForGame(mode);
	}

	private void checkForGame(int mode) {
		switch (mode) {
		case 2:
			createGame(new ArrayList<IPlayer>(two_two), mode);
			break;
		case 3:
			createGame(new ArrayList<IPlayer>(three_three), mode);
			break;
		case 4:
			createGame(new ArrayList<IPlayer>(four_four), mode);
			break;
		case 6:
			createGame(new ArrayList<IPlayer>(six_six), mode);
			break;
		default:
			break;
		}
	}

	@Override
	public void setGameRoom(String gameRoom) {
		this.gameRoom = gameRoom;
		
	}

}
