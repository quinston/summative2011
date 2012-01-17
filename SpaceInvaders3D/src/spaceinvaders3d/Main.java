/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders3d;

import java.util.ArrayList;
import java.util.ListIterator;


/**
 *
 * @author Stephen Wen
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static GameFrame frame = new GameFrame();     
    public static Camera camera = new Camera();

	public static ArrayList<spaceinvaders3d.Damageable> damageables = new ArrayList<spaceinvaders3d.Damageable>();

    
    public static void main(String[] args) {
        frame.setVisible(true);
        camera.position.x = 0;
        camera.position.y = 0;
        camera.position.z = 0;
        // TODO code application logic here

						
		damageables.add(new spaceinvaders3d.Alien(new Point3D(20,20,7), new Point3D(15,20,8)));
    }
}
