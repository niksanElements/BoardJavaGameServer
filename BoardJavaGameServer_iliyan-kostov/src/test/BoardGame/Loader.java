package test.BoardGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * All fxml files must be 
 * in a folder 
 * resources in the current project.
 * @author Nikolay
 *
 */

public class Loader{
	
	public static final String path = System.getProperty("user.dir");
	
	protected static  FXMLLoader loader;
	protected static FileInputStream view;
	
	public static LoadView load (String file){
		loader = new FXMLLoader();
		
		// Load fxml file
        String fxmlDocPath = path+"/resources/"+file;
        
        FileInputStream fxmlStream;
		try {
			
			fxmlStream = new FileInputStream(fxmlDocPath);
			loader.load(fxmlStream);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new LoadView(loader.getRoot(),loader.getController());
	}
}
