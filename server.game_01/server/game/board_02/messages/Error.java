package server.game.board_02.messages;

public class Error extends Message {

	public final MESSAGETYPE error;
	public final String msg;
	
	public Error(String username, MESSAGETYPE error,String msg,MESSAGETYPE messageType) {
		super(username, messageType);
		this.error = error;
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "Error: \n usernaem: " +username + "\n message:\n"+msg;
	}
}
