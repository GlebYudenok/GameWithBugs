package com.company;

import javax.swing.*;
import java.awt.*;

public class Back {
    Image img;

    public void draw(Graphics2D g, String path){
        img = new ImageIcon(path).getImage();
        g.drawImage(img,(int)0,(int)0,null);
    }
}