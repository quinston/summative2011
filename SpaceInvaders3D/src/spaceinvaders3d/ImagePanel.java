/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImagePanel.java
 *
 * Created on 21-Dec-2011, 8:39:52 PM
 */
package spaceinvaders3d;

/**
 *
 * @author Stephen Wen
 */
import java.awt.*;
import java.beans.Beans;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.image.BufferedImage;
import java.util.GregorianCalendar;

public class ImagePanel extends javax.swing.JPanel {

	/** Creates new form ImagePanel */
	public ImagePanel() {
		initComponents();
                //timer to paint the panel
		new Timer().schedule(new ImagePanel.RepaintTask(), 0, 33); //begin immediately and periodically 33ms i.e. 30fps
                //timer to make the game run
		new Timer().schedule(new ImagePanel.CycleTask(), 0, 17); //cycle twice as fast as painting.
	}

	private class RepaintTask extends TimerTask {

		@Override
		public void run() {
			repaint(getBounds(null));
		}
	}

	private class CycleTask extends TimerTask {

		@Override
		public void run() {
			synchronized (Main.damageables) {
				for (spaceinvaders3d.Damageable d : Main.damageables) {
					/*assert(d.getUpperCorner().x < d.getLowerCorner().x
					&& d.getUpperCorner().y < d.getLowerCorner().y
					&& d.getUpperCorner().z < d.getLowerCorner().z);*/
                                    //if the damageable is still alive
					if (d.getHP() > 0) {
                                                //calls the cycle method in each of their classes
						d.cycle(new GregorianCalendar().get(GregorianCalendar.MILLISECOND) / 17);
						for (spaceinvaders3d.Damageable e : Main.damageables) {
							//checks collision with every other damageable
                                                        if (d == e
									|| !(Utility.isIntersecting(d.getUpperCorner(),
									d.getLowerCorner(),
									e.getUpperCorner(),
									e.getLowerCorner())

									|| Utility.isIntersecting(e.getUpperCorner(),
									e.getLowerCorner(),
									d.getUpperCorner(),
									d.getLowerCorner()) )
									|| e.getHP() <= 0 || d.getHP() <= 0 ) {
								continue;
							}
                                                        //runs what happens if they collide from each class
							d.onCollision(e);
							e.onCollision(d);
						}
					}
				}
				for (spaceinvaders3d.Damageable d : Main.damageableBay) {
					//adds new damageables, mainly bullets fired
                                        Main.damageables.add(d);
				}
				for (ListIterator<Damageable> i = Main.damageables.listIterator(); i.hasNext();) {
					//if something is dead, get rid of it
                                        if (i.next().getHP() == 0) {
						i.remove();
	
					}
			}
			}
                        //get rid of new damageables waiting to be entered, they have been entered
			Main.damageableBay.clear();
                        //if your health is 0 or less, you lose
			if (Main.player.getHP() <= 0) {
				Main.gameDone = true;
			}


                        //if all the damageables that are not the player are dead, advance the level
			synchronized (Main.damageables) {
				try {
					int population = 0;
					for (Damageable d : Main.damageables) {
						if (d.getClass().isAssignableFrom(
								Class.forName("spaceinvaders3d.Alien"))) {
							population++;
						}
					}
					if (population <= 0) {
						Main.frame.increaseLevel();
						Main.frame.createAliens();
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		}
	}

	@Override
	public void paintComponent(Graphics g) {

                //creates an image to draw stuff with
		BufferedImage buffer = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g0 = buffer.createGraphics();
		g0.setFont(normalFont);


		super.paintComponent(g0); //paint background
		if (!Beans.isDesignTime() && !Main.gameDone) {
			synchronized (Main.damageables) {
                                //draws all damageables if the game is still running    
				for (spaceinvaders3d.Damageable d : Main.damageables) {
					//do not draw if dead or behind the camera
					if (d.getHP() > 0 && d.getUpperCorner().z > -0) {
						d.paintSelf((Graphics2D) g0);
					}
				}
			}
                        //draws the player's health and level
			Main.player.paintSelf(g0);
			//CROSSHAIR!
			g0.setColor(Color.GREEN);
			spaceinvaders3d.ImagePanel imagePanel = Main.frame.imagePanel1;
			g0.drawOval(imagePanel.getWidth() / 2 - 15, imagePanel.getHeight() / 2 - 15, 30, 30);
			g0.drawLine(imagePanel.getWidth() / 2, imagePanel.getHeight() / 2 + 50,
					imagePanel.getWidth() / 2, imagePanel.getHeight() / 2 - 50);
			g0.drawLine(imagePanel.getWidth() / 2 + 50, imagePanel.getHeight() / 2,
					imagePanel.getWidth() / 2 - 50, imagePanel.getHeight() / 2);

		}
                //if you lost, shows a game over screen
		if (Main.gameDone) {
			g0.setColor(Color.BLACK);
			g0.fillRect(0, 0, Main.frame.WIDTH, Main.frame.HEIGHT);
			g0.setColor(Color.RED);
			g0.setFont(gameOverFont);
			g0.drawString("GAME OVER", 100, 100);
		}

		g0.setColor(Color.YELLOW);
		//debugging purposes
		//g.drawString(Integer.toString(Main.damageables.size()), 0, 50);
		g0.drawString("LEVEL " + Main.frame.getLevel(), 0, 70);


		//blit the buffer
		g.drawImage(buffer, 0, 0, null);

	}
	private final static Font gameOverFont =
			new Font("Courier New", Font.BOLD, 30);
	private final static Font normalFont =
			new Font("Courier New", Font.BOLD, 18);

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
