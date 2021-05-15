import greenfoot.*;


public class PlatformSpawner extends AbstractSpawner {

    private final int MAX_PLATFORMS = 12;

    public PlatformSpawner(GameWorld world) {
        super(world, 100, 100);
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
        //int rand = Greenfoot.getRandomNumber(10);
        int rand = Greenfoot.getRandomNumber(11);
        /*if (rand <= 5)
            return new Platform(10.0f);
        else
            return new CloudPlatform(12.0f);*/

        //60% regular, 30% cloud, 10% wood
        if (rand <= 6)
            return new Platform(10.0f);
        else if (rand > 6 && rand <= 9)
            return new CloudPlatform(12.0f);
        else
            return new WoodPlatform(5.0f);
    }
}
