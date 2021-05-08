import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private GameScreen gameScreen;

    private GameWorld world;

    public Enemy(GameScreen screen, GameWorld world) {
        gameScreen = screen;
        this.world =world;
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        this.move(Greenfoot.getRandomNumber(25));
        this.kill();
    }
    
    /**
     * Kill - Remove the player and end the game on collision
     */
    public void kill() {

        Actor actor = getOneObjectAtOffset(0, 0, Player.class);
        if(actor != null) {
            getWorld().removeObject(actor);
            world.setScreen(ScreenName.GAME_OVER);
        }


    } 

}
