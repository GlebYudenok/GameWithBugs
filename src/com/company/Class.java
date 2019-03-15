package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Class {
    static private Image img;
    public static void main(String[] args) throws IOException {

        BufferedImage img = ImageIO.read(new File("src\\com\\company\\block.jpg"));

        System.out.println(img.getWidth());
    }
}