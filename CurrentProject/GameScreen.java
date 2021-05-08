import greenfoot.*;
import java.util.*;

public class GameScreen extends AbstractScreen {
    
    private List<Actor> actors;
    Player player;
    
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
             player
             //new Button("End Game", centerX, 700, 300, 75) {
             //    public void onClick() {
             //        world.setScreen(ScreenName.GAME_OVER);
             //    }
             //}
        );
    }

    public void activate() {
        world.setPaintOrder(Player.class, Button.class);
        world.addObject(player, this.startX,this.startY);
        for (Actor actor : actors)
            world.addObject(actor, 0, 0);
        super.activate();
    }

    public void act() {
        if(player.y > 800) {
            //player.setLocation(-100,-100);
            world.removeObjects(actors);
            //player = new Player(true);
            world.setScreen(ScreenName.GAME_OVER);
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
