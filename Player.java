


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Created by evdogg123 on 4/15/2018.
 */

public class Player extends GameObjects {
    // User controlled class
    public Player(){
        xPosition = 450;
        yPosition = 750;
        xVelocity = 0;
        yVelocity = 0;
        health = 5;
        hitBox = new int[]{70,50};

    }

    @Override
    public boolean updateLifeStatus() {
        return super.updateLifeStatus();
    }

    @Override
    public int[] updatePosition() {
        return super.updatePosition();
    }


    public Projectile shoot(){
        // Creates and returns a projectile from the players position
        // yVelocity 5 is placeholder
        Projectile playerProj = new Projectile(xPosition,yPosition,Projectile.ProjectileType.PLAYER);
        return playerProj;
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
    }

}



