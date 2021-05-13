import greenfoot.*;

public abstract class AbstractProjectile extends AbstractSpawnable {
    
    protected boolean fromPlayer;
    protected int lifespan;
    protected int rotationDeg;
    protected int speed;
    
    private long deathTime;
    
    
    public AbstractProjectile(boolean fromPlayer, int lifespan, int rotationDeg, int speed) { // lifespan in milliseconds
        this.fromPlayer = fromPlayer;
        this.lifespan = lifespan;
        this.rotationDeg = rotationDeg;
        this.speed = speed;
        
        if (getImage() != null)
            setRotation(this.rotationDeg);
            
        deathTime = System.currentTimeMillis() + lifespan;
    }
    
    public void act() {
        if (System.currentTimeMillis() >= deathTime) {
            getWorld().removeObject(this);
            return;
        }
        
        move(speed);
        
        if (fromPlayer) {
            if (isTouching(AbstractEnemy.class)) {
                Actor enemy = getOneIntersectingObject(AbstractEnemy.class);
                if (enemy != null)
                    ((AbstractEnemy)enemy).kill();
            }
        }
        else {
            if (isTouching(Player.class)) {
                Actor player = getOneIntersectingObject(Player.class);
                if (player != null)
                    ((Player)player).kill();
            }
        }
    }    
}
