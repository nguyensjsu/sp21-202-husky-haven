import greenfoot.*;

public class DefaultShootingStrategy extends AbstractShootingStrategy {
    
    public DefaultShootingStrategy(World world) {
        super(world, 100);
    }
    
    public void handleShooting(Actor shooter, boolean fromPlayer) {
        Pellet p = new Pellet(fromPlayer, 270);
        world.addObject(p, shooter.getX(), shooter.getY() - shooter.getImage().getHeight());
    }
}
