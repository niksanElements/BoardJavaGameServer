package server.game;

import server.game.board_02.messages.Message;

public interface IPlayer {
	

	/**
	 * Method used to get the name of the gamer.
	 * 
	 * @return Returns the name or null if none is associated.
	 */
	public String getName();

	/**
	 * Method used to set the name of the gamer.
	 * 
	 * @param name
	 *            Set the string name, strings more than 100 characters long may
	 *            be rejected.
	 */
	public void setName(String name);

	/**
	 * Method used to get the email id of the gamer.
	 * 
	 * @return Returns the email id string, null if none is set.
	 */
	public int getEmailId();

	/**
	 * Method used to set the email id of the gamer.
	 * 
	 * @param emailId
	 *            Sets the email id string. strings more than 50 characters long
	 *            may be rejected.
	 */
	public void setEmailId(int emailId);

	/**
	 * Add a session to a player. This session signifies the players
	 * session to a game.
	 * 
	 * @param session
	 *            The session to add.
	 * @return true if add was successful, false if not.
	 */
	public void addGameRoom(AbstractGameRoom gameRoom);

	/**
	 * Remove the players session to a game.
	 * 
	 * @param session
	 *            The session to remove.
	 * @return true if remove is successful, false other wise.
	 */
	public void removeGameRoom();

	/**
	 *	Get the figures, which represent the monsters 
	 *	from the player.
	 * @return
	 */
	public int[] getFiguresIds();
	
	/**
	 * @return the player current status
	 */
	public boolean isMyMove();
	
	/**
	 * @param flag: sets the current move
	 */
	public void setMyMove(boolean flag);
	
	/**
	 * When a player logs out, this method can be called. It can also be called
	 * by the remove session method when it finds that there are no more
	 * sessions for this player.
	 * 
	 * @param playerSession
	 *            The session which is to be logged out.
	 */
	public void logout();
	
	/**
	 * add message to the player
	 * @param msg
	 * @return
	 */
	public boolean setMessage(Message msg);
	
	/**
	 * Sending message to the client 
	 * representing this player.
	 * @param msg
	 */
	public void sendMessage(Message msg);
	
}
