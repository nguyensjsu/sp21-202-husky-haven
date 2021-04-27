import greenfoot.*;

/**
 * generates bullets on action event
 * 
 * @author Benoit
 */
public class ammo  extends Actor
{
    boolean removed;
    /**
     * Act - do whatever the ammo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public ammo()
    {
        removed = false;
    }
    public void act() 
    {
        if(removed){return;}
        move();
    }   
    
    public void move()
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
