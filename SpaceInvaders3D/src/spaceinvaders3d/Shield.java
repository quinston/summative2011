/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders3d;

import java.awt.Color;
import java.awt.Graphics2D;
import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import spaceinvaders3d.Bullet;
import spaceinvaders3d.Utility;
import java.awt.Point;

/**
 *
 * @author Stephen
 */
public class Shield implements Damageable {

	public Shield(Point3D uc, Point3D lc) {
		upperCorner = uc;
		lowerCorner = lc;
	}

	@Override
	public void takeDamage(int n) {
		hp -= n;
	}

	@Override
	public int getHP() {
		return hp;
	}

	@Override
	public Point3D getUpperCorner() {
		return upperCorner;
	}

	@Override
	public Point3D getLowerCorner() {
		return lowerCorner;
	}

	@Override
	public void paintSelf(Graphics2D g) {
		g.setColor(niceBlue);
		Point uc = upperCorner.convertTo2D();
		Point lc = lowerCorner.convertTo2D();
		g.fillRect(uc.x, uc.y, lc.x - uc.x, lc.y - uc.y);
		g.setColor(Color.WHITE);
		g.drawRect(uc.x + 5, uc.y + 5, lc.x - uc.x - 5, lc.y - uc.y - 5);
	}
	private static Color niceBlue = new Color(0, 0x66, 0xFF, 128);

	@Override
	public void cycle(int cycleNumber) {
		return;
		//lolololol
		//throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void onCollision(Damageable d) {
		try {
			if (d.getClass().isAssignableFrom(Class.forName("spaceinvaders3d.Alien"))) {
				hp = 0;
			} else if (d.getClass().isAssignableFrom(Class.forName("spaceinvaders3d.Bullet"))) {
				hp = 0;
				d.takeDamage(1);
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}


	}

	public boolean checkCollision(Damageable d) {
		return (Utility.isIntersecting(upperCorner, lowerCorner, d.getUpperCorner(), d.getLowerCorner()));
	}
	private int hp = 1;
	private Point3D upperCorner;
	private Point3D lowerCorner;
}
