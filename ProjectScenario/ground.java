import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ground  extends Actor
{
    GreenfootImage groundImg = new GreenfootImage("ground.png");
    GreenfootImage bottomGroundImg = new GreenfootImage("bottom-ground.png");
    boolean hasBeenBounced;
    int x_pos, y_pos;
    /**
     * Act - do whatever the ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public ground()
    {
        hasBeenBounced=false;
        setImage(groundImg);
    }

    public ground(boolean bouncable)
    {
        hasBeenBounced=true;
        setImage(bottomGroundImg);
    }

    public void act() 
    {
        if(((doodleWorld) getWorld()).scroll==true)
        {
            scroll(((doodleWorld) getWorld()).scrollSpeed);
        }

        if(((doodleWorld) getWorld()).fall==true)
        {
            fall(((doodleWorld) getWorld()).scrollSpeed);
        }

        if(y_pos < 0)
        {
            getWorld().removeObject(this);
            return;
        }
    }    

    protected void addedToWorld(World world)
    {
        x_pos = getX();
        y_pos = getY();
    }

    public void scroll(int speed)
    {
        if(speed>0)
        {
            y_pos = y_pos + speed;
            setLocation(x_pos, y_pos);
        }
    }

    public void fall(int speed)
    {
        if(((doodleWorld) getWorld()).ended==false)
        {
            y_pos = y_pos + speed;
            setLocation(x_pos, y_pos);
        }
    }
}
