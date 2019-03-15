package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Windoor{

    Image img = new ImageIcon("src\\com\\company\\windoor.jpg").getImage();

    public void draw(Graphics2D g){
        g.drawImage(img,(int)900,(int)20,null);
    }
}