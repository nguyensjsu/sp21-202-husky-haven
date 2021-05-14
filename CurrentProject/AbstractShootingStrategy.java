import greenfoot.*;

public abstract class AbstractShootingStrategy {

    protected World world;
    private int cooldown;
    private long nextShot;

    public AbstractShootingStrategy(World world, int cooldown) {
        this.world = world;
        this.cooldown = cooldown;
        this.nextShot = 0;
    }

    public void fire(Actor shooter, boolean fromPlayer) {
        long now = System.currentTimeMillis();

        if (now >= nextShot) {
            handleShooting(shooter, fromPlayer);
            nextShot = now + cooldown;
        }
    }

    abstract void handleShooting(Actor shooter, boolean fromPlayer);
    abstract String getProjectileType();
}
