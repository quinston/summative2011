// The "Bullets" class.
package spaceinvaders3d;

import java.awt.*;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Bullet implements Damageable {

    Point3D upperCorner, lowerCorner, direction;
	int deathTimer = 1200;
    public Damageable owner;
    static final BufferedImage self = Utility.loadImage("downFacingBullet.png");
	
    public Bullet(Point3D UpperCorner, Point3D LowerCorner, Point3D movementDirection) {
        upperCorner = UpperCorner;
        lowerCorner = LowerCorner;
        direction = movementDirection;
        hp = 1;
    }

    public void move() {
        upperCorner.x += direction.x;
        upperCorner.y += direction.y;
        upperCorner.z += direction.z;
        lowerCorner.x += direction.x;
        lowerCorner.y += direction.y;
        lowerCorner.z += direction.z;
    }


    public void onCollision(Damageable d) {

        if (d == owner || d.getClass().isAssignableFrom(owner.getClass()) ) {
            return;
        } else {
				System.out.println("Collided with a: " + d.getClass().toString() + "while my owner is a: " + owner.getClass().toString() );
                d.takeDamage(1);
                System.out.println("HIT. d has " + d.getHP() + "HP");
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
        Point upperCorner2d = this.upperCorner.convertTo2D();
        Point lowerCorner2d = this.lowerCorner.convertTo2D();
        //g.drawString(upperCorner2d.x +", "+upperCorner2d.y, 150, 150);
        g.drawImage(self, upperCorner2d.x,upperCorner2d.y, lowerCorner2d.x-upperCorner2d.x, lowerCorner2d.y-upperCorner2d.y, null);
        g.setColor(Color.BLACK);
        //g.drawString(""+upperCorner.x+", "+upperCorner.y+", "+upperCorner.z, 100, 100);
        //g.drawString(""+lowerCorner.x+", "+lowerCorner.y+", "+lowerCorner.z, 100, 120);
        //System.out.println("Bullet Drawn");
    }
	
	@Override
	public void cycle(int cycleNumber) {
		deathTimer--;
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
