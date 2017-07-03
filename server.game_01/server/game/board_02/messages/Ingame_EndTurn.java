package server.game.board_02.messages;;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ, Ð¸Ð·Ð²ÐµÑ�Ñ‚Ñ�Ð²Ð°Ñ‰Ð¾ ÐºÑ€Ð°Ð¹ Ð½Ð° Ñ…Ð¾Ð´Ð° Ð½Ð° Ñ‚ÐµÐºÑƒÑ‰Ð¸Ñ� Ð¸Ð³Ñ€Ð°Ñ‡ Ð¸ Ð¸Ð¼Ðµ Ð½Ð° Ñ�Ð»ÐµÐ´Ð²Ð°Ñ‰Ð¸Ñ�
 * Ð¸Ð³Ñ€Ð°Ñ‡, ÐºÐ¾Ð¹Ñ‚Ð¾ Ðµ Ð½Ð° Ñ…Ð¾Ð´.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_EndTurn extends MessageIngame {

    public final String playerTurnEnds;
    public final String playerTurnStarts;

    public Ingame_EndTurn(String username, int boardId, String playerTurnEnds, String playerTurnStarts) {
        super(username, Message.MESSAGETYPE.INGAME_ENDTURN, boardId);
        this.playerTurnEnds = playerTurnEnds;
        this.playerTurnStarts = playerTurnStarts;
    }
}
