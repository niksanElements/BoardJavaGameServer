package server.game.board_02.messages;

public class ChatMessage extends Message{

	public final String toUsername;
	public final String msg;
	
	public ChatMessage(String username, String toUsername, String msg,MESSAGETYPE messageType) {
		super(username, messageType);
		this.toUsername = toUsername;
		this.msg = msg;
		
	}
	
	@Override
	public String toString() {
		return "Chat Message: \nusername: "+username +" to: " + toUsername +"\nmessage:\n"+msg;
	}

}
