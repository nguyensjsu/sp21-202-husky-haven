import greenfoot.*;
import java.util.*;

public class GameScreen extends AbstractScreen {

    private final int START_X = 300;
    private final int START_Y = 450;
    private final int TOP_PADDING = 150;

    private AbstractSpawner[] spawners = null;
    private Player player;
    private ScoreDisplay scoreDisplay;
    private boolean isActive;
    private int scoreHeight;
    private GreenfootSound gameOverSound = new GreenfootSound("au.wav");

    public GameScreen(GameWorld world) {
        super(world, Color.GRAY);
    }

    public void activate() {
        super.activate();
        world.setPaintOrder(ScoreDisplay.class,
            Player.class,
            AbstractPowerup.class,
            AbstractProjectile.class,
            Platform.class,
            AbstractEnemy.class);

        scoreDisplay = new ScoreDisplay("Score: ", 150, 20, 20);
        world.addObject(scoreDisplay, 525, 770);

        isActive = true;
        scoreHeight = 0;

        player = new Player(world);
        world.addObject(player, START_X, START_Y);

        spawners = new AbstractSpawner[] {
            new PlatformSpawner(world),
            new EnemySpawner(world),
            new PowerupSpawner(world)
        };

        for (AbstractSpawner spawner : spawners)
            spawner.initialSpawn();
    }

    public void act() {
        int playerY = player.getY();
        if (playerY > world.HEIGHT || player.isDead())
            endGame();

        if (!isActive) {
            world.setLastScore(scoreHeight);
            gameOverSound.play();
            world.setScreen(ScreenName.GAME_OVER);
            return;
        }

        if (playerY < TOP_PADDING) {
            int changeY = TOP_PADDING - playerY;
            scoreHeight += changeY;
            scoreDisplay.updateScore(scoreHeight);
            scroll(changeY);
        }
    }

    private void scroll(int changeY) {
        player.setLocation(player.getX(), TOP_PADDING);

        for (AbstractSpawnable spawned : world.getObjects(AbstractSpawnable.class))
            spawned.scroll(changeY);

        if (spawners != null)
            for (AbstractSpawner spawner : spawners)
                spawner.scroll(changeY);
    }

    public void endGame() {
        isActive = false;
    }
}
