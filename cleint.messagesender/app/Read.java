package app;
import java.io.IOException;
import java.io.ObjectInputStream;

import server.game.board_02.messages.Message;

public class Read implements Runnable {
	
	private ObjectInputStream in;
	private boolean isRunning;
	
	public Read(ObjectInputStream in){
		this.in = in;
		isRunning = false;
	}
	
	
	@Override
	public void run() {
		isRunning = true;
		while(isRunning){
			Object msg = null;
			try {
				msg = (Message)in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning = false;
			}
			System.out.println("----------------------------");
			if(msg != null){
				System.out.println(msg);
			}
		}
		
	}

}
