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

    public Point3D position = new Point3D(0, 0, -130);
    int angleOfViewX = 90;
    float angleOffsetX = (180 - angleOfViewX) / 2;

    int angleOfViewY = angleOfViewX*Main.frame.imagePanel1.getHeight()/Main.frame.imagePanel1.getWidth();
    float angleOffsetY = (180 - angleOfViewY) / 2;

    public Camera() {
    }
}
