package com.company;

import java.awt.event.*;

public class Listeners implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            Player.up = true;
            Player.down = false;
            Player.right = false;
            Player.left = false;
        }
        if(key == KeyEvent.VK_S) {
            Player.down = true;
            Player.right = false;
            Player.left = false;
            Player.up = false;
        }
        if(key == KeyEvent.VK_D) {
            Player.right = true;
            Player.up = false;
            Player.down = false;
            Player.left = false;
        }
        if(key == KeyEvent.VK_A) {
            Player.left = true;
            Player.up = false;
            Player.down = false;
            Player.right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      /*  int key = e.getKeyCode();
        if(key == KeyEvent.VK_S)
            Player.down = false;
        if(key == KeyEvent.VK_W)
            Player.up = false;
        if(key == KeyEvent.VK_D)
            Player.right = false;
        if(key == KeyEvent.VK_A)
            Player.left = false;*/
    }
}