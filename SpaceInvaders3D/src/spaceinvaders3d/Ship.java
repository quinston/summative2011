package spaceinvaders3d;

import spaceinvaders3d.Damageable;

public class Ship implements Damageable {
	public Ship();
	public void takeDamage(int n) {
		hp -= n;
	}
	public int getHP() {
		return hp;
	}

	private int hp;
}