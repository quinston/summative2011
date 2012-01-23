
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

	public static boolean isIntersecting(spaceinvaders3d.Point3D uc1, 
			spaceinvaders3d.Point3D lc1, 
			spaceinvaders3d.Point3D uc2, 
			spaceinvaders3d.Point3D lc2) {
		if ((uc1.x >= uc2.x) && (uc1.x <= lc2.x) && 
				(uc1.y >= uc2.y) && (uc1.y <= lc2.y) &&
				(uc1.z >= uc2.z) && (uc1.z <= lc2.z)) {
			return true;
		}
		return false;
	}
}
