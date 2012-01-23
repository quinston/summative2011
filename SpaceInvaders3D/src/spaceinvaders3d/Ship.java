package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import spaceinvaders3d.Bullet;

import java.awt.Graphics2D;

public class Ship implements Damageable {

	private Point3D upperCorner, lowerCorner;

	@Override
	public Point3D getUpperCorner() {
		return upperCorner;
	}

	@Override
	public Point3D getLowerCorner() {
		return lowerCorner;
	}

	public Ship() {
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
	}
	
	@Override
	public void cycle(int cycleNomber) {
		
	}	

	public void shoot() {
		Bullet b = new Bullet(upperCorner, lowerCorner, new Point3D(0, -90, 0));
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
	private int hp = 3;
	private final int speed = 5;
}
