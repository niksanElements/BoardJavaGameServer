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
import javafx.scene.Cursor;
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
		
		this.chatMessages.setWrapText(true);
		this.chatMessages.setWrapText(true);
		this.message.setWrapText(true);
		this.chatMessages.setStyle(
				"-fx-control-inner-background:#000000; "
				+ "-fx-font-family: Consolas; "
				+ "-fx-text-fill: #00ff00; "
				+ "-fx-opacity: 2.0;"
				+ "-fx-font-size: 14;"
		);
		this.chatMessages.setEffect(null);
		this.chatMessages.editableProperty().set(false);
		
		this.message.setStyle(
				"-fx-control-inner-background:#000000; "
				+ "-fx-font-family: Consolas; "
				+ "-fx-highlight-fill: #eeff00; "
				+ "-fx-highlight-text-fill: #000000; "
				+ "-fx-text-fill: #00ff00; "
				+ "-fx-opacity: 2.0;"
				+ "-fx-font-size: 14;"
		);
		this.message.setDisable(true);
	}
	
	@FXML
	protected void send(KeyEvent event){		
		if(event.getCode() == KeyCode.ENTER){
			String msg = this.message.getText();
			this.message.clear();
			this.message.positionCaret(0);
			if(msg != null){
				this.client.sendMessage(new ChatMessage(this.username, this.idBoard,this.username ,msg));
				this.chatMessages.appendText(this.username + ":  ");
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
		this.chatMessages.appendText(msg.from + ":  ");
		this.chatMessages.appendText(msg.msg);
		
	}

	public NetClient getClient() {
		return client;
	}

	public void setClient(NetClient client) {
		this.client = client;
	}

	public void setChatCommunication(boolean b) {
		this.message.setDisable(!b);
		
	}
	
	public void setBoardId(int id){
		this.idBoard = id;
	}

}
