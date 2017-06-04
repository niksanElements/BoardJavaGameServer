package server.test.chat_01.heandlers;

import java.io.IOException;

import server.IHandler;
import server.game.board_02.messages.ChatMessage;
import server.game.board_02.messages.Message;

public class MessageHandler implements IHandler {

	@Override
	public void handel(Message msg) {
		ChatMessage message = (ChatMessage)msg;
		server.impl.Connection.send(message.toUsername, msg);;
	}
}
