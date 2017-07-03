package server.game.board_02.messages;

import server.game.board_02.BoardCoords;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ, Ð²ÐºÐ»ÑŽÑ‡Ð²Ð°Ñ‰Ð¾ Ð´Ð°Ð½Ð½Ð¸ Ð·Ð° Ð¿Ñ€ÐµÐ¼Ð°Ñ…Ð²Ð°Ð½Ðµ Ð½Ð° Ñ„Ð¸Ð³ÑƒÑ€Ð¸ Ð¾Ñ‚ Ð´Ð°Ð´ÐµÐ½Ð° Ð´ÑŠÑ�ÐºÐ°.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_RemoveFigures extends MessageIngame {

    public final ArrayList<BoardCoords> from;

    public Ingame_RemoveFigures(String username, int boardId, ArrayList<BoardCoords> from) {
        super(username, Message.MESSAGETYPE.INGAME_MOVEFIGURES, boardId);
        this.from = new ArrayList<>();
        {
            Iterator<BoardCoords> it = from.iterator();
            while (it.hasNext()) {
                this.from.add(it.next());
            }
        }
    }
}
