import greenfoot.*;
//sfx from zapsplat.com

public class Platform extends AbstractPlatform {
    private GreenfootSound reg_boing = new GreenfootSound("reg_boing.mp3");

    public Platform(float bounceForce) {
        super(bounceForce);
    }

    public void onBounce(){
        reg_boing.setVolume(15);
        reg_boing.play();
    }
}
