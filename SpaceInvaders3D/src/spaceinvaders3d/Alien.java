package spaceinvaders3d;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;
import spaceinvaders3d.Bullet;
import spaceinvaders3d.Utility;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Alien implements Damageable {

	public static BufferedImage sprite = Utility.loadImage("spaceinvaders3d/alien1-1.png");
	
	public Alien(Point3D uc, Point3D lc) {
		upperCorner = uc;
		lowerCorner = lc;
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
		Point upperCorner2D = upperCorner.convertTo2D();
		Point lowerCorner2D = lowerCorner.convertTo2D();
		Point size = new Point((int) (lowerCorner2D.getX() - upperCorner2D.getX()),
				(int) (lowerCorner2D.getY() - upperCorner2D.getY()) );
		g.drawImage(sprite, (int) upperCorner2D.getX(), (int) upperCorner2D.getY(),
				(int) size.getX(), (int) size.getY(), null);
        g.setColor(Color.red);
        //g.fillRect((int) upperCorner2D.getX(), (int) upperCorner2D.getY(),
		//		(int) size.getX(), (int) size.getY());
        g.drawString("" + upperCorner2D.getX() + " " + upperCorner2D.getY()
        		+ " " + size.getX() + " " + size.getY(), 10, 10 );
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
    private int hp = 1;
    private Point3D upperCorner, lowerCorner;
}
