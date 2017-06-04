package server.game.board_02;

import server.game.board_02.messages.MessageIngame;

/**
 * <p>
 * Ð‘Ð°Ð·Ð¾Ð² Ð°Ð±Ñ�Ñ‚Ñ€Ð°ÐºÑ‚ÐµÐ½ ÐºÐ»Ð°Ñ� Ð·Ð° Ð´ÑŠÑ�ÐºÐ°Ñ‚Ð°.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Board {

    /**
     * <p>
     * Ð‘Ñ€Ð¾Ð¹ Ñ�Ñ‚Ñ€Ð°Ð½Ð¸ Ð½Ð° Ð´ÑŠÑ�ÐºÐ°Ñ‚Ð°.
     */
    public final int boardShape;

    /**
     * <p>
     * Ð˜Ð´ÐµÐ½Ñ‚Ð¸Ñ„Ð¸ÐºÐ°Ñ‚Ð¾Ñ€ Ð½Ð° Ð´ÑŠÑ�ÐºÐ°Ñ‚Ð° (Ð¸Ð³Ñ€Ð°Ñ‚Ð°) Ð² Ñ€Ð°Ð¼ÐºÐ¸Ñ‚Ðµ Ð½Ð° Ñ�Ð¸Ñ�Ñ‚ÐµÐ¼Ð°Ñ‚Ð°.
     */
    public final int boardId;

    public Board(int boardShape, int boardId) {
        if ((boardShape != 3) && (boardShape != 4) && (boardShape != 6)) {
            throw new IllegalArgumentException();
        } else {
            this.boardShape = boardShape;
            this.boardId = boardId;
        }
    }

    /**
     * <p>
     * ÐžÐ¿Ð¸Ñ�Ð²Ð° ÐºÐ°Ðº Ð´ÑŠÑ�ÐºÐ°Ñ‚Ð° Ñ€ÐµÐ°Ð³Ð¸Ñ€Ð° Ð½Ð° Ð¿Ð¾Ð»ÑƒÑ‡ÐµÐ½Ð¾ Ñ�ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ, Ð½Ð¾Ñ�ÐµÑ‰Ð¾ Ð´Ð°Ð½Ð½Ð¸ Ð·Ð°
     * Ñ€Ð°Ð·Ð²Ð¸Ñ‚Ð¸Ðµ Ð½Ð° Ð¾Ð¿Ñ€ÐµÐ´ÐµÐ»ÐµÐ½Ð° Ð¸Ð³Ñ€Ð°.
     *
     * @param messageIngame Ð¿Ð¾Ð»ÑƒÑ‡ÐµÐ½Ð¾ Ñ�ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ, Ð½Ð¾Ñ�ÐµÑ‰Ð¾ Ð´Ð°Ð½Ð½Ð¸ Ð·Ð° Ñ€Ð°Ð·Ð²Ð¸Ñ‚Ð¸Ðµ Ð½Ð°
     * Ð¾Ð¿Ñ€ÐµÐ´ÐµÐ»ÐµÐ½Ð° Ð¸Ð³Ñ€Ð°
     */
    public abstract void messageHandle(MessageIngame messageIngame);

    /**
     * <p>
     * ÐžÐ¿Ð¸Ñ�Ð²Ð° ÐºÐ°Ðº Ð´ÑŠÑ�ÐºÐ°Ñ‚Ð° Ð¸Ð·Ð¿Ñ€Ð°Ñ‰Ð° Ñ�ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ ÐºÑŠÐ¼ Ð´Ñ€ÑƒÐ³Ð°Ñ‚Ð° Ñ�Ñ‚Ñ€Ð°Ð½Ð° (Ñ�ÑŠÑ€Ð²ÑŠÑ€Ð° Ð¸Ð»Ð¸
     * ÐºÐ»Ð¸ÐµÐ½Ñ‚Ð°), Ð½Ð¾Ñ�ÐµÑ‰Ð¾ Ð´Ð°Ð½Ð½Ð¸ Ð·Ð° Ñ€Ð°Ð·Ð²Ð¸Ñ‚Ð¸ÐµÑ‚Ð¾ Ð½Ð° Ð¸Ð³Ñ€Ð°Ñ‚Ð°.
     *
     * @param messageIngame Ñ�ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ ÐºÑŠÐ¼ Ð´Ñ€ÑƒÐ³Ð°Ñ‚Ð° Ñ�Ñ‚Ñ€Ð°Ð½Ð° (Ñ�ÑŠÑ€Ð²ÑŠÑ€Ð° Ð¸Ð»Ð¸ ÐºÐ»Ð¸ÐµÐ½Ñ‚Ð°),
     * Ð½Ð¾Ñ�ÐµÑ‰Ð¾ Ð´Ð°Ð½Ð½Ð¸ Ð·Ð° Ñ€Ð°Ð·Ð²Ð¸Ñ‚Ð¸ÐµÑ‚Ð¾ Ð½Ð° Ð¸Ð³Ñ€Ð°Ñ‚Ð°
     */
    public abstract void messageSend(MessageIngame messageIngame);
}
