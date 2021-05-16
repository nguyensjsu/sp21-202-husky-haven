import greenfoot.*;
import java.util.*;

public class MenuScreen extends AbstractScreen {

    private List<Button> buttons;
    //private GreenfootSound menu_bgm = new GreenfootSound("game.mp3");
    private ScoreDisplay menu;

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

        menu = new ScoreDisplay("Husky Haven", 400, 300, 50, "menu");
    }

    public void activate() {
        super.activate();

        //menu_bgm.setVolume(30);
        //menu_bgm.playLoop();

        world.setPaintOrder(Button.class);
        world.addObject(menu, world.WIDTH / 2 + 50, 25);
        for (Button button : buttons)
            world.addObject(button, 0, 0);
    }

    public void act() {
        for (Button button : buttons)
            if (Greenfoot.mouseClicked(button))
                button.onClick();
    }
}
