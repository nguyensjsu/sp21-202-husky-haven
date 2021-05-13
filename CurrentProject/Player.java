import greenfoot.*;

public class Player extends Actor {
    
    private final float GRAVITY = 0.15f;
    private final float MAX_SPEED = 5.0f;
    private final float X_ACCEL = 0.25f;
    private final long FIRE_RATE = 100;
    
    private float xSpeed = 0.0f, ySpeed = 0.0f;
    private int xLoc = 0, yLoc = 0;
    private boolean dead = false;
    
    private GreenfootImage leftImage = new GreenfootImage("doodler.png");
    private GreenfootImage rightImage = new GreenfootImage("doodler.png");
    private GreenfootImage shootingImage = new GreenfootImage("shooting.png");
    
    private AbstractShootingStrategy shootingStrategy;
    
    
    public Player(GameWorld world) {
        leftImage.mirrorHorizontally();
        shootingImage.scale(30, 40);
        
        setShootingStrategy(new DefaultShootingStrategy(world));
    }
    
    public void setShootingStrategy(AbstractShootingStrategy shootingStrategy) {
        this.shootingStrategy = shootingStrategy;
    }
    
    public boolean isDead() {
        return dead;
    }
    
    public void kill() {
        dead = true;
    }
    
    public void act() {
        xLoc = getX();
        yLoc = getY();
        
        handleInput();
        applyGravity();
        handleMovement();
        wrap();
    }
    
    public boolean canBounce() {
        return ySpeed >= 0;
    }
    
    public void bounce(float force) {
        ySpeed = -force;
    }
    
    private void handleInput() {
        boolean right = Greenfoot.isKeyDown("right");
        boolean left = Greenfoot.isKeyDown("left");
        boolean shooting = Greenfoot.isKeyDown("space");
        
        if (!(right ^ left))
            xSpeed = 0.0f;
        else if (right) {
            xSpeed = Math.min(xSpeed + X_ACCEL, MAX_SPEED);
            setImage(rightImage);
        }
        else { // left
            xSpeed = Math.max(xSpeed - X_ACCEL, -MAX_SPEED);
            setImage(leftImage);
        }
        
        if (shooting) {
            shootingStrategy.fire(this, true);
            setImage(shootingImage);
        }
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
