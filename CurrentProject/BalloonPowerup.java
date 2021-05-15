import greenfoot.*;

public class BalloonPowerup extends AbstractPowerup {

    public BalloonPowerup() {
    }

    public void applyPowerup(Player player) {
        float temp = player.getGravity();
        float speed = player.getYSpeed() * (float) .5;
        player.setGravity((float)-.01);
        new java.util.Timer().schedule(
            new java.util.TimerTask() {
                @Override
                public void run() {
                    //player.java gravity was 0.15?
                    //player.setGravity((float).14);
                    player.setGravity((float).15);
                }
            },
            5000
        );
    }
}
