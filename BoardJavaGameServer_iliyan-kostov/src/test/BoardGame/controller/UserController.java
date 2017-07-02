package test.BoardGame.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.media.jfxmediaimpl.platform.Platform;
import com.sun.org.apache.bcel.internal.generic.InstructionTargeter;

import apps.NetClient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import protocol.Message_Lobby_NewGameRequest;

public class UserController implements Initializable {
	
	
	private NetClient client;	
	
	@FXML
	private Label userInfo;
	
	@FXML
	private ChoiceBox<Integer> gameSelect;
	
	@FXML
	private Button play;
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private Circle indicator;
	
	
	@FXML
	protected void onPlay(ActionEvent event){
		int mode = this.gameSelect.getValue();
		if(mode != 0){
			this.client.sendMessage(new Message_Lobby_NewGameRequest(null, mode, 0));
			
			play.setDisable(true);
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.gameSelect.getItems().add(2);
		this.gameSelect.getItems().add(3);
		this.gameSelect.getItems().add(4);
		this.gameSelect.getItems().add(6);
		
		this.gameSelect.setValue(2);
		this.isMyTurn(false);
	}
	
	@FXML
	protected void exit(ActionEvent event){
		this.client.stopConnection();
		
		javafx.application.Platform.exit();
	}
	
	public void setPlay(boolean flag){
		this.play.setDisable(!flag);
	}

	public NetClient getClient() {
		return client;
	}

	public void setClient(NetClient client) {
		this.client = client;
	}

	public String getUsername() {
		return this.userInfo.getText();
	}

	public void setUsername(String username) {
		this.userInfo.setText(username);
	}
	
	public void setImage(Image value){
		this.imageView.setImage(value);
	}

	public void isMyTurn(boolean flag) {
		if(flag){
			this.indicator.setFill(Color.GREEN);
		}
		else {
			this.indicator.setFill(Color.RED);
		}
		
	}

}
