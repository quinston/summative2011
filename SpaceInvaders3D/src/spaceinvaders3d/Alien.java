package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import spaceinvaders3d.Bullet;
import spaceinvaders3d.Utility;
import java.awt.Graphics2D;
import java.awt.Image;


public class Alien implements Damageable {

	public static BufferedImage sprite = Utility.loadImage("alien1-1.png");
	
	public Alien(Point3D uc, Point3D lc) {
		upperCorner = uc;
		lowerCorner = lc;
		hp = 5999;
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
		Point2D upperCorner2D = upperCorner.convertTo2D();
		Point2D lowerCorner2D = lowerCoerner.convertTo2D();
		Point2D width = Point2D(lowerCorner2D.getX() - upperCorner2D.getX(),
				lowerCorner2D.getY() - upperCorner2D.getY());
		g.drawImage(sprite, upperCorner2D.getX(), upperCorner2D.getY(),
				width.getX(), width.getY(), null);
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