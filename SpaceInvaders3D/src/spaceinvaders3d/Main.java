
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
    public static Ship player = new Ship(new Point3D(50, 50, 0), new Point3D(-50, -50, 0));
	public static ArrayList<spaceinvaders3d.Damageable> damageables = new ArrayList<spaceinvaders3d.Damageable>();

    
    public static void main(String[] args) {
        frame.setVisible(true);
        camera.position.x = 0;
        camera.position.y = 0;
        camera.position.z = 0;
        // TODO code application logic here    
		
		for (int i = 0; i < 15*8; i+=15) {
			damageables.add(new spaceinvaders3d.Alien(new Point3D(i-7,-5,-50), new Point3D(i+15,5,-50), 0 ) );
			damageables.add(new spaceinvaders3d.Alien(new Point3D(i-7,-5,-60), new Point3D(i+15,5,-60), 1) );
			damageables.add(new spaceinvaders3d.Alien(new Point3D(i-7,-5,-70), new Point3D(i+15,5,-70), 2) );
		}
		damageables.add(player);
                frame.addKeyListener(frame);
                while(true){
                    camera.position.x = (player.getUpperCorner().x+player.getLowerCorner().x)/2;
                    camera.position.y = (player.getUpperCorner().y+player.getLowerCorner().y)/2;
                    camera.position.z = (player.getUpperCorner().z+player.getLowerCorner().z)/2;
        
                }
    }
    
}
