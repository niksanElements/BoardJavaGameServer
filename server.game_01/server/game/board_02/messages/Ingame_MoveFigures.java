package server.game.board_02.messages;

import server.game.board_02.BoardCoords;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ, Ð²ÐºÐ»ÑŽÑ‡Ð²Ð°Ñ‰Ð¾ Ð´Ð°Ð½Ð½Ð¸ Ð·Ð° Ð¼ÐµÑ�Ñ‚ÐµÐ½Ðµ Ð½Ð° Ñ„Ð¸Ð³ÑƒÑ€Ð¸ Ð² Ð´Ð°Ð´ÐµÐ½Ð° Ð´ÑŠÑ�ÐºÐ°.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_MoveFigures extends MessageIngame {

    public final ArrayList<BoardCoords> from;
    public final ArrayList<BoardCoords> to;
    
    /**
	 * The actions are:
	 * 1 - attack
	 * 2 - shoot
	 * 3 - move
	 * 4 - curse
	 */
    public final ArrayList<Integer> actions;

    public Ingame_MoveFigures(String username, int boardId, ArrayList<BoardCoords> from, ArrayList<BoardCoords> to,
    		ArrayList<Integer> actions) {
        super(username, Message.MESSAGETYPE.INGAME_MOVEFIGURES, boardId);
        this.from = new ArrayList<>();
        {
            Iterator<BoardCoords> it = from.iterator();
            while (it.hasNext()) {
                this.from.add(it.next());
            }
        }
        this.to = new ArrayList<>();
        {
            Iterator<BoardCoords> it = to.iterator();
            while (it.hasNext()) {
                this.to.add(it.next());
            }
        }
        this.actions = new ArrayList<>();
        {
            Iterator<Integer> it = actions.iterator();
            while (it.hasNext()) {
                this.actions.add(it.next());
            }
        }
    }
    
    @Override
    public String toString() {
    	return "Move Figure: \n" + username;
    }
}
