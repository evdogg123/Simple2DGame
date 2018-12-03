


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Created by evdogg123 on 5/12/2018.
 */

public class GameWorld extends JPanel implements KeyListener {
    //Serves as the GUI for the game environment
    GameObjects[][] objectsArr;
    int numProj = 0;
    GameWorld() {
        setSize(1000, 850);
        setLayout(null);
        setBackground(Color.BLACK);  // Add starry night background!
    }


    public void doDrawing(Graphics g) {
        // Draws the Game objects to the Gameworld
        Graphics g2d = (Graphics2D) g;
        for (GameObjects[] objects : objectsArr) {
            for (GameObjects object : objects) {
                if (object != null) {
                    int xDim = object.hitBox[0];
                    int yDim = object.hitBox[1];
                    if (object.getClass().equals(Player.class)) {
                        g2d.setColor(Color.GREEN);
                        int[] xPositions = new int[]{object.xPosition + xDim / 2, object.xPosition, object.xPosition + xDim};
                        int[] yPositions = new int[]{object.yPosition, object.yPosition + yDim, object.yPosition + yDim};
                        g2d.fillPolygon(xPositions, yPositions, 3);
                    }
                    if (object.getClass().equals(Enemy.class)) {

                        int[] xPositions = new int[]{object.xPosition, object.xPosition + xDim, object.xPosition + xDim / 2};
                        int[] yPositions = new int[]{object.yPosition, object.yPosition, object.yPosition + yDim};
                        g2d.setColor(Color.RED);
                        g2d.fillPolygon(xPositions, yPositions, 3);
                    }
                    if (object.getClass().equals(Projectile.class)) {
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(object.xPosition, object.yPosition, xDim, yDim);
                    }
                    if (object.getClass().equals(Obstacle.class)) {
                        g2d.setColor(Color.GRAY);
                        g2d.fillRect(object.xPosition, object.yPosition,  xDim, yDim);
                    }
                }
            }
        }
    }

    public void setGameObjects(GameObjects[][] newObjects){
        objectsArr = newObjects;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int k = keyEvent.getKeyCode();
        if(k == (KeyEvent.VK_SPACE)){
            objectsArr[1][numProj] = new Projectile(objectsArr[0][0].xPosition,
                    objectsArr[0][0].yPosition, Projectile.ProjectileType.PLAYER);
            numProj++;
        } else if(k == KeyEvent.VK_RIGHT){
            objectsArr[0][0].updateVelocity(1);
        } else if(k == KeyEvent.VK_LEFT){
            objectsArr[0][0].updateVelocity(-1);
        }
    }
}









