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
import java.util.Random;

public class Alien implements Damageable {
    private int i = 0; //for debugging purposes???
    
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
                //g.drawString(upperCorner.x+", "+upperCorner.y+", "+ upperCorner.z, 100, 100+species*10);
		//g.drawString("" + upperCorner2D.getX() + " " + upperCorner2D.getY()
				//+ " " + size.getX() + " " + size.getY(), 10, upperCorner2D.y );
	}
	
	@Override
	public void cycle(int cycleNumber) {
		if (r.nextInt(300) == 0) {
			shoot();
		}
		move(cycleNumber);
                if(upperCorner.z>=-30){
                    Main.gameDone = true;
                }
	}

	public void shoot() {
		Bullet b = new Bullet(
				new Point3D(upperCorner.x-2,upperCorner.y-2,upperCorner.z-2), 
				new Point3D(lowerCorner.x-2, upperCorner.y-2, upperCorner.z-2),
				new Point3D(0, 0, (float)0.05 ));
		b.owner = this;
                Main.damageableBay.add(b);
		
				System.out.println("Enemy bullet!");
	}

	public void move(int cycleNumber) {
 
		//Input to sine called x for lack of better name
		double x = cycleNumber /30. * Math.PI ;
		
		//stuff to slow it down.
		
		upperCorner.x = initialUpperCorner.x 
				+ (float) ( 1* Math.sin(x) );
		//upperCorner.y += Math.round(0.5 * Math.sin(x));
		//upperCorner.z += Math.round(0.5 * Math.sin(x));	
		
		lowerCorner.x = initialLowerCorner.x 
				+ (float)( 1* Math.sin(x) );
		//lowerCorner.y += Math.round(0.5 * Math.sin(x));		
		//lowerCorner.z += Math.round(0.5 * Math.sin(x));
        upperCorner.z+=0.05;
        lowerCorner.z+=0.05;
		
        i++;
        System.out.println("Moved"+i);
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
	
	
	private Random r = new Random();
}
