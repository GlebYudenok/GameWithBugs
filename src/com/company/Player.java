package com.company;

import sun.font.TextLabel;

import javax.swing.*;
import java.awt.*;

public class Player {
    private double x;
    private double y;
    private double w;
    private double h;
    private int speed;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    Image img = new ImageIcon("src\\com\\company\\cat.png").getImage();

    public Player(){
        x = 300;
        y = 300;
        w = 60;
        h = 60;
        up = false;
        down = false;
        left = false;
        right = false;
    }

    public Player(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        speed = 5;
        up = false;
        down = false;
        left = false;
        right = false;
    }

    public double getX() {
        return x;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void update(){

        if(up && y>0)
            y-=speed;
        if(down && y < Panel.HEIGHT-h)
            y+=speed;
        if(left && x > 0)
            x-=speed;
        if(right && x < Panel.WIDTH-w)
            x+=speed;
    }

    public void draw(Graphics2D g){
        g.drawImage(img,(int)x,(int)y,null);
    }
}