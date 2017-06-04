package server.test.game_01.handlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.ILoginHandler;
import server.game.board_02.messages.Auth_Login;
import server.game.board_02.messages.Error;
import server.game.board_02.messages.Message;
import server.game.board_02.messages.Success;
import server.game.board_02.messages.Message.MESSAGETYPE;
import server.impl.Connection;
import server.utils.Logger;

public class Login implements ILoginHandler {

	@Override
	public void handel(ObjectInputStream in, ObjectOutputStream out) {
		Auth_Login login = null;
		try {
			login = (Auth_Login) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			Logger.error(e.getStackTrace().toString());
		}
		
		if(login != null){
			Connection.add(login.username, out);
			Success msg = new Success(login.username, MESSAGETYPE.AUTH_LOGIN, "", MESSAGETYPE.SUCCESS);
			
			Connection.send(login.username, msg);
		}
		else{
			server.game.board_02.messages.Error msg = 
					new Error("", MESSAGETYPE.AUTH_LOGIN, "Fatal error!", MESSAGETYPE.ERROR);
			Connection.send(msg.username, msg);
		}
		
		
	}

	@Override
	public void handel(Message msg) {
		// TODO Auto-generated method stub
		
	}

}
