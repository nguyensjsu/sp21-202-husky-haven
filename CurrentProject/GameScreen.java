import greenfoot.*;
import java.util.*;

public class GameScreen extends AbstractScreen {
    
    private List<Actor> actors;
    
    
    public GameScreen(GameWorld world) {
        super(world, Color.BLUE);
        
        int centerX = world.WIDTH / 2;
        actors = Arrays.asList(
            new Button("End Game", centerX, 700, 300, 75) {
                public void onClick() {
                    world.setScreen(ScreenName.GAME_OVER);
                }
            }
        );
    }
    
    public void activate() {
        super.activate();
        System.out.println("GameScreen");
        
        world.setPaintOrder(Button.class);
        for (Actor actor : actors)
            world.addObject(actor, 0, 0);
    }
    
    public void act() {
        for (Actor actor : actors)
            if (Greenfoot.mouseClicked(actor))
                if (actor instanceof IClickable)
                    ((IClickable)actor).onClick();
    }
    
    public void clear() {
        world.removeObjects(actors);
    }
}
