import greenfoot.*;

public class FirePowerup extends AbstractPowerup {

    public FirePowerup() {
    }

    public void applyPowerup(Player player) {
        player.setShootingStrategy(new FireShootingStrategy(getWorld()));
        new java.util.Timer().schedule(
            new java.util.TimerTask() {
                @Override
                public void run() {
                    player.setShootingStrategy(new DefaultShootingStrategy(getWorld()));
                }
            },
            5000
        );
    }
}
