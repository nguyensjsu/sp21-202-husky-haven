import greenfoot.*;

public abstract class AbstractSpawnable extends Actor {
    
    public boolean isOffScreen() {
        return getY() > getImage().getHeight() / 2 + getWorld().getHeight();
    }
    
    public void scroll(int changeY) {
        setLocation(getX(), getY() + changeY);
    }
}
