package server.communication;


@SuppressWarnings("serial")
public final class Login extends Message {
	
	private final MESSAGE_TYPES type = MESSAGE_TYPES.LOGIN;
	
	private String name;
	
	public Login(int playerId, String name) {
		super(playerId);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public MESSAGE_TYPES getType() {
		return type;
	}
	
}
