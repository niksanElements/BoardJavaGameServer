package apps;

import game.board.Board_Clientside;
import game.board.ImageLoader;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import protocol.Message;
import protocol.Message_Board_GameStarted;
import protocol.interfaces.IMessageHandler;
import protocol.interfaces.IMessageSender;
import test.BoardGame.controller.ChatController;
import test.BoardGame.controller.UserController;

public class NetClient implements IMessageSender, IMessageHandler, PropertyChangeListener {

    public static final String EVENT_GAME_STARTED = "gameStarted";

    public final PropertyChangeSupport pcs;

    protected final Socket socket;
    protected final String username;
    protected final String password;
    protected NetClientsideConnection connection;
    // visual:
    protected Board_Clientside board;
    protected ChatController chat;
    protected UserController userControl;
    
    public final VBox vBox;

    public Group getBoardView() {
        return this.board.getBoardView();
    }

    public NetClient(Socket socket, String username, String password) {
        this.pcs = new PropertyChangeSupport(this);
        this.vBox = new VBox();
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.getChildren().add(new Label("Game Board!!!"));
        this.socket = socket;
        this.username = username;
        this.password = password;
        this.connection = null;
        this.board = null;
        //this.board = new Board_Clientside(4, 1, new String[]{"s","b","c","d"}, this);
    }

    public synchronized void startConnection() {
        if (this.connection == null) {
            this.connection = new NetClientsideConnection(this, socket, username, password);
            this.connection.addPropertyChangeListener(this);
            this.connection.start();
        }
    }

    public synchronized void stopConnection() {
        if (this.connection != null) {
            this.connection.stopConnection();
            this.connection = null;
        }
    }

    public synchronized boolean isRunning() {
        if ((this.connection != null) && (this.connection.isAlive())) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.pcs.addPropertyChangeListener(propertyChangeListener);

    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.pcs.removePropertyChangeListener(propertyChangeListener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //this.pcs.firePropertyChange(evt);
    }

    @Override
    public synchronized void sendMessage(Message message) {
        this.connection.sendMessage(message);
    }

    @Override
    public synchronized void handleMessage(Message message) {
        switch (message.messageType) {
            case BOARD_GAMESTARTED: {
                try {
                    Message_Board_GameStarted msg = (Message_Board_GameStarted) message;
                    switch (msg.boardShape) {
	                    case 2:{
	                    	this.board = new Board_Clientside(msg.boardShape, msg.boardId, msg.playerNames, this);
	                    }
	                    break;
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
                    Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
		                    vBox.getChildren().clear();
		                    vBox.getChildren().add(getBoardView());
						}
					});
                    ImageLoader loader = new ImageLoader();
                    int index = 0;
                    for(String username: msg.playerNames){
                    	if(username.equals(this.username)){
                    		break;
                    	}
                    	index++;
                    }
                    this.userControl.setImage(loader.takeImage(index));
                    this.chat.setChatCommunication(true);
                    this.board.setChat(chat);
                    this.board.usercontrol = this.userControl;
                    this.chat.setBoardId(this.board.boardId);
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
                this.userControl.setPlay(true);
                this.chat.setChatCommunication(false);
                this.board.setChat(null);
                this.userControl.isMyTurn(false);
            }
            break;
            case BOARD_SURRENDER: {
                this.board.handleMessage(message);
            }
            break;
            case CHAT_MESSAGE:{
            	this.board.handleMessage(message);
            }
            break;
            case BOARD_GAMESYNC : {
                this.board.handleMessage(message);
            }
            default: {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }   
    }

	public ChatController getChat() {
		return chat;
	}

	public void setChat(ChatController chat) {
		this.chat = chat;
	}

	public UserController getUserControl() {
		return userControl;
	}

	public void setUserControl(UserController userControl) {
		this.userControl = userControl;
	}
	
	
    
}
