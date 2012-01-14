/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders3d;

import spaceinvaders3d.Point3D;
import java.awt.Graphics;

/**
 *
 * @author quincy
 */
public interface Damageable {
    void takeDamage(int n);
    int getHP();
    
    Point3D getUpperCorner();
    Point3D getLowerCorner();
    
    void paintSelf(Graphics g);
}
