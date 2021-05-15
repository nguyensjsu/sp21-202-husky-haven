import greenfoot.*;
//sfx from zapsplat.com

public class FireShootingStrategy extends AbstractShootingStrategy {

    private GreenfootSound fireball_sfx = new GreenfootSound("fireball_shot.mp3");

    public FireShootingStrategy(World world) {
        super(world, 500);
    }

    public void handleShooting(Actor shooter, boolean fromPlayer) {
        fireball_sfx.setVolume(25);
        fireball_sfx.play();
        
        if (shooter == null)
            return;
            
        for (int i = 0; i < 3; i++) {
            Fireball fb = new Fireball(fromPlayer, 250 + 20 * i);
            world.addObject(fb, shooter.getX() - 1 + i, shooter.getY() - shooter.getImage().getHeight());
        }
    }

    //for implementing on press sfx in player class
    public String getProjectileType(){
        return "fireball";
    }
}
