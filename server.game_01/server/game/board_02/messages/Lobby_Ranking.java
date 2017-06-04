package server.game.board_02.messages;

import server.game.board_02.PlayerStat;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ Ñ� Ð´Ð°Ð½Ð½Ð¸ Ð·Ð° ÐºÐ»Ð°Ñ�Ð°Ñ†Ð¸Ñ� Ð·Ð° Ð¾Ð¿Ñ€ÐµÐ´ÐµÐ»ÐµÐ½ Ñ€ÐµÐ¶Ð¸Ð¼ Ð½Ð° Ð¸Ð³Ñ€Ð° Ð¸ Ð³Ð¾Ñ€Ð½Ð°/Ð´Ð¾Ð»Ð½Ð°
 * Ð³Ñ€Ð°Ð½Ð¸Ñ†Ð°.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Lobby_Ranking extends Message {

    public final int boardShape;
    public final int minRanking;
    public final int maxRanking;
    public PlayerStat[] playerStats;    // Ð¿Ð¾Ð¿ÑŠÐ»Ð²Ð° Ñ�Ðµ Ð¾Ñ‚ Ñ�ÑŠÑ€Ð²ÑŠÑ€Ð°

    public Lobby_Ranking(String username, int boardShape, int minRanking, int maxRanking) {
        super(username, Message.MESSAGETYPE.LOBBY_RANKING);
        this.boardShape = boardShape;
        this.minRanking = minRanking;
        this.maxRanking = maxRanking;
        this.playerStats = null;
    }
}
