
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders3d;

import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.event.*;

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
    public static Ship player = new Ship(new Point3D(-10, -10, 10), new Point3D(10, 10, 10));
	public static ArrayList<spaceinvaders3d.Damageable> damageables = new ArrayList<spaceinvaders3d.Damageable>();

    public static boolean gameDone = false;

	//add to the bay before adding to damageables to avoid concurrentmodificationexception
	public static ArrayList<spaceinvaders3d.Damageable> damageableBay =new ArrayList<spaceinvaders3d.Damageable>();

    
    public static void main(String[] args) {

		
        frame.setVisible(true);
        camera.position.x = 0;
        camera.position.y = 0;
        camera.position.z = 0;
        // TODO code application logic here    
		
		frame.createAliens();
		frame.createShields();
		
		damageables.add(player);
                frame.addKeyListener(frame);
                while(true){
                    camera.position.x = (player.getUpperCorner().x+player.getLowerCorner().x)/2;
                    camera.position.y = (player.getUpperCorner().y+player.getLowerCorner().y)/2;
                    camera.position.z = (player.getUpperCorner().z+player.getLowerCorner().z)/2;
        
                }
    }
    
}
