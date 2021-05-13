import greenfoot.*;

public class WoodPlatform extends AbstractPlatform {
  public WoodPlatform(float bounceForce) {
      super(bounceForce);
  }

  public void onBounce() {
      setImage(new GreenfootImage("broken_platform.png"));
      goThrough = true;
  }

}
