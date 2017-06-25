package test.BoardGame;

import javafx.scene.Parent;

public class LoadView {

	private Parent root;
	private Object controller;
	
	public LoadView(Parent root, Object controller) {
		this.root = root;
		this.controller = controller;
	}

	public Parent getRoot() {
		return root;
	}

	public Object getController() {
		return controller;
	}
	
	

}
