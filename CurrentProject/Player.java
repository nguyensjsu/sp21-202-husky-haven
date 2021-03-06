import greenfoot.*;

public class Player extends Actor {

    private float GRAVITY = 0.15f;
    private final float MAX_SPEED = 5.0f;
    private final float X_ACCEL = 0.25f;
    private final long FIRE_RATE = 100;

    private float xSpeed = 0.0f, ySpeed = 0.0f;
    private int xLoc = 0, yLoc = 0;
    private boolean dead = false;
    private boolean collisionDeath = true;
    private int timer = 0;

    private GreenfootImage leftImage = new GreenfootImage("husky.png");
    private GreenfootImage rightImage = new GreenfootImage("husky.png");
    private GreenfootImage shootingImage = new GreenfootImage("husky.png");
    
    private GreenfootImage shieldLeftImage = new GreenfootImage("husky-shield.png");
    private GreenfootImage shieldRightImage = new GreenfootImage("husky-shield.png");
    private GreenfootImage shieldShootImage = new GreenfootImage("husky-shield.png");

    private AbstractShootingStrategy shootingStrategy;

    public Player(GameWorld world) {
        rightImage.mirrorHorizontally();
        shootingImage.scale(20, 40);
        
        shieldRightImage.mirrorHorizontally();
        shieldShootImage.scale(20, 40);

        setShootingStrategy(new DefaultShootingStrategy(world));
    }

    public void setShootingStrategy(AbstractShootingStrategy shootingStrategy) {
        this.shootingStrategy = shootingStrategy;
    }

    public boolean isDead() {
        return dead;
    }

    public void kill() {
        if(collisionDeath){
            dead = true;
        }
    }

    public void act() {
        xLoc = getX();
        yLoc = getY();

        handleInput();
        applyGravity();
        handleMovement();
        wrap();
        if(timer > -1)
            timer--;

        if(timer == 0){
            collisionDeath = true;
            setImage(rightImage);
        }

    }

    public boolean canBounce() {
        return ySpeed >= 0;
    }

    public void bounce(float force) {
        ySpeed = -force;
    }

    public void setGravity(float force) {
        GRAVITY = force;
    }

    public float getGravity(){
        return GRAVITY;
    }

    public void setCollisionDeath(){
        collisionDeath = false;
        timer = 500;
        setImage(shieldRightImage);
    }

    public boolean getCollisionDeath(){
        return collisionDeath;
    }

    private void handleInput() {
        boolean right = Greenfoot.isKeyDown("right");
        boolean left = Greenfoot.isKeyDown("left");
        boolean shooting = Greenfoot.isKeyDown("space");
        boolean pause = Greenfoot.isKeyDown("p");

        if (!(right ^ left))
            xSpeed = 0.0f;
        else if (right) {
            xSpeed = Math.min(xSpeed + X_ACCEL, MAX_SPEED);
            if (collisionDeath)
                setImage(rightImage);
            else
                setImage(shieldRightImage);
        }
        else { // left
            xSpeed = Math.max(xSpeed - X_ACCEL, -MAX_SPEED);
            if (collisionDeath)
                setImage(leftImage);
            else
                setImage(shieldLeftImage);
        }

        if (shooting) {
            shootingStrategy.fire(this, true);
            if (collisionDeath)
                setImage(shootingImage);
            else
                setImage(shieldShootImage);
        }

        if (pause)
            Greenfoot.stop();
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float speed) {
        ySpeed = speed;
    }

    private void applyGravity() {
        ySpeed += GRAVITY;
    }

    private void handleMovement() {
        setLocation((int)(xLoc + xSpeed), (int)(yLoc + ySpeed));
    }

    private void wrap() {
        if (xLoc > GameWorld.WIDTH)
            setLocation(10, yLoc);
        else if (xLoc < 0)
            setLocation(GameWorld.WIDTH - 10, yLoc);
    }
}
