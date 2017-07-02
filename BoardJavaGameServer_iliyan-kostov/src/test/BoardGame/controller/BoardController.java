package test.BoardGame.controller;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import apps.NetClient;
import game.board.Board_Clientside;
import javafx.scene.Group;
import protocol.Message;
import protocol.Message_Board_GameStarted;

public class BoardController extends NetClient {
	

	public BoardController(Socket socket, String username, String password) {
		super(socket, username, password);
		String names[] = {"mama","kaka","baba","baba"};
		this.board = new Board_Clientside(2, 2,names, this);

	}
	
	public Group getBoradView(){
		return this.board.getBoardView();
	}
	
	@Override
	public synchronized void handleMessage(Message message){
		switch (message.messageType) {
		    case BOARD_GAMESTARTED: {
		        try {
		            Message_Board_GameStarted msg = (Message_Board_GameStarted) message;
		            switch (msg.boardShape) {
		                case 3: {
		                    this.board = new Board_Clientside(msg.boardShape, msg.boardId, msg.playerNames, this);
		                }
		                break;
		                case 4: {
		                    this.board = new Board_Clientside(msg.boardShape, msg.boardId, msg.playerNames, this);
		                }
		                break;
		                case 6: {
		                    this.board = new Board_Clientside(msg.boardShape, msg.boardId, msg.playerNames, this);
		                }
		                break;
		                default: {
		                    throw new IllegalArgumentException();
		                }
		            }
		            this.board.handleMessage(message);
		            this.pcs.firePropertyChange(NetClient.EVENT_GAME_STARTED, false, true);
		        } catch (ClassCastException ex) {
		            Logger.getLogger(NetClient.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    }
		    break;
		    case BOARD_MOVEFIGURES: {
		        this.board.handleMessage(message);
		    }
		    break;
		    case BOARD_ENDTURN: {
		        this.board.handleMessage(message);
		    }
		    break;
		    case BOARD_ENDGAME: {
		        this.board.handleMessage(message);
		    }
		    break;
		    case BOARD_SURRENDER: {
		        this.board.handleMessage(message);
		    }
		    break;
		    case CHAT_MESSAGE:{
		    }
		    default: {
		        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		    }
		}
	}

}
