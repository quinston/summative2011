// The "Bullets" class.
package spaceinvaders3d;

import java.awt.*;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Bullet implements Damageable {

    Point3D upperCorner, lowerCorner, direction;
	int deathTimer = 9000;
    public Damageable owner;
    static BufferedImage self = Utility.loadImage("downFacingBullet.png");
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

    public boolean checkCollision(Damageable d) {
        if ((lowerCorner.x >= d.getUpperCorner().x)
                && (upperCorner.x <= d.getLowerCorner().x)
                && (lowerCorner.y >= d.getUpperCorner().y)
                && (upperCorner.y <= d.getLowerCorner().y)
                && (upperCorner.z >= d.getLowerCorner().z)
                && (lowerCorner.z <= d.getUpperCorner().z)) {
            return true;
        } else {
            return false;
        }
    }

    public void onCollision(Damageable d) {
        if (d == owner || d.getClass().isAssignableFrom(owner.getClass())) {
            return;
        } else {
            if (checkCollision(d)) {
                d.takeDamage(1);
                System.out.println("HIT");

            }
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
        g.drawString(upperCorner2d.x +", "+upperCorner2d.y, 150, 150);
        g.drawImage(self, upperCorner2d.x,upperCorner2d.y, lowerCorner2d.x-upperCorner2d.x, lowerCorner2d.y-upperCorner2d.y, null);
        g.setColor(Color.BLACK);
        //g.drawString(""+upperCorner.x+", "+upperCorner.y+", "+upperCorner.z, 100, 100);
        //g.drawString(""+lowerCorner.x+", "+lowerCorner.y+", "+lowerCorner.z, 100, 120);
        System.out.println("Bullet Drawn");
    }
	
	@Override
	public void cycle(int cycleNumber) {
		deathTimer--;
		if (deathTimer <= 0) {
			hp = 0;
		}
		move();
		
                for (spaceinvaders3d.Damageable d : Main.damageables) {
                    onCollision(d);
                }
                
	}
    
    private int hp;
}
