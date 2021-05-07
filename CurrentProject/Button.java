import greenfoot.*;

public abstract class Button extends Actor implements IClickable {
    
    private String displayName;
    private int xLoc, yLoc, width, height;
    private GreenfootImage background;
    
    
    public Button(String displayName, int xLoc, int yLoc, int width, int height) {
        this.displayName = displayName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.width = width;
        this.height = height;
        
        background = new GreenfootImage(width, height);
        background.setColor(new Color(11, 92, 12));
        background.fill();
        
        background.setFont(new Font(30)); 
        background.setColor(Color.WHITE);
        background.drawString(displayName, width / 2 - displayName.length() * 7, height / 2 + 10);
        setImage(background);
    }
    
    protected void addedToWorld(World world) {
        setLocation(xLoc, yLoc);
    }
    
    public abstract void onClick();
}