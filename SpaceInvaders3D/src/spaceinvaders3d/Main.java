/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders3d;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.Timer;
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

	public static ArrayList<spaceinvaders3d.Damageable> damageables = new ArrayList<spaceinvaders3d.Damageable>();

    
    public static void main(String[] args) {
        frame.setVisible(true);
        camera.position.x = 0;
        camera.position.y = 0;
        camera.position.z = 0;
        // TODO code application logic here
        ActionListener taskPerformer = new ActionListener ()
        {
            public void actionPerformed (ActionEvent evt)
            {
                //for(all damageables){
                
                //}
            }
        }
        ;
        Timer t = new Timer (50, taskPerformer);
        t.start ();
						
		damageables.add(new spaceinvaders3d.Alien(new Point3D(0,0,-130), new Point3D(5,5,-130), 0 ) );
		damageables.add(new spaceinvaders3d.Alien(new Point3D(-5,-5,-30), new Point3D(0,0,-30), 1) );
		damageables.add(new spaceinvaders3d.Alien(new Point3D(10,10,70), new Point3D(15,15,70), 2) );
    }
}
