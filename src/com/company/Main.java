package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
            JFrame startFrame = new JFrame("game");//окно с названием
            startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startFrame.setLocation(0, 0);
            startFrame.setSize(1024, 630);
            startFrame.setResizable(false);
            startFrame.add(new Panel());
            startFrame.setVisible(true);
    }
}