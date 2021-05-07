import greenfoot.*;
import java.util.*;

public class GameOverScreen extends AbstractScreen {
    
    private List<Actor> actors;
    
    
    public GameOverScreen(GameWorld world) {
        super(world, Color.RED);
        
        int centerX = world.WIDTH / 2;
        actors = Arrays.asList(
            new Button("Reset", centerX, 700, 300, 75) {
                public void onClick() {
                    world.setScreen(ScreenName.MENU);
                }
            }
        );
    }
    
    public void activate() {
        super.activate();
        System.out.println("GameOverScreen");
        
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
