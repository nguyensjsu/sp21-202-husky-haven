import greenfoot.*;
import java.util.*;

public class MenuScreen extends AbstractScreen {
    
    private List<Button> buttons;
    
    public MenuScreen(GameWorld world) {
        super(world, new GreenfootImage("home.jpg"));
        
        int centerX = world.WIDTH / 2;
        buttons = Arrays.asList(
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
    
    public void activate() {
        super.activate();
        
        world.setPaintOrder(Button.class);
        for (Button button : buttons)
            world.addObject(button, 0, 0);
    }
    
    public void act() {
        for (Button button : buttons)
            if (Greenfoot.mouseClicked(button))
                button.onClick();
    }
}
