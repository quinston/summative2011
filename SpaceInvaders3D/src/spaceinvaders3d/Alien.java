package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3d;
import spaceinvaders3d.Bullet;

public class Alien implements Damageable {


	private Point3d upperCorner, lowerCorner;

	public void takeDamage(int n) {
		hp-=n;
	}
	public int getHp() {
		return hp;
	}
	public int shoot() {
		Bullet b = new Bullet(upperCorner, lowerCorner, new Point3d(0,90,0) );
		b.owner = this;
	}
	public int move() {
		//Maybe we'll use the sine function?
	}
	
	private int hp;
}