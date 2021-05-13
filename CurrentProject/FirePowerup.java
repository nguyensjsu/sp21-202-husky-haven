import greenfoot.*;

public class FirePowerup extends AbstractPowerup {
    
    public FirePowerup() {
    }
    
    public void applyPowerup(Player player) {
        player.setShootingStrategy(new FireShootingStrategy(getWorld()));
    }
}
