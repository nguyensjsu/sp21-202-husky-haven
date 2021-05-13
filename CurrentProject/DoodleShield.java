import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Shield the doodle from enemies
 */
public class DoodleShield extends AbstractPowerup
{
    public DoodleShield() {
    }

    public void applyPowerup(Player player) {
        player.setCollisionDeath();
    }
}
