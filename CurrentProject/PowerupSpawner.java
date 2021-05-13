import greenfoot.*;

public class PowerupSpawner extends AbstractSpawner {
    
    private FeatherPowerup featherPowerup = new FeatherPowerup();
    private FirePowerup firePowerup = new FirePowerup();
    private AbstractPowerup powerups[] = {featherPowerup, firePowerup};
    public PowerupSpawner(GameWorld world) {
        super(world, 200, 50);
    }
    
    public AbstractSpawnable getRandomSpawnable() {
        int rand = Greenfoot.getRandomNumber(powerups.length - 1);
        return powerups[rand];
    }
}
