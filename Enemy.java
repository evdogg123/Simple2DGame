



/**
 * Created by evdogg123 on 4/15/2018.
 */

public class Enemy extends GameObjects {
    //Enemy class creates enemy space ships that shoot projectiles at the player
    public Enemy(){
        xPosition = 0;
        yPosition = 0;
        xVelocity = 0;
        yVelocity = 0;
        health = 1;
        hitBox = new int[]{70,50};
    }
    public Enemy(int xPos, int yPos, int xVel, int yVel){
        xPosition = xPos;
        yPosition = yPos;
        xVelocity = xVel;
        yVelocity = yVel;
        health = 1;
        hitBox = new int[]{70, 50};

    }
    //health will decrease as it is hit with player projectiles
    @Override
    public boolean updateLifeStatus() {
        return super.updateLifeStatus();
    }

    //moves based on velocity
    @Override
    public int[] updatePosition() {
        return super.updatePosition();
    }

    //shoots a projectile
    public Projectile shoot(int speed){
        Projectile enemyProj = new Projectile(xPosition,yPosition,speed);
        return enemyProj;
    }

    @Override
    void printStatus() {
        super.printStatus();
        System.out.printf("Health: %s", health);
    }

    void move(){
        xPosition = xPosition + xVelocity;
        if(xPosition > 1000){
            xPosition = 0;
        } else if (xPosition < 0){
            xPosition = 1000;
        }
        yPosition = yPosition + yVelocity;
    }

}
