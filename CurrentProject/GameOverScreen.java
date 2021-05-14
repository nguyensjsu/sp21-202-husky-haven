import greenfoot.*;
import java.util.*;
//sound effects taken from https://mixkit.co/free-sound-effects/game-over/

public class GameOverScreen extends AbstractScreen {

    private List<Button> buttons;
    private ScoreDisplay lastScoreDisplay;
    private ScoreDisplay highScoreDisplay;
    private GreenfootSound gameOverBGM = new GreenfootSound("game_over_trombone.wav");


    public GameOverScreen(GameWorld world) {
        //super(world, Color.GRAY);
        super(world, new GreenfootImage("gameover.png"));

        int centerX = world.WIDTH / 2;
        buttons = Arrays.asList(
            new Button("Try Again", centerX, 600, 300, 75) {
                public void onClick() {
                    world.setScreen(ScreenName.GAME);
                }
            },
            new Button("Back to Menu", centerX, 700, 300, 75) {
                public void onClick() {
                    world.setScreen(ScreenName.MENU);
                }
            }
        );

        lastScoreDisplay = new ScoreDisplay("Final Score: ", 400, 300, 50);
        highScoreDisplay = new ScoreDisplay("High Score: ", 400, 50, 50);
    }

    public void activate() {
        super.activate();

        gameOverBGM.setVolume(30);
        gameOverBGM.play();

        world.setPaintOrder(ScoreDisplay.class, Button.class);

        lastScoreDisplay.updateScore(world.getLastScore());
        highScoreDisplay.updateScore(world.getHighScore());

        int centerX = world.WIDTH / 2;
        world.addObject(highScoreDisplay, world.WIDTH / 2, 200);
        world.addObject(lastScoreDisplay, world.WIDTH / 2, 300);

        for (Button button : buttons)
            world.addObject(button, 0, 0);


    }

    public void act() {
        for (Button button : buttons)
            if (Greenfoot.mouseClicked(button))
                button.onClick();
    }
}
