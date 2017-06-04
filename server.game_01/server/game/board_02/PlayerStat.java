package server.game.board_02;

/**
 * <p>
 * Ð˜Ð³Ñ€Ð°Ð»Ð½Ð¸ Ñ�Ñ‚Ð°Ñ‚Ð¸Ñ�Ñ‚Ð¸ÐºÐ¸ Ð·Ð° Ð¿Ð¾Ñ‚Ñ€ÐµÐ±Ð¸Ñ‚ÐµÐ» Ð·Ð° Ð¾Ð¿Ñ€ÐµÐ´ÐµÐ»ÐµÐ½ Ñ€ÐµÐ¶Ð¸Ð¼ Ð½Ð° Ð¸Ð³Ñ€Ð°:
 * <ul>
 * <li>Ð¸Ð¼Ðµ Ð½Ð° Ð¸Ð³Ñ€Ð°Ñ‡
 * <li>Ñ‚Ð¸Ð¿ Ð´ÑŠÑ�ÐºÐ° (Ð±Ñ€Ð¾Ð¹ Ñ�Ñ‚Ñ€Ð°Ð½Ð¸ Ð½Ð° Ð´ÑŠÑ�ÐºÐ°Ñ‚Ð°)
 * <li>Ð±Ñ€Ð¾Ð¹ Ð¿Ð¾Ð±ÐµÐ´Ð¸
 * <li>Ð±Ñ€Ð¾Ð¹ Ð·Ð°Ð³ÑƒÐ±Ð¸
 * <li>Ñ€ÐµÐ¹Ñ‚Ð¸Ð½Ð³
 * <li>ÐºÐ»Ð°Ñ�Ð¸Ñ€Ð°Ð½Ðµ
 * </ul>
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public class PlayerStat {

    public final String playerName;
    public final int boardShape;
    public final int gamesWon;
    public final int gamesLost;
    public final int rating;
    public final int position;

    public PlayerStat(String playerName, int boardshape, int gamesWon, int gamesLost, int rating, int position) {
        this.playerName = playerName;
        this.boardShape = boardshape;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.rating = rating;
        this.position = position;
    }
}
