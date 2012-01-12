// The "Bullets" class.
import java.awt.*;

import spaceinvaders3d.Damageable;

public class Bullet implements Damageable: 
{
	Point3d upperCorner, lowerCorner, direction;

	public Damageable owner;	
	
	public Bullet(Point3d UpperCorner, Point3d LowerCorner, Point3d movementDirection){
		upperCorner = UpperCorner;
		lowerCorner = LowerCorner;
		direction = movementDirection;
	}
	public void move(){
		upperCorner.x+=direction.x;
		upperCorner.y+=direction.y;
		upperCorner.z+=direction.z;
		lowerCorner.x+=direction.x;
		lowerCorner.y+=direction.y;
		lowerCorner.z+=direction.z;
	}
	public boolean checkCollision(Point3d topLeft, Point3d botRight){
		if((lowerCorner.x>=topLeft.x)
				&&(upperCorner.x<=botRight.x)
				&&(lowerCorner.y>=topLeft.y)
				&&(upperCorner.y<=botRight.y)
				&&(upperCorner.z>=botRight.z)
				&&(lowerCorner.z<=topLeft.z)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean onCollision(Damageable d) {
		if (d == owner) {
			return false;
		}
		else {
		
		}
	}
	
} 
