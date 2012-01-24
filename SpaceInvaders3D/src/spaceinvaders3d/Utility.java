package spaceinvaders3d;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.IIOException;

public class Utility {

	public static String workingDirectory = new Utility().getClass().getResource("Utility.class").toString().replace("Utility.class", "").replaceAll("file:", "");

	public static BufferedImage loadImage(String filename) {
		String fullFilename = workingDirectory + filename;
		//System.out.println(fullFilename);
		try {
			System.out.println(fullFilename);
			return ImageIO.read(new File(fullFilename));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public static boolean isIntersecting(spaceinvaders3d.Point3D uc1,
			spaceinvaders3d.Point3D lc1,
			spaceinvaders3d.Point3D uc2,
			spaceinvaders3d.Point3D lc2) {

		float[][] corners = {
			{uc1.x, uc1.y, uc1.z},
			{lc1.x, uc1.y, uc1.z},
			{uc1.x, lc1.y, uc1.z},
			{lc1.x, lc1.y, uc1.z},
			{uc1.x, uc1.y, lc1.z},
			{lc1.x, uc1.y, lc1.z},
			{uc1.x, lc1.y, lc1.z},
			{lc1.x, lc1.y, lc1.z},};

		for (int i = 0; i < corners.length; i++) {
			float a = corners[i][0];
			float b = corners[i][1];
			float c = corners[i][2];
			if ((a >= uc2.x) && (a <= lc2.x)
					&& (b >= uc2.y) && (b <= lc2.y)
					&& (c >= uc2.z) && (c <= lc2.z)) {
				return true;
			}
		}

		return false;
	}
}
