package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import spaceinvaders3d.Bullet;

public class Alien implements Damageable {

    @Override
    public void takeDamage(int n) {
        hp -= n;
    }

    @Override
    public int getHP() {
        return hp;
    }

    public void shoot() {
        Bullet b = new Bullet(upperCorner, lowerCorner,
                new Point3D(0, 90, 0));
        b.owner = this;
    }

    public void move() {
        //Maybe we'll use the sine function?
    }
    

    @Override
    public Point3D getUpperCorner() {
        return upperCorner;
    }

    @Override
    public Point3D getLowerCorner() {
        return lowerCorner;
    }
    private int hp;
    private Point3D upperCorner, lowerCorner;
}