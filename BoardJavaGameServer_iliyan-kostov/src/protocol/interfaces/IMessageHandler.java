package protocol.interfaces;

import protocol.Message;

/**
 * Описва възможността на клас да обработва съобщения от типа
 * {@link protocol.Message}.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public interface IMessageHandler {

    /**
     * Обработва постъпващо съобшение.
     *
     * @param message постъпващо съобщение
     */
    public void handleMessage(Message message);
}
