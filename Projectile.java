


public class Projectile extends GameObjects {
    // Field for Projectiles that determines the projectile's behavior.
    public enum ProjectileType {
        PLAYER,ENEMY,POWER_UP;
    }
    ProjectileType type;
    //constructor for enemies; all projectiles move straight down from origin
    public Projectile(int x, int y, int speed){
        xVelocity = 0;
        yVelocity = speed;
        xPosition = x;
        yPosition = y;
        health = 1;
        type = ProjectileType.ENEMY;
        hitBox = new int[]{10,30};
    }

    //constructor for player; projectiles have a velocity straight up from origin
    public Projectile(int x, int y, ProjectileType projType){
        xVelocity = 0;
        yVelocity = -1;
        xPosition = x;
        yPosition = y;
        health = 1;
        type = projType;
        hitBox = new int[]{10,30};
    }


    @Override
    public boolean updateLifeStatus() {
        return super.updateLifeStatus();
    }

    @Override
    public int[] updatePosition() {
        return super.updatePosition();
    }

    public void move(){
        super.move();
        if(yPosition > 1000 || yPosition < 0){
            health = 0;
        }
    }
    public void printStatus(){
        super.printStatus();
        System.out.printf("Projectile Type: %s", type);
    }
}



