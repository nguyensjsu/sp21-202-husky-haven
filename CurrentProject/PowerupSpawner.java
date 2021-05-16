import greenfoot.*;

public class PowerupSpawner extends AbstractSpawner {

    public PowerupSpawner(GameWorld world) {
        super(world, 500, 50);
    }
    
    public AbstractSpawnable getRandomSpawnable() {
        int rand = Greenfoot.getRandomNumber(4);
        
        if (rand == 0)
            return new FeatherPowerup();
        else if (rand == 1)
            return new FirePowerup();
        else if (rand == 2)
            return new BalloonPowerup();
        else
            return new DoodleShield();
    }
}
