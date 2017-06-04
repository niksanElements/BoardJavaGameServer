package server.game.board_02.messages;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ Ð·Ð° Ñ�Ð¸Ð½Ñ…Ñ€Ð¾Ð½Ð¸Ð·Ð¸Ñ€Ð°Ð½Ðµ Ð½Ð° Ð¸Ð³Ñ€Ð°, Ð² ÐºÐ¾Ñ�Ñ‚Ð¾ Ð¿Ð¾Ñ‚Ñ€ÐµÐ±Ð¸Ñ‚ÐµÐ»Ñ�Ñ‚ ÑƒÑ‡Ð°Ñ�Ñ‚Ð²Ð°.
 * <p>
 * ÐšÐ»Ð°Ñ�ÑŠÑ‚ Ñ‰Ðµ Ð²ÐºÐ»ÑŽÑ‡Ð²Ð° Ð´Ð°Ð½Ð½Ð¸ Ð·Ð° Ñ�Ð¸Ð½Ñ…Ñ€Ð¾Ð½Ð¸Ð·Ð¸Ñ€Ð°Ð½Ðµ Ð½Ð° Ð´ÑŠÑ�ÐºÐ°Ñ‚Ð° Ð¸ Ð´Ñ€.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_GameSync extends MessageIngame {

    public Ingame_GameSync(String username, int boardId) {
        super(username, Message.MESSAGETYPE.LOBBY_GAMESYNC, boardId);
    }
}
