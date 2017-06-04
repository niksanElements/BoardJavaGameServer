package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AppTest {
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	private int port;
	
	public AppTest(int port){
		this.port = port;
		this.connectServer();
		
		
		Write w = new Write(out);
		Read r = new Read(in);
		
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}

	private void connectServer(){
		String serverAddres = "127.0.0.1";
		try {
			Socket socket = new Socket(serverAddres,port);
			this.out = new ObjectOutputStream(socket.getOutputStream());
			this.in = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Port: ");
		int port = sc.nextInt();
		new AppTest(port);
	}

}
