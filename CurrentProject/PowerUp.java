import greenfoot.*;

public class PowerUp extends Actor{

	boolean hasBeenTaken;

	public PowerUp(){
		hasBeenTaken = false;
		setImage(new GreenfootImage("boost.png"));
	}

	public PowerUp(boolean taken){
		hasBeenTaken = true;
	}

	public void act(){
		//do nothing for now
	}

}
