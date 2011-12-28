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

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point convertTo2D() {

         float dX = Main.camera.position.x - this.x;
        float dY = Main.camera.position.y - this.y;
        float dZ = Math.abs(Main.camera.position.z - this.z);

        Main.camera.angleOfViewY = Main.camera.angleOfViewX * Main.frame.imagePanel1.getHeight() / Main.frame.imagePanel1.getWidth();
        Main.camera.angleOffsetY = (180 - Main.camera.angleOfViewY) / 2;

        float Alpha = (float) (Math.atan2(dZ, dX) * (180 / Math.PI) - Main.camera.angleOffsetX);
        float Beta = (float) (Math.atan2(dZ, dY) * (180 / Math.PI) - Main.camera.angleOffsetY);

        float X2D = (Alpha / Main.camera.angleOfViewX) * Main.frame.imagePanel1.getWidth();
        float Y2D = (Beta / Main.camera.angleOfViewY) * Main.frame.imagePanel1.getHeight();

        Point point2D = new Point((int) X2D, (int) Y2D);
        return point2D;
        
    }
}
