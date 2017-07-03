package app;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import server.game.board_02.BoardCoords;
import server.game.board_02.messages.Auth_Login;
import server.game.board_02.messages.Ingame_MoveFigures;
import server.game.board_02.messages.Ingame_RemoveFigures;
import server.game.board_02.messages.Lobby_NewGameRequest;
import server.game.board_02.messages.Lobby_PlayerStats;
import server.game.board_02.messages.Message;

public class Write implements Runnable {

	private ObjectOutputStream out;
	private boolean isRunning;
	private Scanner sc;
	
	
	
	public Write(ObjectOutputStream out) {
		super();
		this.out = out;
		this.sc = new Scanner(System.in);
		isRunning = false;
	}

	@Override
	public void run() {
		isRunning = true;
		while(isRunning){
			Message msg = this.getMessage();
			try {
				if(null != msg)
					out.writeObject(msg);
				else
					System.out.println("Incorect message!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Message getMessage() {
		
		String cmd = sc.next();
		Message msg = null;
		switch(cmd){
		case "Auth_Login":
			msg = authLogin();
			break;
		case "ChatMessage":
			msg = chatMessage();
			break;
		case "Ingame_EndGame":
			msg = endGame();
			break;
		case "Ingame_EndTurn":
			msg = endTurn();
			break;
		case "Ingame_GameSync":
			msg = gameSync();
			break;
		case "Ingame_MoveFigures":
			msg = moveFigures();
			break;
		case "Ingame_RemoveFigures":
			msg = removeFigure();
			break;
		case "Lobby_NewGameRequest":
			msg = newGameRequest();
			break;
		case "Lobby_PlayerStats":
			msg = playerStats();
			break;
		case "end":
			end();
			break;
		default:
			msg = null;
			break;
		}
		
		return msg;
	}

	private void end() {
		isRunning = false;
		System.exit(0);
		
	}

	private Message playerStats() {
		String username = sc.next();
		String playerName = sc.next();
		return new Lobby_PlayerStats(username, playerName);
	}

	private Message newGameRequest() {
		String username = sc.next();
		int boardShape = sc.nextInt();
		return new Lobby_NewGameRequest(username, boardShape);
	}

	private Message removeFigure() {
		String username = sc.next();
		
		int id = sc.nextInt();
		
		int size = sc.nextInt();
		
		ArrayList<BoardCoords> from = new ArrayList<>();
		
		for(int i = 0;i < size;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			from.add(new BoardCoords(x, y));
		}
		
		
		return new Ingame_RemoveFigures(username, id, from);
	}

	private Message moveFigures() {
		
		String username = sc.next();
		int boardId = sc.nextInt();
		int size = sc.nextInt();
		
		ArrayList<BoardCoords> from = new ArrayList<>();
		for(int i = 0;i < size;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			from.add(new BoardCoords(x, y));
		}
		
		ArrayList<BoardCoords> to = new ArrayList<>();
		for(int i = 0;i < size;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			to.add(new BoardCoords(x, y));
		}
		
		ArrayList<Integer> actions = new ArrayList<>();
		
		for(int i =0;i < size;i++){
			actions.add(sc.nextInt());
		}
		
		return new Ingame_MoveFigures(username, boardId, from, to, actions);
	}

	private Message gameSync() {
		// TODO Synchronization
		return null;
	}

	private Message endTurn() {
		// TODO end turn
		return null;
	}

	private Message endGame() {
		// TODO end game
		return null;
	}

	private Message chatMessage() {
		// TODO chat message
		return null;
	}

	private Message authLogin() {
		
		String username = sc.next();
		String password = sc.next();
		
		return new Auth_Login(username, password);
	}

}
