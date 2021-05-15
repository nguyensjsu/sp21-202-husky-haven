import greenfoot.*;

public class ScoreDisplay extends Actor {

    private int width, height;
    private String prefix;
    private GreenfootImage scoreImage;
    private String screen_name;


    public ScoreDisplay(String prefix, int width, int height, int fontSize, String screen) {
        this.prefix = prefix;
        this.width = width;
        this.height = height;
        this.screen_name = screen;

        scoreImage = new GreenfootImage(width, height);
        scoreImage.setFont(new Font(fontSize));
        if(screen.equals("gameover") || screen.equals("game"))
            scoreImage.setColor(Color.WHITE);
        else
            scoreImage.setColor(Color.GREEN);
        updateScore(0);
    }

    public void updateScore(int heightScore) {
        scoreImage.clear();
        if(screen_name.equals("gameover") || screen_name.equals("game"))
            scoreImage.drawString(prefix + heightScore, 0, height * 3 / 4);
        else
            scoreImage.drawString(prefix, 0, height * 3 / 4);
        setImage(scoreImage);
    }
}
