package test.BoardGame.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import apps.NetClient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import protocol.ChatMessage;
import protocol.Message;

public class ChatController implements Initializable,PropertyChangeListener {
	
	public String username;
	public int idBoard;
	
	private NetClient client;
	
	@FXML
	private TextArea chatMessages;
	
	@FXML
	private TextArea message;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.chatMessages.setScrollTop(Double.MAX_VALUE);
		this.chatMessages.setDisable(true);
		this.message.setDisable(true);
	}
	
	@FXML
	protected void send(KeyEvent event){
		if(event.getCode() == KeyCode.ENTER){
			String msg = this.message.getText();
			this.message.clear();
			if(msg != null){
				this.client.sendMessage(new ChatMessage(this.username, this.idBoard, msg));
				this.chatMessages.appendText(this.username + ":\n");
				this.chatMessages.appendText(msg);
			}
		}
	}

	
	public void setUsername(String username){
		this.username = username;
	}


	public String getUsername() {
		return username;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO When the board is created
		
	}

	public void hendaleMessage(Message message2) {
		ChatMessage msg = (ChatMessage)message2;
		this.chatMessages.appendText(msg.username + ":\n");
		this.chatMessages.appendText(msg.msg);
		
	}

	public NetClient getClient() {
		return client;
	}

	public void setClient(NetClient client) {
		this.client = client;
	}
	
	
	

}
