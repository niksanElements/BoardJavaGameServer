package server.game.board_02.messages;

/**
 * <p>
 * Ð—Ð°Ñ�Ð²ÐºÐ° Ð·Ð° Ð½Ð¾Ð²Ð° Ð¸Ð³Ñ€Ð° Ð¾Ñ‚ Ð¾Ð¿Ñ€ÐµÐ´ÐµÐ»ÐµÐ½ Ñ€ÐµÐ¶Ð¸Ð¼.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Lobby_NewGameRequest extends Message {

    public final int boardShape;

    public Lobby_NewGameRequest(String username, int boardShape) {
        super(username, Message.MESSAGETYPE.LOBBY_NEWGAMEREQUEST);
        this.boardShape = boardShape;
    }
}
