package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import spaceinvaders3d.Bullet;
import spaceinvaders3d.Utility;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.GregorianCalendar;

public class Alien implements Damageable {

	public static BufferedImage[][] alienSprites = {
		{
			Utility.loadImage("alien1-1.png"),
			Utility.loadImage("alien1-2.png")
		},
		{
			Utility.loadImage("alien2-1.png"),
			Utility.loadImage("alien2-2.png")
		},
		{
			Utility.loadImage("alien3-1.png"),
			Utility.loadImage("alien3-2.png")
		}
	};

	public Alien(Point3D uc, Point3D lc, int s) {
		upperCorner  = initialUpperCorner = uc;
		lowerCorner = initialLowerCorner = lc;
		species = s;
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
		Point upperCorner2D = upperCorner.convertTo2D();
		Point lowerCorner2D = lowerCorner.convertTo2D();
		Point size = new Point((int) (lowerCorner2D.getX() - upperCorner2D.getX()),
				(int) (lowerCorner2D.getY() - upperCorner2D.getY()));

		BufferedImage sprite;

		if (System.currentTimeMillis() / spriteChangeDelay % 2 == 1) {
			sprite = alienSprites[species][0];
		} else {
			sprite = alienSprites[species][1];
		}

		g.drawImage(sprite, (int) upperCorner2D.getX(), (int) upperCorner2D.getY(),
				(int) size.getX(), (int) size.getY(), null);
		g.setColor(Color.red);
                g.drawString(upperCorner.x+", "+upperCorner.y+", "+ upperCorner.z, 100, 100+species*10);
		//g.drawString("" + upperCorner2D.getX() + " " + upperCorner2D.getY()
				//+ " " + size.getX() + " " + size.getY(), 10, upperCorner2D.y );
	}
	
	@Override
	public void cycle(int cycleNumber) {
		move(cycleNumber);
	}

	public void shoot() {
		Bullet b = new Bullet(upperCorner, lowerCorner,
				new Point3D(0, (float)0.5, 0));
		b.owner = this;
                Main.damageables.add(b);
	}

	public void move(int cycleNumber) {
		/*//Input to sine called x for lack of better name
		double x = cycleNumber / 30.0 * Math.PI ;
		
		//stuff to slow it down.
		
		upperCorner.x = initialUpperCorner.x 
				+ Math.round(0.5 * Math.sin(x));
		upperCorner.y += Math.round(0.5 * Math.sin(x));
		upperCorner.z += Math.round(0.5 * Math.sin(x));	
		
		lowerCorner.x = initialLowerCorner.x 
				+ Math.round(0.5 * Math.sin(x));
		lowerCorner.y += Math.round(0.5 * Math.sin(x));		
		lowerCorner.z += Math.round(0.5 * Math.sin(x));*/
                this.upperCorner.z+=0.05;
                this.lowerCorner.z+=0.05;
                System.out.println("Moved");
	}

	@Override
	public Point3D getUpperCorner() {
		return upperCorner;
	}

	@Override
	public Point3D getLowerCorner() {
		return lowerCorner;
	}
	private int hp = 1;
	private Point3D upperCorner, lowerCorner, 
			initialUpperCorner, initialLowerCorner;
	
	//we need this so that the amount the aliens move is the same every run
	//subtract this from any timekeeping manoeuvres that depend on seconds.
	private final int clockOffset = new GregorianCalendar()
			.get(GregorianCalendar.SECOND);
			
	private int species; // Type 1 has alienSprite1a, b; Type 2 has alienSprite2a etc.
	private final int spriteChangeDelay = 150;
}
