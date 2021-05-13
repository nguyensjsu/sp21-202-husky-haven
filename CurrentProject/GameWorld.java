import greenfoot.*;
import java.util.*;

public class GameWorld extends World {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    private AbstractScreen[] screenList;
    private AbstractScreen currentScreen;
    private ScreenName currentIndex;

    private int lastScore;
    private int highScore;

    public GameWorld() {
        super(WIDTH, HEIGHT, 1, false);

        screenList = new AbstractScreen[] {
            new MenuScreen(this),
            new GameScreen(this),
            new GameOverScreen(this)
        };

        lastScore = 0;
        highScore = 0;
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

    public void setLastScore(int score) {
        lastScore = score;
        if (score > highScore)
            highScore = score;
    }

    public int getHighScore() {
        return highScore;
    }

    public int getLastScore() {
        return lastScore;
    }
}
