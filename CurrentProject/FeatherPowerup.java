import greenfoot.*;

public class FeatherPowerup extends AbstractPowerup {
    
    public FeatherPowerup() {
    }
    
    public void applyPowerup(Player player) {
        float temp = player.getGravity();
        float speed = player.getYSpeed() * (float) .1;
        player.setYSpeed(speed);
        player.setGravity(0);
   
        // gravity is a 10th of current gravity
        // gravity will eventually go back to its original speed;
        
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    player.setGravity(temp);
                }
            }, 
            5000 
        );
        
    }
}
