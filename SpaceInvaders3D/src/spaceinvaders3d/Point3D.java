/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders3d;

import java.awt.Point;

/**
 *
 * @author Stephen Wen
 */
public class Point3D {

    public float x, y, z;
    //takes in x, y, z coordinates and stores them
    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //converts 3d points to 2d points for painting
    public Point convertTo2D() {
        //creates values that compare to thh view point
        float dX = Main.camera.position.x - this.x;
        float dY = Main.camera.position.y - this.y;
        float dZ = Math.abs(Main.camera.position.z - this.z);
        
        //creates angles to compare the points to
        Main.camera.angleOfViewY = Main.camera.angleOfViewX * Main.frame.imagePanel1.getHeight() / Main.frame.imagePanel1.getWidth();
        Main.camera.angleOffsetY = (180 - Main.camera.angleOfViewY) / 2;
        
        //gets the angles from the point
        //the x angle
        float Alpha = (float) (Math.atan2(dZ, dX) * (180 / Math.PI) - Main.camera.angleOffsetX);
        //the y angle
        float Beta = (float) (Math.atan2(dZ, dY) * (180 / Math.PI) - Main.camera.angleOffsetY);

        //the actual 2d point
        float X2D = (Alpha / Main.camera.angleOfViewX) * Main.frame.imagePanel1.getWidth();
        float Y2D = (Beta / Main.camera.angleOfViewY) * Main.frame.imagePanel1.getHeight();

        Point point2D = new Point((int) X2D, (int) Y2D);
        return point2D;
        
    }
}
