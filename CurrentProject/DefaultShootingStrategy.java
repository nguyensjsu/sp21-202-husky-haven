import greenfoot.*;
//sfx from zapsplat.com

public class DefaultShootingStrategy extends AbstractShootingStrategy {

    private GreenfootSound pellet_sfx = new GreenfootSound("pellet_shot.mp3");

    public DefaultShootingStrategy(World world) {
        super(world, 100);
    }

    public void handleShooting(Actor shooter, boolean fromPlayer) {
        pellet_sfx.setVolume(25);
        pellet_sfx.play();
        
        if (shooter == null)
            return;
        
        Pellet p = new Pellet(fromPlayer, 270);
        world.addObject(p, shooter.getX(), shooter.getY() - shooter.getImage().getHeight());
    }

    //for implementing on press sfx in player class
    public String getProjectileType(){
        return "pellet";
    }
}
