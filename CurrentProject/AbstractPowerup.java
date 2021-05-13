import greenfoot.*;

public abstract class AbstractPowerup extends AbstractSpawnable {
    
    public void act() {
        if (isTouching(Player.class)) {
            Actor player = getOneIntersectingObject(Player.class);
            if (player != null) {
                applyPowerup((Player)player);
                getWorld().removeObject(this);
            }
        }
    }
    
    abstract void applyPowerup(Player player);
}
