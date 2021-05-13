import greenfoot.*;


public class PlatformSpawner extends AbstractSpawner {
    
    private final int MAX_PLATFORMS = 12;
    
    public PlatformSpawner(GameWorld world) {
        super(world, 50, 100);
    }
    
    public void initialSpawn() {
        int bottomY = world.HEIGHT - 10;
        
        for (int i = 0; i < MAX_PLATFORMS; i++) {
            world.addObject(createGroundPlatform(), 25 + i * 50, bottomY);
        }
        
        int y = bottomY - spawnThreshold;
        int x;
        
        while (y >= 0) {
            x = 25 + Greenfoot.getRandomNumber(world.WIDTH - 25);
            world.addObject(getRandomSpawnable(), x, y);
            y -= spawnThreshold;
        }
    }
    
    private AbstractSpawnable createGroundPlatform() {
        return new GroundPlatform(10.0f);
    }
    
    public AbstractSpawnable getRandomSpawnable() {
        int rand = Greenfoot.getRandomNumber(10);
        
        if (rand <= 5)
            return new Platform(10.0f);
        else
            return new CloudPlatform(12.0f);
    }
}
