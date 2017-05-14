import server.impl.DefaultListener;
import server.impl.Server;

public class AppMain {
	public static void main(String[] args) {
		Server server = new Server(9000);
		DefaultListener listener = new DefaultListener();
		listener.setClientExecutorName("server.test.chat_01.ChatListener");
		server.setListener(listener);
		System.out.println("Starting th sever.....");
		server.start();
		//server.stop();
	}
}
