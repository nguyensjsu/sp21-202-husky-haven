import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class doodleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class doodleWorld  extends World
{
    boolean bStarted, started = false;
    boolean once;
    int transparency = 0;
    int scrollSpeed;
    boolean scroll;
    boolean fall;
    boolean ended;
    
    int height = 0;
    int doodleX;
    /**
     * Constructor for objects of class doodleWorld.
     * 
     */
    public doodleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300,400, 1,false); 

        addObject(new ground(), 56, 317);
        addObject(new doodler(false), 56,200);
        setPaintOrder(scoreKeeper.class, doodler.class, ground.class, ammo.class);
        setBackground("title.png");
        getBackground().setTransparency(255);
        once = true;
        started = false;
        height = 0;
        fall = false;
        ended = false;
    }

    public void act()
    {
        if(bStarted==false & Greenfoot.mouseMoved(this))
        {
            bStarted = true;
        }

        if(started==false & bStarted==true)
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();

            if(Greenfoot.mouseClicked(this))
            {
                if(mouse.getX()>=45 & mouse.getX()<=148
                && mouse.getY()>=104 & mouse.getY()<=138)
                {
                    started = true;
                }
            }
        }
        if(started==true & once==true)
        {
            setBackground("paper.png");
            cleanup();
            once = false;
            setLevel(1);
        }
        if(fall)
        {
            end();
        }
    }

    public void cleanup()
    {
        removeObjects(getObjects(doodler.class));
        removeObjects(getObjects(ground.class));
    }

    public void setLevel(int level)
    {
        switch(level)
        {
            case 1: gamePlay(); break;
        }
    }

    public void gamePlay()
    {
        addObject(new doodler(), getWidth()/2, 300);
        addObject(new ground(false), 28,391);
        addObject(new ground(false), 83,391);
        addObject(new ground(false), 83+55,391);
        addObject(new ground(false), 83+55+55,391);
        addObject(new ground(false), 83+55+55+55,391);
        addObject(new ground(false), 83+55+55+55+55,391);
        
        addObject(new ground(), Greenfoot.getRandomNumber(300), 250);
        addObject(new ground(), Greenfoot.getRandomNumber(300), 150);
        addObject(new ground(), Greenfoot.getRandomNumber(300), 50);
        addObject(new scoreKeeper(), 253,385);
    }
    
    public void end()
    {
        cleanup();
        started=false;
        bStarted=false;
        addObject(new ground(), 56, 317);
        addObject(new doodler(false), 56,200);

        setBackground("title.png");
        getBackground().setTransparency(255);
        once = true;
        started = false;
        height = 0;
        fall = false;
        ended = false;
    }
}
