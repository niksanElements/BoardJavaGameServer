package server.game.board_02.messages;

import server.game.board_02.PlayerStat;

/**
 * <p>
 * ÐšÐ»Ð°Ñ� Ð·Ð° Ñ�ÑŠÐ¾Ð±Ñ‰ÐµÐ½Ð¸Ñ�, Ñ�ÑŠÐ´ÑŠÑ€Ð¶Ð°Ñ‰Ð¸ Ð¸Ð³Ñ€Ð°Ð»Ð½Ð¸ Ñ�Ñ‚Ð°Ñ‚Ð¸Ñ�Ñ‚Ð¸ÐºÐ¸ - Ð¸Ð¼Ðµ Ð½Ð° Ð¸Ð³Ñ€Ð°Ñ‡ Ð¸
 * Ñ�ÑŠÐ¾Ñ‚Ð²ÐµÑ‚Ñ�Ñ‚Ð²Ð°Ñ‰Ð¸Ñ‚Ðµ Ð¼Ñƒ Ñ�Ñ‚Ð°Ñ‚Ð¸Ñ�Ñ‚Ð¸ÐºÐ¸ Ð·Ð° Ñ€Ð°Ð·Ð»Ð¸Ñ‡Ð½Ð¸Ñ‚Ðµ Ñ€ÐµÐ¶Ð¸Ð¼Ð¸ Ð½Ð° Ð¸Ð³Ñ€Ð°.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Lobby_PlayerStats extends Message {

    public final String playerName;
    public PlayerStat[] playerStats;    // Ð¿Ð¾Ð¿ÑŠÐ»Ð²Ð° Ñ�Ðµ Ð¾Ñ‚ Ñ�ÑŠÑ€Ð²ÑŠÑ€Ð°

    public Lobby_PlayerStats(String username, String playerName) {
        super(username, Message.MESSAGETYPE.LOBBY_PLAYERSTATS);
        this.playerName = playerName;
        this.playerStats = null;
    }
}
