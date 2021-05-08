import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    float ys, xs;
    int x,y;
    boolean canMove;
    GreenfootImage left = new GreenfootImage("../images/doodler.png");

    GreenfootImage right = new GreenfootImage("../images/doodler.png");
    int scrollSpeed;
    int hits = 0;


    protected void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }

    public Player(boolean movable) {
        left.mirrorHorizontally();
        canMove = movable;
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        x = getX();
        y = getY();

        ((GameWorld) getWorld()).doodleX = getX();

        if(((GameWorld) getWorld()).fall==false)
        {
            bounce();
        }
        if(canMove)
            keys();

        if(ys>11)
            ys = 10;

        setLocation(x+(int)xs, y+(int)ys);

        gravity();
        wrapAround();

        if(canMove & y < 400)
            scrollUp();

        if(y>1600)
            fall();
        ((GameWorld) getWorld()).height = hits;

        scout();
    }



    public void gravity()
    {
        //ys += 0.3f;
        ys += .04f;
    }

        public void bounce()
    {

    }

        public void scrollUp()
    {
        if(y<=200 & y>100)
        {
            ((GameWorld) getWorld()).scrollSpeed = (int) -ys;
            ((GameWorld) getWorld()).scroll = true;
            hits++;
        }
        else if(y<=100)
        {
            ((GameWorld) getWorld()).scrollSpeed = (int) -ys*2;
            ((GameWorld) getWorld()).scroll = true;
            hits++;
        }

        else
        {
            ((GameWorld) getWorld()).scroll = false;
        }
    }

    public void fall()
    {
        ((GameWorld) getWorld()).fall = true;
        ((GameWorld) getWorld()).scrollSpeed = (int) -ys;
    }

    public void wrapAround()
    {
        if(x>1200)
        {
            setLocation(0, getY());
        }
        if(x<0)
        {
            setLocation(1200,getY());
        }
        
        //if(y > 800) {
        //    setLocation(getX(), 0);
        //}
        
    }

    public void scout()
    {

    }

    public void keys()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            xs += 0.25f;
            setImage(right);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            xs -= 0.25f;
            setImage(left);
        }
        if(!Greenfoot.isKeyDown("left") & !Greenfoot.isKeyDown("right") & xs != 0)
        {
            xs = 0;
        }
        

    }
}
