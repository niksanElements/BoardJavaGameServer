package test.BoardGame.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import apps.NetClient;
import apps.NetClientsideConnection;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

public class HomeController implements Initializable ,PropertyChangeListener {
	
	public HomeController(){
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		 switch (evt.getPropertyName()) {
		 
	     case NetClientsideConnection.EVENT_IS_CLIENT_RUNNING: {
	         boolean isRunning = (boolean) evt.getNewValue();
	         if (isRunning) {
	             this.setRunning();
	             // show alert in FX UI:
	             Platform.runLater(new Runnable() {
	                 @Override
	                 public void run() {
	                     // Update UI here:
	                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                     alert.setContentText("Connected to server!");
	                     alert.showAndWait();
	                 }
	             });
	         } else {
	             this.setRunning();
	             // show alert in FX UI:
	             Platform.runLater(new Runnable() {
	                 @Override
	                 public void run() {
	                     // Update UI here:
	                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                     alert.setContentText("Disconnected from server!");
	                     alert.showAndWait();
	                 }
	             });
	         }
	     }
	     break;
	     
	     case NetClient.EVENT_GAME_STARTED: {
	         Platform.runLater(new Runnable() {
	             @Override
	             public void run() {
	             }
	         });
	     }
	     break;
	     default: {
	     }
		 }
		
	}

	private void setRunning() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

}
