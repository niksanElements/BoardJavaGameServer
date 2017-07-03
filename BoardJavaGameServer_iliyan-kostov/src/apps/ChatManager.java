package apps;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

import game.board.Board_Serverside;
import protocol.ChatMessage;
import protocol.Message;
import protocol.Message_Board_Surrender;
import protocol.interfaces.IMessageHandler;
import protocol.interfaces.IMessageSender;

public class ChatManager implements PropertyChangeListener, IMessageSender, IMessageHandler {

	private NetServer server;
	private Set<String> users;
	
	
	public ChatManager(NetServer server) {
		this.server = server;
		this.users = new HashSet<>();
	}
	
	@Override
	public void handleMessage(Message message) {
		ChatMessage msg = (ChatMessage)message;
		//this.sendMessage(new ChatMessage(1, msg.username, msg.msg));
		
	}

	@Override
	public void sendMessage(Message message) {
		this.server.sendMessage(message);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		 switch (evt.getPropertyName()) {
         case NetServer.EVENT_USER_LOGOUT: {
        	 String user = (String) evt.getNewValue();
        	 this.users.remove(user);
         }
         break;
         default: {
         }
         break;
     }
		
	}
	
	public void addUser(String user){
		this.users.add(user);
	}

}
