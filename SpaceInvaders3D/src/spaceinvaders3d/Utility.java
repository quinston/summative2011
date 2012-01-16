import javax.imageio.ImageIO;
import java.io.File;
import java.awt.BufferedImage;

public static class Utility {
	public static BufferedImage loadImage(String filename) {
		try {
			return ImageIO.read(new File("filename"));
		}
		catch(Exception e) {
			
		}
	}
}