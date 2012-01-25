package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import spaceinvaders3d.Bullet;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.*;

public class Ship implements Damageable {

	private Point3D upperCorner, lowerCorner;

	private int injuryRedAlpha=0; //when hurt, paints the screen in red which decreases over time

	@Override
	public Point3D getUpperCorner() {
		return upperCorner;
	}

	@Override
	public Point3D getLowerCorner() {
		return lowerCorner;
	}

	public Ship(Point3D UC, Point3D LC) {
		upperCorner = UC;
		lowerCorner = LC;
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
	public void paintSelf(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.drawString(hp + " HP", 10, 30);

		
		
		
		/*g.setColor(Color.RED);
		Point3D windowUpperCorner = new Point3D(upperCorner.x,upperCorner.y,2);
		Point3D windowLowerCorner = new Point3D(lowerCorner.x,lowerCorner.y,2);
		Point windowUpperCornerP = windowUpperCorner.convertTo2D();
		Point windowLowerCornerP = windowLowerCorner.convertTo2D();
		
		System.out.println(String.format("(%d,%d) (%d,%d)", windowUpperCornerP.x, windowUpperCornerP.y, windowLowerCornerP.x, windowLowerCornerP.y);

		g.drawRect(windowUpperCornerP.x, 
				windowUpperCornerP.y,
				windowLowerCornerP.x - windowUpperCornerP.y,
				windowLowerCornerP.x - windowUpperCornerP.y);
*/

		/*
		Point up = upperCorner.convertTo2D();
		Point lp = lowerCorner.convertTo2D();
		Point deltaP = new Point(lp.x-up.x, lp.y-up.y);
		Point meanP = new Point((lp.x+up.x)/2, (lp.y+up.y)/2);
		g.fillRect(meanP.x, meanP.y, deltaP.x, deltaP.y);
		 * */


		/*
		g.setColor(Color.RED);
		int x = upperCorner.convertTo2D().x;
		int y = upperCorner.convertTo2D().y;
		int w = lowerCorner.convertTo2D().x - upperCorner.convertTo2D().x;
		int h = lowerCorner.convertTo2D().y - upperCorner.convertTo2D().y;
		g.drawRect(x, y, w, h);
		System.out.println(x + " " + y + " " + w + " " + h);
		 */


		g.setColor(new Color(0xff, 0x33, 00, injuryRedAlpha) );
		g.fillRect(0,0,Main.frame.imagePanel1.getWidth(),
				Main.frame.imagePanel1.getHeight());
	}

	@Override
	public void cycle(int cycleNumber) {
		fireDelay--;
		if (injuryRedAlpha > 0) {
			injuryRedAlpha--;
		}

		//System.out.println("(" + upperCorner.x +","+upperCorner.y+","+upperCorner.z + ") -> (" + lowerCorner.x + "," + lowerCorner.y + "," + lowerCorner.z + ")");

	}

	public void shoot() {
		if (fireDelay > 0) {
			return;

		}

		Bullet b = new Bullet(new Point3D((upperCorner.x + lowerCorner.x) / 2 - 5,
				(upperCorner.y + lowerCorner.y) / 2 - 5,
				(upperCorner.z + lowerCorner.z) / 2 - 5),
				new Point3D((upperCorner.x + lowerCorner.x) / 2 + 5,
				(upperCorner.y + lowerCorner.y) / 2 + 5,
				(upperCorner.z + lowerCorner.z) / 2 + 5),
				new Point3D(0, 0, (float) +2));
		//System.out.println(upperCorner.x+", "
		//		+upperCorner.y+", "+upperCorner.z);
		//System.out.println(lowerCorner.x+", "
		//		+lowerCorner.y+", "+lowerCorner.z);

		//System.out.println("Friendly bullet");
		b.owner = this;
		synchronized (Main.damageables) {
			Main.damageables.add(b);
		}

		fireDelay = maxFireDelay;
	}

	public void moveLeft() {
		upperCorner.x -= speed;
		lowerCorner.x -= speed;
	}

	public void moveRight() {
		upperCorner.x += speed;
		lowerCorner.x += speed;
	}

	public void moveUp() {
		upperCorner.y -= speed;
		lowerCorner.y -= speed;
	}

	public void moveDown() {
		upperCorner.y += speed;
		lowerCorner.y += speed;
	}

	public boolean checkCollision(Damageable d) {
		return (Utility.isIntersecting(upperCorner, lowerCorner, d.getUpperCorner(), d.getLowerCorner()));
	}

	public void onCollision(Damageable d) {
		if (d.getClass().isAssignableFrom( Bullet.class )) {
			if ( ( (Bullet) d).owner != this) {

				injuryRedAlpha+=80;
			}
		}
	}
        public void resetHP(){
            hp = 3;
        }
	private int hp = 3;
	private final int speed = 2;
	private int fireDelay = 0;
	private final int maxFireDelay = 20;
}
