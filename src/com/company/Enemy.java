package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy extends Walls {

    public Enemy(double x, double y, double w, double h) {
        super(x, y, w, h);
        speed = 5;
    }

    public static void setCount(int count) {
        Enemy.count = count;
    }

    private static int count = 0;

    private int speed;

    public double getW() {
        return w - 20;
    }

    public double getH() {
        return h - 20;
    }

    public double getX() {
        return x + 10;
    }

    public double getY() {
        return y + 10;
    }

    public void update() {
        /*if(count == 0)
            y-= speed;
            if (y == 200) {
                count++;
                y+=speed;
            }

            if(count == 1){
                y+=speed;
            }

            if(y == 300){
                count = 0;
                y-=speed;
            }*/

        if(count == 0)
            x-= speed;
        if (x == 320) {
            count++;
            x+=speed;
        }

        if(count == 1){
            x+=speed;
        }

        if(x == 530){
            count = 0;
            x-=speed;
        }
    }
}
