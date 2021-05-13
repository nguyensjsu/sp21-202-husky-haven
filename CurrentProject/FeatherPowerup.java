import greenfoot.*;

public class FeatherPowerup extends AbstractPowerup {

    public FeatherPowerup() {
    }

    public void applyPowerup(Player player) {
        float temp = player.getGravity();
        float speed = player.getYSpeed() * (float) .25;
        player.setYSpeed(speed);
        player.setGravity((float)0.025);

        // gravity is a 10th of current gravity
        // gravity will eventually go back to its original speed;

        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    player.setGravity((float).14);
                }
            }, 
            5000 
        );

    }
}
