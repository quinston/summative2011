// The "Bullets" class.
package spaceinvaders3d;

import java.awt.*;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Bullet implements Damageable {
	/* direction indicates the 3d direction of movement */
	Point3D upperCorner, lowerCorner, direction;
	
	/* when deathTimer = 0, the bullet is destroyed */
	int deathTimer = 1200;
	
	/*the bullet doesn't harm its owner or any objects of the same Class */
	public Damageable owner;
	
	/* the bullet sprite. static so it needn't be reloaded for every object*/
	static final BufferedImage self = Utility.loadImage("downFacingBullet.png");

		/*constructor*/
	public Bullet(Point3D UpperCorner, Point3D LowerCorner, Point3D movementDirection) {
		upperCorner = UpperCorner;
		lowerCorner = LowerCorner;
		direction = movementDirection;
		hp = 1;
	}

	/* increase all of the corners' components by the direction's components */
	public void move() {
		upperCorner.x += direction.x;
		upperCorner.y += direction.y;
		upperCorner.z += direction.z;
		lowerCorner.x += direction.x;
		lowerCorner.y += direction.y;
		lowerCorner.z += direction.z;
	}

	public void onCollision(Damageable d) {
		//prevent family fire by checking ownership, and then class 
		if (d == owner || d.getClass().isAssignableFrom(owner.getClass())) {
			return;
		} else {
			//debug info
			System.out.println("Collided with a: " + d.getClass().toString() + "while my owner is a: " + owner.getClass().toString());
			//damage d
			d.takeDamage(1);
			System.out.println("HIT. d has " + d.getHP() + "HP");
			//destroy self (the bullet)
			hp = 0;
		}
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
	public Point3D getLowerCorner() {
		return lowerCorner;
	}

	@Override
	public Point3D getUpperCorner() {
		return upperCorner;
	}

	@Override
	public void paintSelf(Graphics2D g) {
		/*convert 3d points to 2d with respect to Camera */
		
		Point upperCorner2d = this.upperCorner.convertTo2D();
		Point lowerCorner2d = this.lowerCorner.convertTo2D();
		
		
		
		//g.drawString(upperCorner2d.x +", "+upperCorner2d.y, 150, 150);
		
		//draw the sprite.
		
		g.drawImage(self, upperCorner2d.x, upperCorner2d.y, lowerCorner2d.x - upperCorner2d.x, lowerCorner2d.y - upperCorner2d.y, null);
		//g.setColor(Color.BLACK);
		//g.drawString(""+upperCorner.x+", "+upperCorner.y+", "+upperCorner.z, 100, 100);
		//g.drawString(""+lowerCorner.x+", "+lowerCorner.y+", "+lowerCorner.z, 100, 120);
		//System.out.println("Bullet Drawn");
	}

	@Override
	public void cycle(int cycleNumber) {
		//decrement the deathTimer
		deathTimer--;
		//when deathTimer has reached 0, set HP to 0 i.e. mark for death
		if (deathTimer <= 0) {
			hp = 0;
		}
		move();
//System.out.println(""+upperCorner.x+", "+upperCorner.y+", "+upperCorner.z);
/*		
		
		 */
	}
	private int hp;
}
