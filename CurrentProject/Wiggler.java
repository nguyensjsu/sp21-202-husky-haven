import greenfoot.*;

public class Wiggler extends AbstractEnemy {

    private int range;
    private int startingX, startingY;

    public Wiggler(int range) {
        this.range = range;

        startingX = 0;
        startingY = 0;
    }

    public void act() {
        if (isOffScreen()) {
            kill();
            return;
        }

        wiggle();

        if (isTouching(Player.class)) {
            Actor player = getOneIntersectingObject(Player.class);
            if (player != null)
                ((Player)player).kill();
        }
    }

    public void scroll(int changeY) {
        startingY += changeY;
    }

    private void wiggle() {
        double angle = Math.random() * 2 * Math.PI;
        double hyp = Math.sqrt(Math.random()) * range;
        double shiftX = Math.cos(angle) * hyp;
        double shiftY = Math.sin(angle) * hyp;

        setLocation((int)(startingX + shiftX), (int)(startingY + shiftY));
    }

    protected void addedToWorld(World world) {
        startingX = getX();
        startingY = getY();
    }
}
