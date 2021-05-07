import greenfoot.*;

public abstract class AbstractScreen {
    
    protected GameWorld world;
    protected GreenfootImage background;
    
    /**
     * Constructor for AbstractScreen that fills the background with a single Color
     */
    public AbstractScreen(GameWorld world, Color backgroundColor) {
        this.world = world;
        
        background = new GreenfootImage(world.getWidth(), world.getHeight());
        background.setColor(backgroundColor);
        background.fill();
    }
    
    /**
     * Constructor for AbstractScreen that fills the background with an Image
     */
    public AbstractScreen(GameWorld world, GreenfootImage background) {
        this.world = world;
        this.background = background;
    }
    
    /**
     * Called when this screen is navigated to
     */
    public void activate() {
        world.setBackground(background);
    }
    
    /**
     * Clears the contents of the current screen
     */
    public abstract void clear();
    
    /**
     * Called every frame. Handles game logic
     */
    public abstract void act();
}
