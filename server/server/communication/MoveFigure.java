package server.communication;


@SuppressWarnings("serial")
public final class MoveFigure extends Message {
	
	private int x,y;
	private int x1,y1;
	
	/**
	 * The actions are:
	 * 1 - attack
	 * 2 - shoot
	 * 3 - move
	 * 4 - curse
	 */
	private int action;
	
	public MoveFigure(int playerId,int x, int y, int x1, int y1,int action)
	{
		super(playerId);
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.action = action;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}
	
	@Override
	public MESSAGE_TYPES getType() {
		return MESSAGE_TYPES.MOVE_FIGURE;
	}
}
