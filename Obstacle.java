

/**
 * Created by evdogg123 on 4/15/2018.
 */

public class Obstacle extends GameObjects {
    //Obstacles are Game objects that must be destroyed by the user to hit enemies
    public Obstacle(int x, int y, int vX, int vY, int h, int w, int ht){
        xPosition = x;
        yPosition = y;
        xVelocity = vX;
        yVelocity = vY;
        health = h;
        hitBox = new int[]{w,ht};
    }

    @Override
    public boolean updateLifeStatus() {
        return super.updateLifeStatus();
    }

    @Override
    public int[] updatePosition() {
        return super.updatePosition();
    }

    @Override
    void printStatus() {
        super.printStatus();
        System.out.printf("Health: %s", health);
    }

}



