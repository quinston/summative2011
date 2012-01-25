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

        //allows upperCorner to be checked out of this class
	@Override
	public Point3D getUpperCorner() {
		return upperCorner;
	}

        //allows lowerCorner to be checked out of this class
	@Override
	public Point3D getLowerCorner() {
		return lowerCorner;
	}

        //new ships take in a location and size
	public Ship(Point3D UC, Point3D LC) {
		upperCorner = UC;
		lowerCorner = LC;
	}
        
        //takes damage so you can die
	@Override
	public void takeDamage(int n) {
		hp -= n;
	}
        
        //allows health to be checked out of this class
	@Override
	public int getHP() {
		return hp;
	}
        //paints your health, no picture because you can't see yourself
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

        //what is run when the timer ticks
	@Override
	public void cycle(int cycleNumber) {
                //ticks down to next time you can fire
		fireDelay--;
                //ticks down to next time you can get hit
		if (injuryRedAlpha > 0) {
			injuryRedAlpha--;
		}

		//System.out.println("(" + upperCorner.x +","+upperCorner.y+","+upperCorner.z + ") -> (" + lowerCorner.x + "," + lowerCorner.y + "," + lowerCorner.z + ")");

	}
        
        //shoots bullets
	public void shoot() {
                //before anything else, make sure you can't fire too quickly
		if (fireDelay > 0) {
			return;

		}
                //creates the bullet to fly 
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
		//sets the owner of the bullet to this ship so you can't hit yourself
                b.owner = this;
		//adds the bullet to the damageables array so it is handled
                synchronized (Main.damageables) {
			Main.damageables.add(b);
		}
                //sets the firing delay so you can't fire too often
		fireDelay = maxFireDelay;
	}

        //moves the ship left, used when left is pressed
	public void moveLeft() {
		upperCorner.x -= speed;
		lowerCorner.x -= speed;
	}

        //moves the ship right, used when right is pressed
	public void moveRight() {
		upperCorner.x += speed;
		lowerCorner.x += speed;
	}

        //moves the ship upwards, used when up is pressed
	public void moveUp() {
		upperCorner.y -= speed;
		lowerCorner.y -= speed;
	}
        
        //moves the ship downwards, used when down is pressed
	public void moveDown() {
		upperCorner.y += speed;
		lowerCorner.y += speed;
	}

        //checks collision with the method in utilty class
	public boolean checkCollision(Damageable d) {
		return (Utility.isIntersecting(upperCorner, lowerCorner, d.getUpperCorner(), d.getLowerCorner()));
	}
        //checks collision with bullets and acts
	public void onCollision(Damageable d) {
		if (d.getClass().isAssignableFrom( Bullet.class )) {
			if ( ( (Bullet) d).owner != this) {

				injuryRedAlpha+=80;
			}
		}
	}
        //resets hp when you hit the bonus ship
        public void resetHP(){
            hp = 3;
        }
	private int hp = 3;
	private final int speed = 2;
	private int fireDelay = 0;
	private final int maxFireDelay = 20;
}
