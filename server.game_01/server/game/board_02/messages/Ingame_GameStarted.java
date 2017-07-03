package server.game.board_02.messages;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ Ð·Ð° Ð·Ð°Ð¿Ð¾Ñ‡Ð½Ð°Ð»Ð° Ð½Ð¾Ð²Ð° Ð¸Ð³Ñ€Ð°, Ð² ÐºÐ¾Ñ�Ñ‚Ð¾ Ð¿Ð¾Ñ‚Ñ€ÐµÐ±Ð¸Ñ‚ÐµÐ»Ñ�Ñ‚ ÑƒÑ‡Ð°Ñ�Ñ‚Ð²Ð°.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_GameStarted extends MessageIngame {

    public final int boardShape;
    public final String[] playerNames;

    public Ingame_GameStarted(String username, int boardId, int boardShape, String[] playerNames) {
        super(username, Message.MESSAGETYPE.LOBBY_GAMESTARTED, boardId);
        this.boardShape = boardShape;
        this.playerNames = new String[playerNames.length];
        System.arraycopy(playerNames, 0, this.playerNames, 0, playerNames.length);
    }
}
