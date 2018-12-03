
/**
 * Created by evdogg123 on 4/15/2018.
 * The GameObjects class is the base class for all objects in the game. It is never instantiated,
 * but defines the behavior of all of the
 */

public class GameObjects {
    // Super class for all players, obstacles, enemies, projectiles
    int health;
    int xPosition;
    int yPosition;
    int xVelocity;
    int yVelocity;
    // hitboxes are defined starting at the Game objects upper left corner. The first int is how many
    //spaces right and the next int is how many spaces down.
    int[] hitBox;

    //returns information regarding the objects location in the form of an array of int arrays
    // First array tells the objects cartesian coordinates, second array tells the hitboxes.
    int[] updatePosition(){
        int[] coords = new int[]{xPosition, yPosition};
        return coords;
    }

    //Returns the objects life status.
    boolean updateLifeStatus(){
        if (health > 0) {
            return true;
        }
        else return false;
    }
    void move(){
        // Updates the objects location
        xPosition = xPosition + xVelocity;
        yPosition = yPosition + yVelocity;
    }
    public void updateVelocity(int i){
        xVelocity = i;
    }

    void printStatus() {
        // Prints velocity and position of the GameObject
        System.out.printf("X Velocity: %s", xVelocity);
        System.out.println("");
        System.out.printf("Y Velocity: %s", yVelocity);
        System.out.println("");
        System.out.printf("X Position: %s", xPosition);
        System.out.println("");
        System.out.printf("Y Position: %s", yPosition);
        System.out.println("");
    }

}



