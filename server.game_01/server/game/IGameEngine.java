package server.game;

public interface IGameEngine {
	
	enum Mode{
		TWO_TWO,THREE_THREE,FOUR_FOUR, SIX_SIX
	}
	
	
	/**
	 * Set Player which want to play
	 */
	public void setPlayer(IPlayer player,int boardShape);
	
	/**
	 * Function for setting game rooms!
	 * @param id: id on the GameRoom
	 * @param gameRoom: class path on the GameRoom
	 */
	public void setGameRoom(String gameRoom);
}
