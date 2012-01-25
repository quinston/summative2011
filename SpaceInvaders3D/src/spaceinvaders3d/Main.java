
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
    //initializes everything needed to run the game
        //JFrame to run teh game on
	public static GameFrame frame = new GameFrame();
        //sets the viewpoint
	public static Camera camera = new Camera();
        //creates you
	public static Ship player = new Ship(new Point3D(-5, -05, 0), new Point3D(5, 5, 1));
        //creates the bonus ship to reset your health
        public static BonusShip bonus = new BonusShip(new Point3D(-90, -5, 250), new Point3D(-85, 5, 250));
        //creates the array that holds everything so they can be easily used
	public static ArrayList<spaceinvaders3d.Damageable> damageables = new ArrayList<spaceinvaders3d.Damageable>();
        //says the game is still going
	public static boolean gameDone = false;
	//add to the bay before adding to damageables to avoid concurrentmodificationexception
	public static ArrayList<spaceinvaders3d.Damageable> damageableBay = new ArrayList<spaceinvaders3d.Damageable>();

	public static void main(String[] args) {

                //initializes
		frame.setVisible(true);
		camera.position.x = 0;
		camera.position.y = 0;
		camera.position.z = 0;
		// TODO code application logic here    

		frame.createAliens();
		frame.createShields();

		damageables.add(player);
                damageables.add(bonus);
                
		frame.addKeyListener(frame);
		while (true) {
                        //makes the viewpoint follow the player
			camera.position.x = (player.getUpperCorner().x + player.getLowerCorner().x) / 2;
			camera.position.y = (player.getUpperCorner().y + player.getLowerCorner().y) / 2;
			camera.position.z = (player.getUpperCorner().z + player.getLowerCorner().z) / 2;

			/*
			camera.position.x = player.getUpperCorner().x;
			camera.position.y = player.getUpperCorner().y;
			camera.position.z = player.getUpperCorner().z;
			 * 
			 */
		}
	}
}
