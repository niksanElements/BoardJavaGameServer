package protocol;

public class ChatMessage extends Message {
	
	public final int idBoard;
	public final String msg;

	public ChatMessage(String fromUser,int idBoard,String msg) {
		super(fromUser, Message.MESSAGETYPE.CHAT_MESSAGE);
		this.idBoard = idBoard;
		this.msg = msg;
	}

}
