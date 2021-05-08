import greenfoot.*;

public class AbstractProjectile extends Actor implements IProjectileShooter{

	boolean removed;

	public AbstractProjectile()
	{
	    removed = false;
			//default ammo
			//for now set image here, between fireball/ammo
			setImage(new GreenfootImage("ammo.png"));
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
