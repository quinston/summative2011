// The "Bullets" class.
import java.awt.*;

public class Bullets implements damageable: 
{
    Point3d upperCorner, lowerCorner, direction;
    
    public Bullets(Point3d UpperCorner, Point3d LowerCorner, Point3d, movementDirection){
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
} // Bullets class
