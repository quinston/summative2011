
package spaceinvaders3d;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;


public class Utility {
	public static BufferedImage loadImage(String filename) {
		try {
			return ImageIO.read(new File("filename"));
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
}
