import greenfoot.*;

public class ScoreDisplay extends Actor {

    private int width, height;
    private String prefix;
    private GreenfootImage scoreImage;


    public ScoreDisplay(String prefix, int width, int height, int fontSize) {
        this.prefix = prefix;
        this.width = width;
        this.height = height;

        scoreImage = new GreenfootImage(width, height);
        scoreImage.setFont(new Font(fontSize));
        scoreImage.setColor(Color.WHITE);
        updateScore(0);
    }

    public void updateScore(int heightScore) {
        scoreImage.clear();
        scoreImage.drawString(prefix + heightScore, 0, height * 3 / 4);
        setImage(scoreImage);
    }
}
