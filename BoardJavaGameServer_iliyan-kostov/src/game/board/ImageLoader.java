package game.board;

import java.io.File;
import java.util.LinkedList;
import java.util.Random;

import javafx.scene.image.Image;

public class ImageLoader {
	
	public static final String SOURCE = System.getProperty("user.dir")+"/resources/img/";
	
	private File files[];
	
	public ImageLoader(){
		this.files = new File[6];
		final File folder = new File(SOURCE);
		listFilesForFolder(folder);
	}

	public Image takeImage(int i) {
		String name = files[i].getName();
		System.out.println(SOURCE+name);
		Image img = new Image("file:"+SOURCE+name);
		return img;
	}
	
	private void listFilesForFolder(final File folder) {
		int i = 0;
	    for (final File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	        	this.files[i++] = fileEntry;
	        	
	        	if(i == 6){
	        		break;
	        	}
	        }
	    }
	}

}
