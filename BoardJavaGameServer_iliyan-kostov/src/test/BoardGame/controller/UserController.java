package test.BoardGame.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.org.apache.bcel.internal.generic.InstructionTargeter;

import apps.NetClient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import protocol.Message_Lobby_NewGameRequest;

public class UserController implements Initializable {
	
	
	private NetClient client;
	
	@FXML
	private ChoiceBox<Integer> gameSelect;
	
	
	@FXML
	protected void onPlay(ActionEvent event){
		int mode = this.gameSelect.getValue();
		this.client.sendMessage(new Message_Lobby_NewGameRequest(null, mode, 0));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.gameSelect.getItems().add(2);
		this.gameSelect.getItems().add(3);
		this.gameSelect.getItems().add(4);
		this.gameSelect.getItems().add(6);
		
	}

	public NetClient getClient() {
		return client;
	}

	public void setClient(NetClient client) {
		this.client = client;
	}
	
	

}
