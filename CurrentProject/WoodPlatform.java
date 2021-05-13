import greenfoot.*;

public class WoodPlatform extends AbstractPlatform {
  //wood break sound effect taken from zapsplat.com
  private GreenfootSound soundSound = new GreenfootSound("wood_break.wav");
  private boolean hasPlayed = false;

  public WoodPlatform(float bounceForce) {
      super(bounceForce);
  }

  public void onBounce() {
      //play only once
      if(hasPlayed == false){
          soundSound.play();
          hasPlayed = true;
      }
      setImage(new GreenfootImage("broken_platform.png"));
      goThrough = true;
  }

}
