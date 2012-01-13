package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import spaceinvaders3d.Bullet;

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
	
	public void shoot() {
		Bullet b = new Bullet(upperCorner, lowerCorner, new Point3D(0,-90,0) );
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
	
	public boolean checkCollision(Point3D topLeft, Point3D botRight) {
		if((lowerCorner.x>=topLeft.x)
				&&(upperCorner.x<=botRight.x)
				&&(lowerCorner.y>=topLeft.y)
				&&(upperCorner.y<=botRight.y)
				&&(upperCorner.z>=botRight.z)
				&&(lowerCorner.z<=topLeft.z)) {
			return true;
		}
		else{
			return false;
		}
	}

	private int hp;
	private final int speed = 5;
}