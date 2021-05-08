import greenfoot.*;
import java.util.*;

public class GameWorld extends World {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    private AbstractScreen[] screenList;
    private AbstractScreen currentScreen;
    private ScreenName currentIndex;


    int transparency = 0;
    int scrollSpeed;
    boolean scroll;
    boolean fall;
    boolean ended;

    int height = 0;
    int doodleX;
    
    int startX = 600;
    int startY = 50;

    public GameWorld() {
        super(WIDTH, HEIGHT, 1, false);
        screenList = new AbstractScreen[] {
            new MenuScreen(this),
            new GameScreen(this),
            new GameOverScreen(this)
        };

        setScreen(ScreenName.MENU);
    }

    public void act() {
        if (currentScreen != null)
            currentScreen.act();
    }

    public void setScreen(ScreenName newScreen) {
        if (currentIndex != null && currentIndex == newScreen)
            return;

        int index = newScreen.getIndex();
        if (index < 0 || index > screenList.length)
            return;

        if (currentScreen != null)
            currentScreen.clear();

        currentScreen = screenList[index];
        currentScreen.activate();
    }
}
