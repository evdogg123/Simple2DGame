

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;



/**
 * Created by evdogg123 on 5/17/2018.
 */

public class HUD extends JPanel {
    //Displays to the user the health, level, and level difficulty
    LevelBuilder level;
    int levelNum = 1;
    int levelDiff = 1;
    int playerHealth = 5;
    HUD(){
        setSize(1000,150);
        setLocation(0,850);
        setBackground(Color.LIGHT_GRAY);
        setOpaque(false);
        setLayout(null);
    }
    public void setLevelStats(LevelBuilder level){
        this.level = level;
        levelNum = level.getLevel();
        levelDiff = level.getDiff();
        playerHealth = level.player1.health;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        String strLevelNum = "Level: " + levelNum;
        String strLevelDiff = "Difficulty" + levelDiff;
        String strHealth = "Health" + playerHealth;
        g.drawString(strLevelNum, 0,900);
        g.drawString(strLevelDiff,0,920);
        g.drawString(strHealth,0,940);
    }
}