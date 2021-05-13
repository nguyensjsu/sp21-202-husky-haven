import greenfoot.*;

public abstract class AbstractPowerup extends AbstractSpawnable {
    private GreenfootSound powerUpSound = new GreenfootSound("slurp.wav");

    public void act() {
        if (isTouching(Player.class)) {
            Actor player = getOneIntersectingObject(Player.class);
            if (player != null) {
                applyPowerup((Player)player);
                powerUpSound.play();
                getWorld().removeObject(this);
            }
        }
    }
    
    abstract void applyPowerup(Player player);
}
