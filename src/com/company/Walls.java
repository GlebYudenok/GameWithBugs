package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Walls {
    protected double x;
    protected double y;
    protected double w;
    protected double h;

    public Image img;

    public Walls(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Walls(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Walls(){

    }

    public double getX() {
        return x;
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

    public void getImageW(String c) throws IOException {
        BufferedImage img = ImageIO.read(new File(c));
        w = img.getWidth();
    }

    public void getImageH(String c) throws IOException {
        BufferedImage img = ImageIO.read(new File(c));
        h = img.getHeight();
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public void setBlocks(String c){
        img = new ImageIcon(c).getImage();
    }

    public void draw(Graphics2D g){
        g.drawImage(img,(int)x,(int)y,null);
    }
}
