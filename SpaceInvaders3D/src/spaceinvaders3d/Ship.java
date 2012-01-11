package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3d;
import spaceinvaders3d.Bullet;

public class Ship implements Damageable {

	private Point3d upperCorner, lowerCorner;
	
	public Point3d getUpperCorner() {
		return upperCorner;
	}
	public Point3d getLowerCorner() {
		return lowerCorner;
	}

	public Ship();
	public void takeDamage(int n) {
		hp -= n;
	}
	public int getHP() {
		return hp;
	}
	
	public void shoot() {
		Bullet b = new Bullet(upperCorner, lowerCorner, new Point3d(0,-90,0) );
		b.owner = this;
	}
	
	public void moveLeft() {
		upperCorner.x -= speed;
		lowerCorner.x -= speed;
	}
	
	public void moveRight() {
		upperCorner.x += speed;
		lowerCorner.x += speed;
	}
	
	public void boolean checkCollision(Point3d topLeft, Point3d topRight) {
		if((lowerCorner.x>=topLeft.x)
				&&(upperCorner.x<=botRight.x)
				&&(lowerCorner.y>=topLeft.y)
				&&(upperCorner.y<=botRight.y)
				&&(upperCorner.z>=botRight.z)
				&&(lowerCorner.z<=topLeft.z))
			return true;
		}
		else{
			return false;
		}
	}

	private int hp;
	private final int speed = 5;
}