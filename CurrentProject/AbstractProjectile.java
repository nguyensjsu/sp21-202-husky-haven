import greenfoot.*;

public class AbstractProjectile implements IProjectileShooter extends Actor{
	
	boolean removed;

	public AbstractProjectile()
	{
	    removed = false;
	}
	public void act() 
	{
	    if(removed){return;}
	    move();
	}   

	public void fireProjectile()
	{
	    if(getY()<=0)
	    {
	        removed = true;
	        getWorld().removeObject(this);
	        return;
	    }
	    setLocation(getX(), getY()-10);
	}

}