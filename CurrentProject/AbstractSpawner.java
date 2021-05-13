import greenfoot.*;
import java.util.*;

public abstract class AbstractSpawner {
    
    protected GameWorld world;
    protected int spawnThreshold;
    private int currentOffset;
    
    
    public AbstractSpawner(GameWorld world, int spawnThreshold, int currentOffset) {
        this.world = world;
        this.spawnThreshold = spawnThreshold;
        this.currentOffset = currentOffset;
    }
    
    public void initialSpawn() {
    }
    
    public void scroll(int changeY) {
        currentOffset += changeY;
        
        if (currentOffset >= spawnThreshold) {
            int x = 25 + Greenfoot.getRandomNumber(world.WIDTH - 25);
            currentOffset -= spawnThreshold;
            world.addObject(getRandomSpawnable(), x, currentOffset);
        }
    }
    
    abstract AbstractSpawnable getRandomSpawnable();
}