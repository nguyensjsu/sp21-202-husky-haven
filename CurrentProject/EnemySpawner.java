import greenfoot.*;

public class EnemySpawner extends AbstractSpawner {
    
    public EnemySpawner(GameWorld world) {
        super(world, 300, 50);
    }
    
    public AbstractSpawnable getRandomSpawnable() {
        int rand = Greenfoot.getRandomNumber(10);
        
        if (rand <= 5)
            return new Wiggler(Greenfoot.getRandomNumber(5) + 3);
        else
            return new Mover(Greenfoot.getRandomNumber(11) - 5);
    }
}
