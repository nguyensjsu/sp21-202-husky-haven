# Husky Haven

## Project Topic
For our project, we decided to create a single-player game using the Java-based [Greenfoot engine](https://www.greenfoot.org/home). The game is an infinite vertical-scrolling platformer inspired by the mobile game [Doodle Jump](https://poki.com/en/g/doodle-jump).

## Group Members & Individual Contributions
* Nathan Diamond
    * Overall System Design
    * Implementation of GameWorld, Screens, Buttons, Spawners, Player, Shooting Strategies, Projectiles, Powerups (Fire Powerup), Enemies, Platforms (Platform, Ground Platform, Cloud Platform)
* Kevin Duong
    * Implementation of GameScreen, Player, Initial Platform, Feather Powerup, Balloon Powerup
    * Background Images, Husky model
    * One minute User story video 
* Benoit Yen
    * Implementation of initial Projectile classes, Wood Platform class
    * Addition of most sound effects (all platforms, all projectiles, enemy death) and background music (game bgm, gameover bgm)
    * Team Project presentation + demonstration video
* Deepak Vellore Karunamoorthy
   * Implementation of Power ups (Invinciblity) and enemies with images
   * Updated the Player to accomodate the invincibility power
* Vaibhav Jajodia
   * Implementation of Initial ground platform
   * PlatformFactory implementation was pending, spawner Factory Method for all actors finally chosen.
 
## Project Summary
Similar to the original Doodle Jump, the objective of our game is to bounce upward on randomly generated platforms in order to get as high as possible until the player either misses a platform (and falls off the screen) or collides with an enemy. During gameplay, the player character can be controlled in its horizontal movement via the left / right arrow keys and can fire projectiles upward by pressing or holding the spacebar. Every time the player character bounces from a platform and reaches the top of the screen, the screen and all of the other Actors will scroll vertically to simulate a continuous and infinite level. If a projectile fired by the player collides with an enemy, that enemy will be eliminated from the game and will no longer be a threat to the player. The player can also pick up powerups in the world that change how the player acts, such as making them temporarily invulnerable to enemies or upgrading their firepower.
<br/><br/>

---
## Project Architecture
### Complete Class Diagram
![CompleteClassDiagram](images/CompleteClassDiagram.png?raw=true)
The Greenfoot engine is fairly simplistic and the everything is based on interactions between subclasses of the built-in World and Actor classes. The World class is the world that all of the Actors "live" in and it controls how all of the components interact. The Actor class is an object that exists in the world and can be displayed on screen, which includes: buttons, text, characters, and environment objects. Because of this, most of the classes are derived at some point from the Actor class.

The intent of the overall architecture of the game was to encapsulate as much shared functionality as possible in the abstract components (e.g. AbstractProjectile, AbstractPowerup, etc.) in order to make it much easier to add new variations. The modularity of each of these abstract classes allowed us to quickly add new features and swap subclasses in and out without affecting the functionality of any other components in the system.
<br/><br/>

## Key Features
### Screens
Since Greenfoot is primarily based on the World and Actor classes, there's no built-in definition for different screens (like Scenes in the Unity engine). Therefore, we designed the GameWorld class (an extension of the World class) to handle transitioning between screens and to pass all user input and game logic on to the screens themselves. In this case, the GameWorld and screens sort of act as a state machine and states, respectively, in the State pattern. This allowed us to keep the non-game screens (MenuScreen and GameOverScreen) simple and to encapsulate all of the game logic in the GameScreen. The GameWorld class passes down `act()` method calls every frame to the current screen in a similar fashion to the Chain of Responsibility pattern, but with only one step.
<br/><br/>

### Projectiles & Shooting Strategies
We wanted the player character to be able to fire projectiles in different ways depending on powerups they've acquired, so the most obvious solution was to use the Strategy pattern. The default strategy fires individual Pellet projectiles one at a time vertically upward from the player. Once the player collides with the FirePowerup, the powerup applies a new shooting strategy to the player which allows them to fire 3 Fireball projectiles vertically upward in a spread. This feature could easily be expanded upon in the future by adding more projectiles and/or shooting strategies without needing to update any of the other classes.
<br/><br/>

### Spawners & Spawnables
One of the most important design considerations we had was how to progressively generate platforms, enemies, and powerups as the player character ascended to new heights. We also needed those objects to be removed from the game once they were off screen so that the game could run efficiently and not run out of memory if we had too many objects saved in the background. To do this, we had all of those objects (platforms, enemies, and powerups) extend the functionality of an AbstractSpawnable class that removes itself from the world once it's off screen. Then we made spawners for each of those spawnables that add randomized variants to the world at defined intervals as the player continually reaches the top of the screen. These spawners follow the Factory Method pattern with their `getRandomSpawnable()` methods for instantiating the various spawnables.
<br/><br/>

### Platforms
Our game has four kinds of platforms:
* Regular: The regular platform allows you to bounce with a medium height onto the next platform.
* Ground: The ground platform is the same as the regular platform but is spawned at the bottom of the starting screen only.
* Wood: The wood platform allows one very small bounce before it breaks and cannot be used again.
* Cloud: The cloud platform is also a one-use platform but allows a much larger bounce.
<br/><br/>

### Powerups
Our game has four powerups:
* Balloon Powerup: Husky rises like a baloon upon jumping on a platform for 5 seconds. (Removes gravity being applied and reduces the speed player rises for 5 amount of time)
* Feather Powerup: Husky floats like a feather for 5 seconds. (Reduces the gravity being applied to player for 5 amount of time)
* Fireball Powerup: Husky can kill the enemies by pressing the spacebar which will inject the fireballs in the gameworld.
* Invincibility Powerup: Shield the Husky from getting killed by the enemies for 5 seconds.
<br/><br/>

### Enemies
Our game has two enemies:
* Wiggler: The Wiggler jitters around randomly but does not move outside of its local area.
* Mover: The Mover traverses the screen horizontally (wrapping around when hitting the edge) at random speeds.
<br/><br/>

---
## Videos
### User Story Video
Our User Story Ad video can be found here: https://prezi.com/v/se7wcepe3s2i/doodle-jump-variation/

### Demo Video
Our Demo video can be found here: https://youtu.be/Y0hh7G4Jq5I

---
## Assets

* Feather Powerup - https://image.flaticon.com/icons/png/512/3013/3013230.png
* Home WallPaper - http://hdlatestwallpaper.com/wp-content/uploads/2017/07/Cartoon-garden-HD-wallpaper.jpg
* Husky (photoshopped to remove background image and resized) - https://cdn.imgbin.com/13/14/0/imgbin-siberian-husky-puppy-saarloos-wolfdog-drawing-mean-dog-black-and-white-dog-illustration-3h32g0sBAu2USPD8NG1y0Zx9Q.jpg
* Gameover Screen - https://www.pixilart.com/art/game-over-screen-ebcdb77d7128b3f
* Assorted SFX, Game BGM, and Gameover BGM - https://www.zapsplat.com/
