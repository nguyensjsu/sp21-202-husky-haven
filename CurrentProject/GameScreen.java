import greenfoot.*;
import java.util.*;

public class GameScreen extends AbstractScreen {

    private List<Actor> actors;
    Player player;
    Enemy enemy;

    int transparency = 0;
    int scrollSpeed;
    boolean scroll;
    boolean fall;
    boolean ended;

    int height = 0;
    int doodleX;

    int startX = 600;
    int startY = 50;

    public GameScreen(GameWorld world) {
        super(world, Color.BLUE);
        int centerX = world.WIDTH / 2;
        player = new Player(true, this);
        actors = Arrays.asList(
            player,
            new ground(false,this)
        );
    }

    public void activate() {
        world.setPaintOrder(Player.class, Button.class);
        world.addObject(player, this.startX,this.startY);

        //temp powerup additions for initial game screen
        //need score to generate after certain height
        world.addObject(new PowerUp(), world.WIDTH/2 + 100, world.HEIGHT/2 + 100);
        world.addObject(new PowerUp(), world.WIDTH/2 - 100, world.HEIGHT/2 - 100);

        world.addObject(actors.get(0), 0, 0);
        int groundNum = 15;
        for( int x = 1; x < actors.size(); x++) {
            world.addObject(actors.get(x),0 + (55 * x), world.HEIGHT);
        }

        super.activate();
    }

    public void act() {
        if(player.y > 800) {
            player.ys = 0;
            player.xs = 0;
            world.removeObjects(actors);
            world.setScreen(ScreenName.GAME_OVER);
        }
        if(player.y % 100 == 0){
            enemy = new Enemy(this, world);
            world.addObject(enemy, 0, player.y + Greenfoot.getRandomNumber(400));
        }

        for (Actor actor : actors)
            if (Greenfoot.mouseClicked(actor))
                if (actor instanceof IClickable)
                    ((IClickable)actor).onClick();
    }

    public void clear() {
        world.removeObjects(actors);
    }
}
