import greenfoot.*;
//projectile sfx taken from zapsplat.com

public abstract class AbstractProjectile extends AbstractSpawnable {

    protected boolean fromPlayer;
    protected int lifespan;
    protected int rotationDeg;
    protected int speed;

    private long deathTime;
    //private GreenfootSound shot_sfx;
    private GreenfootSound death_sfx = new GreenfootSound("enemy_ded.mp3");


    public AbstractProjectile(boolean fromPlayer, int lifespan, int rotationDeg, int speed, String ammo) { // lifespan in milliseconds
        this.fromPlayer = fromPlayer;
        this.lifespan = lifespan;
        this.rotationDeg = rotationDeg;
        this.speed = speed;

        //set image ammo type
        if(ammo.equals("pellet")){
            setImage(new GreenfootImage("pellet.png"));
            //shot_sfx = new GreenfootSound("pellet_shot.mp3");
        }else if(ammo.equals("fireball")){
            setImage(new GreenfootImage("fireball.png"));
            //shot_sfx = new GreenfootSound("fireball_shot.mp3");
        }

        if (getImage() != null)
            setRotation(this.rotationDeg);

        deathTime = System.currentTimeMillis() + lifespan;
    }

    public void act() {
        if (System.currentTimeMillis() >= deathTime) {
            getWorld().removeObject(this);
            return;
        }

        move(speed);

        if (fromPlayer) {
            if (isTouching(AbstractEnemy.class)) {
                Actor enemy = getOneIntersectingObject(AbstractEnemy.class);
                if (enemy != null)
                    death_sfx.setVolume(20);
                    death_sfx.play();
                    ((AbstractEnemy)enemy).kill();
            }
        }
        else {
            if (isTouching(Player.class)) {
                Actor player = getOneIntersectingObject(Player.class);
                if (player != null)
                    ((Player)player).kill();
            }
        }
    }
}
