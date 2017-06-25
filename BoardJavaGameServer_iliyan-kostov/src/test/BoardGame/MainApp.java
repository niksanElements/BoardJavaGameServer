package test.BoardGame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import test.BoardGame.controller.LoginController;

public class MainApp extends Application {	

	private Group root;
	private LoginController login;
	private Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		LoadView loginView = Loader.load("login.fxml");
		GridPane loginRoot = (GridPane)loginView.getRoot();

		this.root = new Group();
		
		this.root.getChildren().add(0,loginRoot);
		
		this.login = (LoginController)loginView.getController();
		this.login.setRoot(root); 
		this.scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("Board Game");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
