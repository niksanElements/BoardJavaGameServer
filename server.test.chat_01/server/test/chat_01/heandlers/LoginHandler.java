package server.test.chat_01.heandlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;

import server.ILoginHandler;
import server.game.board_02.messages.Auth_Login;
import server.game.board_02.messages.Message;

public class LoginHandler implements ILoginHandler {

	@Override
	public void handel(Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handel(ObjectInputStream in, ObjectOutputStream out) {
		Auth_Login log = null;
		try {
			log = (Auth_Login)in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server.impl.Connection.add(log.username, out);
	}
}
