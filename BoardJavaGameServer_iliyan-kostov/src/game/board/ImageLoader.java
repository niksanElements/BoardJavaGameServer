package game.board;

import java.io.File;
import java.util.LinkedList;
import java.util.Random;

import javafx.scene.image.Image;

public class ImageLoader {
	
	public static final String SOURCE = System.getProperty("user.dir")+"/resources/img/";
	
	private LinkedList<File> files;
	
	public ImageLoader(){
		files = new LinkedList<>();
		final File folder = new File(SOURCE);
		listFilesForFolder(folder);
	}

	public Image takeImage() {
		Random rand = new Random();
		String name = files.get(rand.nextInt(files.size())).getName();
		System.out.println(SOURCE+name);
		Image img = new Image("file:"+SOURCE+name);
		return img;
	}
	
	private void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	this.files.add(fileEntry);
	        }
	    }
	}

}
