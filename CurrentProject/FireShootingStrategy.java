import greenfoot.*;

public class FireShootingStrategy extends AbstractShootingStrategy {
    
    public FireShootingStrategy(World world) {
        super(world, 500);
    }
    
    public void handleShooting(Actor shooter, boolean fromPlayer) {
        for (int i = 0; i < 3; i++) {
            Fireball fb = new Fireball(fromPlayer, 250 + 20 * i);
            world.addObject(fb, shooter.getX() - 1 + i, shooter.getY() - shooter.getImage().getHeight());
        }
    }
}
