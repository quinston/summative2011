package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;

public class Ship implements Damageable {

	private Point3D upperCorner, lowerCorner;
	
	public Point3D getUpperCorner() {
		return upperCorner;
	}
	public Point3D getLowerCorner() {
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
	
	}
	
	public void moveLeft() {
		upperCorner.x -= speed;
		lowerCorner.x -= speed;
	}
	
	public void moveRight() {
		upperCorner.x += speed;
		lowerCorner.x += speed;
	}

	private int hp;
	private final int speed = 5;
}