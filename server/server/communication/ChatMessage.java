package server.communication;

@SuppressWarnings("serial")
public final class ChatMessage extends Message{
	
	private final MESSAGE_TYPES type = MESSAGE_TYPES.CHAT_MESSAGE;
	
	private String form;
	private String to;
	private String msg;
	
	// TODO change and insert the id logic
	public ChatMessage(String form, String to, String msg) {
		super(0);
		this.form = form;
		this.to = to;
		this.msg = msg;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public MESSAGE_TYPES getType() {
		return type;
	}
	
	
}
