import greenfoot.*;

public class Mover extends AbstractEnemy {
    
    private float speed;
    
    
    public Mover(float speed) {
        this.speed = speed;
        if (speed < 0)
            getImage().mirrorHorizontally();
    }
    
    public void act() {
        if (isOffScreen()) {
            kill();
            return;
        }
        
        moveSideways();
        wrap();
        
        if (isTouching(Player.class)) {
            Actor player = getOneIntersectingObject(Player.class);
            if (player != null)
                ((Player)player).kill();
        }
    }
    
    private void moveSideways() {
        setLocation((int)(getX() + speed), getY());
    }
}
