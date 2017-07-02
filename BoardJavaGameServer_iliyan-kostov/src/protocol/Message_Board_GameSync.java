package protocol;

/**
 * <p>
 * Съобщение за синхронизиране на игра, в която потребителят участва.
 * <p>
 * Класът ще включва данни за синхронизиране на дъската и др.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Message_Board_GameSync extends Message_Board {
    
    public final int currentPlayerTime; // time remaining for the current player's turn:

    public Message_Board_GameSync(String username, int boardId, int currentPlayerTime) {
        super(username, Message.MESSAGETYPE.BOARD_GAMESYNC, boardId);
        this.currentPlayerTime = currentPlayerTime;
    }
}