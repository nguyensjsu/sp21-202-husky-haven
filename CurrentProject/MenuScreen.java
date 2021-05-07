import greenfoot.*;
import java.util.*;

public class MenuScreen extends AbstractScreen {
    
    private List<Actor> actors;
    
    
    public MenuScreen(GameWorld world) {
        super(world, Color.GRAY);
        
        int centerX = world.WIDTH / 2;
        actors = Arrays.asList(
            new Button("Start Game", centerX, 600, 300, 75) {
                public void onClick() {
                    world.setScreen(ScreenName.GAME);
                }
            },
            new Button("Quit", centerX, 700, 300, 75) {
                public void onClick() {
                    Greenfoot.stop();
                }
            }
        );
    }
    
    public void act() {
        for (Actor actor : actors)
            if (Greenfoot.mouseClicked(actor))
                if (actor instanceof IClickable)
                    ((IClickable)actor).onClick();
    }
    
    public void activate() {
        super.activate();
        System.out.println("MenuScreen");
        
        world.setPaintOrder(Button.class);
        for (Actor actor : actors)
            world.addObject(actor, 0, 0);
    }
    
    public void clear() {
        world.removeObjects(actors);
    }
}
