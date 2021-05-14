import greenfoot.*;
//sfx from zapsplat.com

public class AbstractEnemy extends AbstractSpawnable {

    //private GreenfootSound death_sfx = new GreenfootSound("enemy_ded.mp3");

    public void wrap() {
        int x = getX();

        if (x > GameWorld.WIDTH)
            setLocation(10, getY());
        else if (x < 0)
            setLocation(GameWorld.WIDTH - 10, getY());
    }

    public void kill() {
        //death_sfx.setVolume(20);
        //death_sfx.play();
        getWorld().removeObject(this);
    }
}
