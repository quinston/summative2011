/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders3d;

import spaceinvaders3d.Point3D;
import java.awt.Graphics2D;

/**
 *
 * @author quincy
 */

/*
All the physical objects inherit from this interface, so they all
can be treated as just physical objects (as opposed to specifically and
separately handling bullets, aliens, etc)

*/
 
public interface Damageable {
	/* reduce one's hp by n */
    void takeDamage(int n);
    
    /* accessors. whether there are variables to access is up to
    implementation. in our game, all of the objects have HP and 2 Point3D corners */
    int getHP();    
    Point3D getUpperCorner();
    Point3D getLowerCorner();
    
    /* draw oneself on the passed Graphics2D object */
    void paintSelf(Graphics2D g); //30 fps
    
    /* for repetitive tasks, such as the decrement of delays.
    cycleNumber is the number out of 60 of the cycle in the current second */
	void cycle(int cycleNumber); //60 fps (roughly)

	/* when a collision is detected, this handles it. */
	void onCollision(Damageable d);
}
