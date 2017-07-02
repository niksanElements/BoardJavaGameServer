package protocol;

public class ChatMessage extends Message {
	
	public final int idBoard;
	public final String msg;
	public final String from;

	public ChatMessage(String fromUser,int idBoard,String from,String msg) {
		super(fromUser, Message.MESSAGETYPE.CHAT_MESSAGE);
		this.idBoard = idBoard;
		this.msg = msg;
		this.from =from;
	}

}
