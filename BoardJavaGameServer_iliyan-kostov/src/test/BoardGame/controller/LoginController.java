package test.BoardGame.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import apps.AppClient;
import apps.NetClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginController
	implements Initializable {
	
	public Group root;
	
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 500;
	
	private NetClient client;
	
	public HomeController homeController;
	
	@FXML
	private TextField usernameTextField;
	
	@FXML
	private PasswordField passwordPasswordField;
	
	
	public LoginController()
	{}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("The user is going for login.");
	}
	
	@FXML
	protected void onLogin(ActionEvent e){
		this.startClient();
	}
	
	@FXML
	protected void onRegister(ActionEvent e){
		System.out.println("Register event!");
	}
	
	protected synchronized void startClient() {
	       // this.stopClient();
	        try {
	            String hostname = HOST;
	            int port = PORT;
	            
	            String username = this.usernameTextField.getText();
	            String password  = this.passwordPasswordField.getText();
	            
	            boolean isReady = false;
	            
            	if(this.AutoValid(username,password)){
		            try {
		                Socket socket = new Socket(hostname, port);
		                {
		                    this.client = new NetClient(socket, username, password);
		                    this.client.addPropertyChangeListener(homeController);
		                    this.client.startConnection();
		                    
		                    isReady = true;
		                }
		            } catch (IOException ex) {
		                Logger.getLogger(AppClient.class.getName()).log(Level.SEVERE, null, ex);
		            } catch (NumberFormatException ex) {
		            	Logger.getLogger(AppClient.class.getName()).log(Level.SEVERE, null, ex);
		            }
		            
		           if(isReady && this.root != null){
		        	   //this.root.getChildren().get(0).setVisible(false);
		        	   this.root.getChildren().remove(0);
		           }
		           else{
		        	   	Alert message = new Alert(Alert.AlertType.INFORMATION);
						message.setHeaderText("Login");
						message.setContentText("Wrong!");
						message.showAndWait();
		           }
		            
            	}
            	else{
            		Alert message = new Alert(Alert.AlertType.INFORMATION);
            		message.setHeaderText("Login");
            		message.setContentText("Booth username and password can't be empty!");
            		message.showAndWait();
            	}
	        }
	        finally{}
	    }

	private boolean AutoValid(String username, String password) {
		if(username.isEmpty() && password.isEmpty()){
			return false;
		}
		return true;
	}

	public Group getRoot() {
		return root;
	}

	public void setRoot(Group root) {
		this.root = root;
	}
	
	
}
