import greenfoot.*;

public abstract class AbstractPlatform extends AbstractSpawnable {

    private float bounceForce;
    protected boolean isDestroyed;
    protected boolean goThrough;

    public AbstractPlatform(float bounceForce) {
        this.bounceForce = bounceForce;
        this.isDestroyed = false;
        this.goThrough = false;
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
                //for wooden platforms only
                if(goThrough == true){
                    onBounce();
                    return;
                }
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
