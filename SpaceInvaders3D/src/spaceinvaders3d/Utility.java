
package spaceinvaders3d;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.IIOException;


public class Utility {
	public static String workingDirectory = new Utility().getClass()
			.getResource("Utility.class").toString()
			.replace("Utility.class", "").replaceAll("file:","");
	
	public static BufferedImage loadImage(String filename) {
		String fullFilename =  workingDirectory + filename;
		//System.out.println(fullFilename);
		try {
			System.out.println(fullFilename);
			return ImageIO.read( new File(fullFilename ) );
		}

		catch(Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
}
