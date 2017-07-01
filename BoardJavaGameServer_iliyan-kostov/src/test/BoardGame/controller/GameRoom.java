package test.BoardGame.controller;

import apps.NetClient;
import game.board.Board_Clientside;

public class GameRoom extends Board_Clientside {

	public GameRoom(int boardShape, int boardId, String[] usernames, NetClient client) {
		super(boardShape, boardId, usernames, client);
	}

}
