package server.game.board_02.messages;

public class Success extends Message {
	
	public final MESSAGETYPE success;
	public final String msg;

	public Success(String username,MESSAGETYPE success,String msg, MESSAGETYPE messageType) {
		super(username, messageType);
		this.success = success;
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "Success: \n username: "+username+" \nmessage:\n"+msg;
	}

}
