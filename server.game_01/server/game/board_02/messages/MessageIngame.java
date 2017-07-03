package server.game.board_02.messages;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ, Ð½Ð¾Ñ�ÐµÑ‰Ð¾ Ð´Ð°Ð½Ð½Ð¸ Ð·Ð° Ñ€Ð°Ð·Ð²Ð¸Ñ‚Ð¸Ðµ Ð½Ð° Ð¾Ð¿Ñ€ÐµÐ´ÐµÐ»ÐµÐ½Ð° Ð¸Ð³Ñ€Ð°.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class MessageIngame extends Message {

    public final int boardId;

    public MessageIngame(String username, MESSAGETYPE messageType, int boardId) {
        super(username, messageType);
        this.boardId = boardId;
    }
}
