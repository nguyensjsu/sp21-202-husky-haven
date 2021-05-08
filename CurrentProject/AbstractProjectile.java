import greenfoot.*;

public class AbstractProjectile extends Actor implements IProjectileShooter{

	boolean removed;

	public AbstractProjectile()
	{
	    removed = false;
	}
	public void act()
	{
	    if(removed){return;}
	    fireProjectile();
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
