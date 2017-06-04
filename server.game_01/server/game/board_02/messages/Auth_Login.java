package server.game.board_02.messages;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ Ð·Ð° Ð²Ñ…Ð¾Ð´ Ð² Ñ�Ð¸Ñ�Ñ‚ÐµÐ¼Ð°Ñ‚Ð° - ÐºÐ°Ñ‚Ð¾ Ñ�ÑŠÑ‰ÐµÑ�Ñ‚Ð²ÑƒÐ²Ð°Ñ‰ Ð¸Ð»Ð¸ ÐºÐ°Ñ‚Ð¾ Ð½Ð¾Ð² Ð¿Ð¾Ñ‚Ñ€ÐµÐ±Ð¸Ñ‚ÐµÐ».
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Auth_Login extends Message {

    public final String password;

    public Auth_Login(String username, String password) {
        super(username, Message.MESSAGETYPE.AUTH_LOGIN);
        this.password = password;
    }
}
