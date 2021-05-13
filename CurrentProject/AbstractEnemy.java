public class AbstractEnemy extends AbstractSpawnable {
    
    public void wrap() {
        int x = getX();
        
        if (x > GameWorld.WIDTH)
            setLocation(10, getY());
        else if (x < 0)
            setLocation(GameWorld.WIDTH - 10, getY());
    }
    
    public void kill() {
        getWorld().removeObject(this);
    }
}
