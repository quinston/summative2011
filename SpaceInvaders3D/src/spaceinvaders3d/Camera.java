/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders3d;

/**
 *
 * @author Stephen Wen
 */
public class Camera {

	//doesn't matter as the camera follows the ship
    public Point3D position = new Point3D(0, 0, -130);
    
    //width of the cone vision
    int angleOfViewX = 90;
    float angleOffsetX = (180 - angleOfViewX) / 2;

    //cone vision width multiplied by the height:width ratio of the ImagePanel
    int angleOfViewY = angleOfViewX*Main.frame.imagePanel1.getHeight()/Main.frame.imagePanel1.getWidth();
    float angleOffsetY = (180 - angleOfViewY) / 2;

    public Camera() {
    }
}
