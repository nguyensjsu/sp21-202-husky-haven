import greenfoot.*;

public class GroundPlatform extends AbstractPlatform {
    private GreenfootSound water_boing = new GreenfootSound("water_boing.mp3");

    public GroundPlatform(float bounceForce) {
        super(bounceForce);
    }
    public void onBounce(){
        water_boing.setVolume(15);
        water_boing.play();
    }
}
