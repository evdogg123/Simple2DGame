
import java.util.Random;

/**
 * Created by evdogg123 on 4/15/2018.
 */

public class LevelBuilder {

    /**
     * Created by evdogg123 on 4/15/2018.
     */


        /* Level Builder creates and updates the user's game environment. It has two main fields,
        levelType and levelDiff. LevelType varies from 1 to 3, signifying three unique configurations
        of game objects and enemy behaviors. levelDiff starts at 0 and keeps growing until the game is over.
        As levelDiff increases, enemy projectile speeds increase, and other factors make the game
        more difficult.
         */

    Player player1 = new Player();
    int levelType = 1;
    int levelDiff = 1;
    int numProjE = 0;
    Projectile[] projArrP = new Projectile[1000];
    Projectile[] projArrE = new Projectile[1000];

    Enemy[] enemArr = new Enemy[15];
    Obstacle[] obsArr = new Obstacle[15];
    Player[] playerArr = new Player[]{player1};
    GameObjects[][] objectArr = new GameObjects[][]{playerArr,projArrP,enemArr,obsArr,projArrE};

    LevelBuilder(){
        int levelType = 1;
        int levelDiff = 0;

    }

    LevelBuilder(int type, int diff){
        levelType = type;
        levelDiff = diff;
    }
    public void setDifficulty(int round){
        levelDiff = round;
    }

    public void setLevel(int level) {
        levelType = level;
        if (level == 1) {
            Enemy enem1 = new Enemy(90,100,0,0);
            Enemy enem2 = new Enemy(270,100,0,0);
            Enemy enem3 = new Enemy(450,100,0,0);
            Enemy enem4 = new Enemy(630,100,0,0);
            Enemy enem5 = new Enemy(810,100,0,0);
            Enemy enem6 = new Enemy(90,250,0,0);
            Enemy enem7 = new Enemy(270,250,0,0);
            Enemy enem8 = new Enemy(450,250,0,0);
            Enemy enem9 = new Enemy(630,250,0,0);
            Enemy enem10 = new Enemy(810,250,0,0);

            enemArr[0] = enem1;enemArr[1]=enem2;enemArr[2]=enem3; enemArr[3] = enem4;
            enemArr[4] = enem5; enemArr[5] = enem6; enemArr[6] = enem7; enemArr[7] = enem8; enemArr[8] = enem9;
            enemArr[9] = enem10;

            Obstacle obs1 = new Obstacle(50,450,0,0,5,250,30);
            Obstacle obs2 = new Obstacle(370,450,0,0,5,250,30);
            Obstacle obs3 = new Obstacle(690,450,0,0,5,250,30);

            obsArr[0] = obs1; obsArr[1] = obs2; obsArr[2] = obs3;
        }
        if (level == 2) {
            Enemy enem1 = new Enemy(40,100,0,0);
            Enemy enem2 = new Enemy(180,100,0,0);
            Enemy enem3 = new Enemy(490,100,0,0);
            Enemy enem4 = new Enemy(660,100,0,0);
            Enemy enem5 = new Enemy(800,100,0,0);
            Enemy enem6 = new Enemy(110,200,0,0);
            Enemy enem7 = new Enemy(420,200,0,0);
            Enemy enem8 = new Enemy(730,200,0,0);
            Enemy enem9 = new Enemy(40,300,0,0);
            Enemy enem10 = new Enemy(180,300,0,0);
            Enemy enem11 = new Enemy(350,300,0,0);
            Enemy enem12 = new Enemy(490,300,0,0);
            Enemy enem13 = new Enemy(660,300,0,0);
            Enemy enem14 = new Enemy(800,300,0,0);
            enemArr[0] = enem1;enemArr[1]=enem2;enemArr[2]=enem3; enemArr[3] = enem4;
            enemArr[4] = enem5; enemArr[5] = enem6; enemArr[6] = enem7; enemArr[7] = enem8; enemArr[8] = enem9;
            enemArr[9] = enem10; enemArr[10] = enem11; enemArr[11] = enem12; enemArr[12] = enem13; enemArr[13] = enem14;
            Obstacle obs1 = new Obstacle(50,450,0,0,15,300,50);
            obsArr[0] = obs1;
        }
        if (level == 3){
            Enemy enem1 = new Enemy(90,100,1,0);
            Enemy enem2 = new Enemy(450,100,1,0);
            Enemy enem3 = new Enemy(810,100,1,0);
            Enemy enem4 = new Enemy(250,200,4,0);
            Enemy enem5 = new Enemy(600,200,4,0);
            Enemy enem6 = new Enemy(90,300,-1,0);
            Enemy enem7 = new Enemy(450,300,-1,0);
            Enemy enem8 = new Enemy(810,300,-1,0);
            Enemy enem9 = new Enemy(360,200,1,0);
            Enemy enem10 = new Enemy(480,100,-3,0);
            Enemy enem11 = new Enemy(660,300,3,0);
            enemArr[0] = enem1; enemArr[1] = enem2; enemArr[2] = enem3;
            enemArr[3] = enem4; enemArr[4] = enem5; enemArr[5] = enem6;
            enemArr[6] = enem7; enemArr[7] = enem8; enemArr[8] = enem9;
            enemArr[9] = enem10; enemArr[10] = enem11;

        }

    }

