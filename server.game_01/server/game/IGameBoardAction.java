package server.game;

public interface IGameBoardAction {
	
	public boolean attack(int x,int y,int x1,int y1);
	
	public boolean move(int x,int y,int x1,int y1);
	
	public boolean shoot(int x,int y,int x1,int y1);
	
	public boolean curse(int x,int y, int x1,int y1);
}
