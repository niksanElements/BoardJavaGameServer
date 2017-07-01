package test.BoardGame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import test.BoardGame.controller.BoardController;
import test.BoardGame.controller.ChatController;
import test.BoardGame.controller.HomeController;
import test.BoardGame.controller.LoginController;
import test.BoardGame.controller.UserController;

public class MainApp extends Application {	

	private Group root;
	private LoginController login;
	private HomeController home;
	private UserController user;
	private ChatController chat;
	private Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		LoadView loginView = Loader.load("login.fxml");
		GridPane loginRoot = (GridPane)loginView.getRoot();
		this.login = (LoginController)loginView.getController();
		
		LoadView boardVew = Loader.load("board.fxml");
		BorderPane boardRoot = (BorderPane)boardVew.getRoot();
		this.home = (HomeController)boardVew.getController();
		
		LoadView chatView = Loader.load("chat.fxml");
		GridPane chatRoot = (GridPane)chatView.getRoot();
		this.chat = (ChatController)chatView.getController();
		
		LoadView userView = Loader.load("user.fxml");
		FlowPane userRoot = (FlowPane)userView.getRoot();
		this.user = (UserController)userView.getController();
		
		BorderPane.setAlignment(userRoot,Pos.CENTER_LEFT);
		
		this.home.setChatControl(chat);
		this.home.setUserControl(user);
		this.login.setHome(home);
		
		boardRoot.setLeft(chatRoot);
		boardRoot.setTop(userRoot);

		this.root = new Group();
		
		this.root.getChildren().add(0,loginRoot);
		this.root.getChildren().add(1,boardRoot);
		this.root.getChildren().get(1).setVisible(false);
		
		this.login.setRoot(root); 
		this.scene = new Scene(root);
		this.login.setStage(stage);
		
		stage.setScene(scene);
		stage.setTitle("Board Game");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