    public void eShoot(){
        Random rand = new Random();
        switch (levelType){
            case 1: int i = rand.nextInt(10);
                if(enemArr[i] != null){
                    projArrE[numProjE] = enemArr[i].shoot(levelDiff);
                }
            case 2: int j = rand.nextInt(14);
                if(enemArr[j] != null){
                    projArrE[numProjE] = enemArr[j].shoot(levelDiff);
                }
            case 3: int k = rand.nextInt(11);
                if(enemArr[k] != null){
                    projArrE[numProjE] = enemArr[k].shoot(levelDiff);
                }
        }
        numProjE++;
    }

    public int getLevel(){
        return levelType;
    }
    public int getDiff(){
        return levelDiff;
    }

    public boolean isGameOver() {
        if (player1.health <= 0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isWaveClear(){
        boolean enemyFound = false;
        for (Enemy enemies: enemArr){
            if (enemies != null) {
                if (enemies.health > 0) {
                    enemyFound = true;
                }
            }
        }
        // Checks that enemies are still alive for a given wave.
        boolean waveClear = !enemyFound;
        return waveClear;
    }
    public boolean testForCollision(GameObjects obj1, GameObjects obj2){
        //Checks to see if two GameObjects have collided.
        if(obj1==null||obj2==null){
            return false;
        }
        boolean collisionOccured = false;
        if(obj2.xPosition >= obj1.xPosition && obj2.xPosition <= obj1.xPosition+ obj1.hitBox[0]
                && obj2.yPosition <= obj1.yPosition+50 && obj2.yPosition >= obj1.yPosition){
            collisionOccured = true;
        }
        return collisionOccured;
    }

    public void boom(){
        //Calculates for collisions of relevant game objects
        for (int i =0; i<enemArr.length; i++){
            for(int j = 0; j<projArrP.length; j++){
                if(testForCollision(enemArr[i],projArrP[j])==true){
                    enemArr[i] = null;
                    projArrP[j] = null;
                }
            }
        }
        for (int i =0; i<playerArr.length; i++){
            for(int j = 0; j<projArrE.length; j++){
                if(testForCollision(projArrE[j],playerArr[i])==true){
                    playerArr[i].health--;
                    projArrE[j] = null;
                }
            }
        }
        for (int i =0; i<obsArr.length; i++){
            for(int j = 0; j<projArrP.length; j++){
                if(testForCollision(obsArr[i],projArrP[j])==true){
                    obsArr[i].health--;
                    if (obsArr[i].health == 0){
                        obsArr[i] = null;
                    }
                    projArrP[j] = null;
                }
            }
        }
    }

    public void tick(){
        // updates the Level based on velocity and positions of game objects.
        for (Projectile proj: projArrP){
            if (proj != null) {
                proj.move();
            }
        }
        for (Projectile proj: projArrE){
            if (proj != null) {
                proj.move();
            }
        }
        for (Obstacle obj: obsArr){
            if (obj != null) {
                obj.move();
            }
        }
        for (Enemy enem: enemArr){
            if (enem != null) {
                enem.move();
            }
        }
        player1.move();
    }
}