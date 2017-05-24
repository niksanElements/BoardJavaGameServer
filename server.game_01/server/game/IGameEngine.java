package server.game;

public interface IGameEngine {
	
	enum Mode{
		ONE_ONE,TWO_TWO,THREE_THREE,FOUR_FOUR
	}
	
	
	/**
	 * Set Player which want to play
	 */
	public void setPlayer(IPlayer player,Mode mode);
	
	/**
	 * Function for setting game rooms!
	 * @param id: id on the GameRoom
	 * @param gameRoom: class path on the GameRoom
	 */
	public void setGameRoom(String gameRoom);
}
