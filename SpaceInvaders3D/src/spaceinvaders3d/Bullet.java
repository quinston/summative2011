// The "Bullets" class.
package spaceinvaders3d;

import java.awt.*;

import spaceinvaders3d.Damageable;
import spaceinvaders3d.Point3D;

public class Bullet implements Damageable {

    Point3D upperCorner, lowerCorner, direction;
    public Damageable owner;

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

    public boolean checkCollision(Point3D topLeft, Point3D botRight) {
        if ((lowerCorner.x >= topLeft.x)
                && (upperCorner.x <= botRight.x)
                && (lowerCorner.y >= topLeft.y)
                && (upperCorner.y <= botRight.y)
                && (upperCorner.z >= botRight.z)
                && (lowerCorner.z <= topLeft.z)) {
            return true;
        } else {
            return false;
        }
    }

    public void onCollision(Damageable d) {
        if (d == owner) {
            return;
        } else {
            if (checkCollision(d.getUpperCorner(), d.getLowerCorner())) {
                d.takeDamage(1);

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
    private int hp;
}
