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
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoginController
	implements Initializable {
	
	public Group root;
	
	public HomeController home;
	
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 9000;
	
	private NetClient client;
	private Stage stage;
	
	
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
		                    this.client.addPropertyChangeListener(this.home);
		                    this.client.startConnection();
		                    this.home.getChatController().setClient(client);
		                    this.client.setChat(this.home.getChatController());
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
		        	   BorderPane borderPane = (BorderPane)this.root.getChildren().get(0);
		        	   VBox box = this.client.vBox;
		        	   BorderPane.setAlignment(box, Pos.CENTER);
		        	   Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		        	   box.setPrefSize((3*visualBounds.getWidth())/4, (3*visualBounds.getHeight())/4);
		        	   box.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		        	   borderPane.setCenter(box);
		        	   BorderPane homeController = (BorderPane)this.root.getChildren().get(0);
		        	   homeController.setVisible(true);
		        	   this.stage.setFullScreen(true);
		        	   this.home.getChatController().setUsername(username);
		        	   this.home.getUser().setUsername(username);
		        	   this.home.getUser().setClient(this.client);
		        	   this.client.setUserControl(this.home.getUser());
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

	public HomeController getHome() {
		return home;
	}

	public void setHome(HomeController home) {
		this.home = home;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
