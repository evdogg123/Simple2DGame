




import java.util.EventListener;


/**
 * Created by evdogg123 on 4/15/2018.
 */

public class Game implements EventListener {
    SwingUI swingUI;
    LevelBuilder level;
    boolean isRunning = false;
    public Thread gameThread;

    Game() {
        swingUI = new SwingUI();
    }
    public void run(){
        while (isRunning == false){
            System.out.print("");
            if (swingUI.gameWorld != null){
                this.startGame();
                isRunning = true;
            }
        }
    }

    public void startGame() {
        //Start game serves as the game loop. Updates game logic and gui
        LevelBuilder level = new LevelBuilder();
        level.setLevel(1);
        int count = 0;
        while (level.isGameOver() == false) {
            while (level.isWaveClear() == false && level.isGameOver() == false) {

                if (count % 50 == 0) {
                    level.tick();
                }
                if (count == 5000) {
                    level.eShoot(); //Way of creating randomly shooting enemies
                    count = 0;
                }
                count++;
                swingUI.updateUI(level);
                level.boom();
                swingUI.gameWorld.requestFocus();
            }
            count = 0;
            if (level.getLevel() < 3) {
                level.setLevel(level.getLevel() + 1);
            } else {
                level.setDifficulty(level.getDiff() + 1);
                level.setLevel(1);
            }
            swingUI.updateUI(level);
        }
    }




    public static void main(String[] args) {
        Game game = new Game();
        game.run();

    }





}









