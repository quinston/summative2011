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
	/*
	3 types of aliens, 2 sprites for each of em.
	*/
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
	
	/*constructor.
	initialUpperCorner and initialLowerCorner are necessary
	because movement needs them as a frame of reference
	*/

	public Alien(Point3D uc, Point3D lc, int s) {
		upperCorner = initialUpperCorner = uc;
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
		/*convert the corners to 2D xy points with respect to the camera*/
		Point upperCorner2D = upperCorner.convertTo2D();
		Point lowerCorner2D = lowerCorner.convertTo2D();
		Point size = new Point((int) (lowerCorner2D.getX() - upperCorner2D.getX()),
				(int) (lowerCorner2D.getY() - upperCorner2D.getY()));

		BufferedImage sprite;

			/*alternate sprites */
		if (System.currentTimeMillis() / spriteChangeDelay % 2 == 1) {
			sprite = alienSprites[species][0];
		} else {
			sprite = alienSprites[species][1];
		}
/* draw the sprite*/

		g.drawImage(sprite, (int) upperCorner2D.getX(), (int) upperCorner2D.getY(),
				(int) size.getX(), (int) size.getY(), null);

		//g.drawString(upperCorner.x+", "+upperCorner.y+", "+ upperCorner.z, 100, 100+species*10);
		//g.drawString("" + upperCorner2D.getX() + " " + upperCorner2D.getY()
		//+ " " + size.getX() + " " + size.getY(), 10, upperCorner2D.y );
	}

	@Override
	public void cycle(int cycleNumber) {
		//shoot occasionally
		if (r.nextInt(3600) == 0) {
			shoot();
		}
		//move only every 3 cycles
		if (cycleNumber % 3 == 0) {
			move(cycleNumber);
		}
		//if past the camera, earth has been invaded; end the game.
		if (upperCorner.z <= 0) {
			Main.gameDone = true;
		}
	}

	public void shoot() {
//if (true) return;
//makes a 4x4 bullet that heads towards teh camera's position (negative)
		Bullet b = new Bullet(
				new Point3D((upperCorner.x + lowerCorner.x) / 2 - 2, (upperCorner.y + lowerCorner.y) / 2 - 2, (upperCorner.z + lowerCorner.z) / 2 - 2),
				new Point3D((upperCorner.x + lowerCorner.x) / 2 + 2, (upperCorner.y + lowerCorner.y) / 2 + 2, (upperCorner.z + lowerCorner.z) / 2 - 2),
				new Point3D(0, 0, (float) -0.5));
		
		//this aliens owns this bullet and shall not be harmed by it
		b.owner = this;
		
		/*we have to add it to damageableBay because modifying
		Main.damageables while we iterate through it in ImagePanel
		raises a concurrent modification exception
		
		*/
		Main.damageableBay.add(b);

		//System.out.println("Enemy bullet!");
	}

	public void move(int cycleNumber) {

		//Input to sine called x for lack of better name
		double x = cycleNumber / 30. * Math.PI;

		
		/*
		The position at any time is defined by the sine function plus
		the initial position
		*/

		upperCorner.x = initialUpperCorner.x
				+ (float) (1 * Math.sin(x));
		//upperCorner.y += Math.round(0.5 * Math.sin(x));
		//upperCorner.z += Math.round(0.5 * Math.sin(x));	

		lowerCorner.x = initialLowerCorner.x
				+ (float) (1 * Math.sin(x));
		//lowerCorner.y += Math.round(0.5 * Math.sin(x));		
		//lowerCorner.z += Math.round(0.5 * Math.sin(x));
		
		/* slowly approach player*/
		upperCorner.z -= 0.2;
		lowerCorner.z -= 0.2;

	}

	@Override
	public Point3D getUpperCorner() {
		return upperCorner;
	}

	@Override
	public Point3D getLowerCorner() {
		return lowerCorner;
	}

	public void onCollision(Damageable d) {
	}
	private int hp = 1;
	private Point3D upperCorner, lowerCorner,
			initialUpperCorner, initialLowerCorner;
			
	//we need this so that the amount the aliens move is the same every run
	//subtract this from any timekeeping manoeuvres that depend on seconds.
	private final int clockOffset = new GregorianCalendar().get(GregorianCalendar.SECOND);
	
	private int species; // Type 1 has alienSprite1a, b; Type 2 has alienSprite2a etc.
	
	/* longer this delay, slower the aliens' sprites alternate */
	private final int spriteChangeDelay = 150;
	
	/* random number generator */
	private static Random r = new Random();
}
