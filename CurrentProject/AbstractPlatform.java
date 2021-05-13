import greenfoot.*;

public abstract class AbstractPlatform extends AbstractSpawnable {
    
    private float bounceForce;
    protected boolean isDestroyed;
    
    
    public AbstractPlatform(float bounceForce) {
        this.bounceForce = bounceForce;
        this.isDestroyed = false;
    }
    
    public void act() {
        if (isOffScreen() || isDestroyed) {
            getWorld().removeObject(this);
            return;
        }
        
        if (isTouching(Player.class)) {
            Actor actor = getOneIntersectingObject(Player.class);
            if (actor != null) {
                Player player = (Player)actor;
                if (player.canBounce()) {
                    player.bounce(bounceForce);
                    onBounce();
                }
            }
        }
    }
    
    public void onBounce() {
    }
}
