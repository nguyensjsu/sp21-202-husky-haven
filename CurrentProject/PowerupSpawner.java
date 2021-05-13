import greenfoot.*;

public class PowerupSpawner extends AbstractSpawner {
    
    public PowerupSpawner(GameWorld world) {
        super(world, 1500, 50);
    }
    
    public AbstractSpawnable getRandomSpawnable() {
        int rand = Greenfoot.getRandomNumber(10);
        return new FirePowerup();
    }
}
