package server.communication;

import server.utils.BoardJavaGameServerConfig;
import server.utils.BoardJavaGameServerConfig.MESSAGE_TYPES;

@SuppressWarnings("serial")
public class BoardAction extends Message { 
	
	public static final MESSAGE_TYPES TYPE = MESSAGE_TYPES.BOARD_ACTION;
	
	private int x,y;
	private int x1,y1;
	private int id;
	private BoardJavaGameServerConfig.BoardAction type;
	
	
	
	public BoardAction(int x, int y, int x1, int y1, 
			BoardJavaGameServerConfig.BoardAction type,int id)
	{
		super();
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.type = type;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public BoardJavaGameServerConfig.BoardAction getType() {
		return type;
	}
	public void setType(BoardJavaGameServerConfig.BoardAction type) {
		this.type = type;
	}
}
