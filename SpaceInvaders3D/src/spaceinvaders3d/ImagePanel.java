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
		new Timer().schedule(new ImagePanel.RepaintTask(), 0, 33); //begin immediately and periodically 33ms i.e. 30fps
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
			for (spaceinvaders3d.Damageable d : Main.damageables) {
				if (d.getHP() > 0) {
					d.cycle(new GregorianCalendar()
							.get(GregorianCalendar.MILLISECOND) / 17);
				}
			}
                        if(Main.player.getHP()<=0){
                            
                        }

		}
	}

	@Override
	public void paintComponent(Graphics g) {

		BufferedImage buffer = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g0 = buffer.createGraphics();


		super.paintComponent(g0); //paint background
		if (!Beans.isDesignTime()&&!Main.gameDone) {
			for (spaceinvaders3d.Damageable d : Main.damageables) {

				if (d.getHP() > 0) {
					d.paintSelf((Graphics2D) g0);
				}
			}
                        Main.player.paintSelf(g0);
                        //CROSSHAIR!
                        g0.setColor(Color.RED);
                        spaceinvaders3d.ImagePanel imagePanel = Main.frame.imagePanel1;
                        g0.drawOval(imagePanel.getWidth()/2-15, imagePanel.getHeight()/2-15
                                        , 30, 30);
                        g0.drawLine(imagePanel.getWidth()/2, imagePanel.getHeight()/2+50,
                                        imagePanel.getWidth()/2, imagePanel.getHeight()/2-50);	
                        g0.drawLine(imagePanel.getWidth()/2+50, imagePanel.getHeight()/2,
                                        imagePanel.getWidth()/2-50, imagePanel.getHeight()/2);	
		}

				
		
		//blit the buffer
		g.drawImage(buffer, 0, 0, null);
                if(Main.gameDone){
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, Main.frame.WIDTH, Main.frame.HEIGHT);
                    g.setColor(Color.RED);
                    g.drawString("GAME OVER", 100, 100);
                }
	}

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
