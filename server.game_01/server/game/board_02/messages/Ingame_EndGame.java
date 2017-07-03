package server.game.board_02.messages;

import server.game.board_02.PlayerStat;

/**
 * <p>
 * Ð¡ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ðµ, Ð¸Ð·Ð²ÐµÑ�Ñ‚Ñ�Ð²Ð°Ñ‰Ð¾ ÐºÑ€Ð°Ð¹ Ð½Ð° Ð¸Ð³Ñ€Ð°Ñ‚Ð° Ð¸ Ñ�Ñ‚Ð°Ñ‚Ð¸Ñ�Ñ‚Ð¸ÐºÐ¸ Ð½Ð° ÑƒÑ‡Ð°Ñ�Ñ‚Ð½Ð¸Ñ†Ð¸Ñ‚Ðµ - Ð½Ð°Ñ‡Ð°Ð»Ð½Ð¸
 * (Ð¿Ñ€ÐµÐ´Ð¸ Ð¸Ð³Ñ€Ð°Ñ‚Ð°) Ð¸ ÐºÑ€Ð°Ð¹Ð½Ð¸ (Ñ�Ð»ÐµÐ´ Ð¸Ð³Ñ€Ð°Ñ‚Ð°).
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_EndGame extends MessageIngame {

    public final PlayerStat[] playerStatsOld;
    public final PlayerStat[] playerStatsNew;

    public Ingame_EndGame(String username, int boardId, PlayerStat[] playerStatsOld, PlayerStat[] playerStatsNew) {
        super(username, Message.MESSAGETYPE.INGAME_ENDGAME, boardId);
        this.playerStatsOld = new PlayerStat[playerStatsOld.length];
        System.arraycopy(playerStatsOld, 0, this.playerStatsOld, 0, playerStatsOld.length);
        this.playerStatsNew = new PlayerStat[playerStatsNew.length];
        System.arraycopy(playerStatsNew, 0, this.playerStatsNew, 0, playerStatsNew.length);
    }
}
