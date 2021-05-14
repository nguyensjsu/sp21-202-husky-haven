import greenfoot.*;

public class CloudPlatform extends AbstractPlatform {
    private GreenfootSound long_boing = new GreenfootSound("long_boing.mp3");

    public CloudPlatform(float bounceForce) {
        super(bounceForce);
    }

    public void onBounce() {
        long_boing.setVolume(15);
        long_boing.play();
        isDestroyed = true;
    }
}
