import greenfoot.*;

public class PowerupSpawner extends AbstractSpawner {
    
    private FeatherPowerup featherPowerup = new FeatherPowerup();
    private FirePowerup firePowerup = new FirePowerup();
    private BalloonPowerup balloonPowerup = new BalloonPowerup();
    private DoodleShield doodleShield = new DoodleShield();
    private AbstractPowerup powerups[] = {featherPowerup, firePowerup, balloonPowerup, doodleShield}; 
    public PowerupSpawner(GameWorld world) {
        super(world, 200, 50);
    }
    
    public AbstractSpawnable getRandomSpawnable() {
        int rand = Greenfoot.getRandomNumber(powerups.length);
        return powerups[rand];
    }
}
