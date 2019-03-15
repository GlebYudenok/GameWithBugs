package com.company;

import com.sun.xml.internal.ws.addressing.W3CAddressingConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLOutput;

public class Panel extends JPanel implements ActionListener {
    public static int WIDTH = 1024;
    public static int HEIGHT = 700;

    public static String path = "src\\com\\company\\back.jpg";

    public static String PUTIN[];
    private boolean es = true;

    public static enum STATES{MENU,PLAY,WIN,LOSE}
    public static STATES state = STATES.PLAY;

    private BufferedImage img;
    private Graphics2D g;

    private Button playAgain;

    Timer MyTimer = new Timer(30,this); //интервал обновления событий
    Back back = new Back();
    Player player = new Player(40,40,60,60);
    Windoor win = new Windoor();

    Walls w = new Walls(70,320);
    Walls w1 = new Walls(90,15);
    Walls w2 = new Walls(200,75);
    Walls w3 = new Walls(310,15);
    Walls w4 = new Walls(70,340);
    Walls w5 = new Walls(70,490);
    Walls w6 = new Walls(370,485);
    Walls w7 = new Walls(560,485);
    Walls w8 = new Walls(695,485);
    Walls w9 = new Walls(895,235);
    Walls w10 = new Walls(885,15);
    Walls w11 = new Walls(650,110);
    Walls w12 = new Walls(180,425);
    Walls w13 = new Walls(580, 235);
    Walls w14 = new Walls(445,190);
    Walls w15 = new Walls(320,140);
    Walls w16 = new Walls(750, 110);
    Enemy enemy = new Enemy(500,325,30,30);

    public Panel(){
        super();
        setFocusable(true);//передаем фокус
        requestFocus();//активируем
        MyTimer.start();
        img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);//объект для хранения картинок
        g = (Graphics2D) img.getGraphics();
        addKeyListener(new Listeners());

        playAgain = new Button("Try again");
        playAgain.setSize(new Dimension(200,100));
        playAgain.setForeground(Color.MAGENTA);
        playAgain.setBackground(Color.PINK);
        playAgain.setFont(new Font("Arial", Font.PLAIN, 35));
        playAgain.setLocation(420,400);
    }

    int count = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == playAgain.getLabel()){
            state = STATES.PLAY;
            restart();
            count=0;
        }

        if(state == STATES.WIN){
            path = "src\\com\\company\\win.jpg";
            back.draw(g,path);
            playAgain.setVisible(true);
            playAgain.addActionListener(this);
            playAgain.setSize(new Dimension(230,100));
            playAgain.setForeground(Color.MAGENTA);
            playAgain.setLabel("Игать еще раз");
            playAgain.setBackground(Color.PINK);
            playAgain.setLocation(400,400);
            if(count==0){
               add(playAgain);
               count++;
            }
            gameDraw();
        }

        if (state == STATES.MENU) {
            path = "src\\com\\company\\menu.jpg";
            back.draw(g,path);
            gameDraw();
        }

        if(state == STATES.LOSE){
            path = "src\\com\\company\\menu.jpg";
            back.draw(g,path);
            playAgain.setForeground(Color.RED);
            playAgain.setBackground(Color.BLUE);
            playAgain.setLocation(420,470);
            playAgain.setVisible(true);
            playAgain.addActionListener(this);
            if(count==0){
                add(playAgain);
                count++;
            }
            gameDraw();
        }

        if (state == STATES.PLAY) {
            playAgain.setVisible(false);
            path = "src\\com\\company\\back.jpg";
            gameUpdate();

            back.draw(g,path);
            PUTIN = new String[10];

            PUTIN[0] = "src\\com\\company\\block.jpg";
            PUTIN[1] = "src/com/company/block1.jpg";
            PUTIN[2] = "src/com/company/block2.jpg";
            PUTIN[3] = "src/com/company/block3.jpg";
            PUTIN[4] = "src/com/company/block4.jpg";
            PUTIN[5] = "src/com/company/enemy.png";

            try {
                if(es == true) { //чтобы 1 раз загружать картинку
                    w.getImageH(PUTIN[0]);
                    w.getImageW(PUTIN[0]);
                    w1.getImageH(PUTIN[1]);
                    w1.getImageW(PUTIN[1]);
                    w2.getImageH(PUTIN[1]);
                    w2.getImageW(PUTIN[1]);
                    w3.getImageH(PUTIN[1]);
                    w3.getImageW(PUTIN[1]);
                    w4.getImageH(PUTIN[2]);
                    w4.getImageW(PUTIN[2]);
                    w5.getImageH(PUTIN[0]);
                    w5.getImageW(PUTIN[0]);
                    w6.getImageH(PUTIN[0]);
                    w6.getImageW(PUTIN[0]);
                    w7.getImageH(PUTIN[0]);
                    w7.getImageW(PUTIN[0]);
                    w8.getImageH(PUTIN[0]);
                    w8.getImageW(PUTIN[0]);
                    w9.getImageH(PUTIN[1]);
                    w9.getImageW(PUTIN[1]);
                    w10.getImageH(PUTIN[3]);
                    w10.getImageW(PUTIN[3]);
                    w11.getImageH(PUTIN[0]);
                    w11.getImageW(PUTIN[0]);
                    w12.getImageH(PUTIN[4]);
                    w12.getImageW(PUTIN[4]);
                    w13.getImageW(PUTIN[1]);
                    w13.getImageW(PUTIN[1]);
                    w14.getImageW(PUTIN[1]);
                    w14.getImageW(PUTIN[1]);
                    w15.getImageH(PUTIN[0]);
                    w15.getImageW(PUTIN[0]);
                    w16.getImageH(PUTIN[1]);
                    w16.getImageW(PUTIN[1]);
                    enemy.getImageW(PUTIN[5]);
                    enemy.getImageW(PUTIN[5]);

                    es = false;
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            w.setBlocks(PUTIN[0]);
            w1.setBlocks(PUTIN[1]);
            w2.setBlocks(PUTIN[1]);
            w3.setBlocks(PUTIN[1]);
            w4.setBlocks(PUTIN[2]);
            w5.setBlocks(PUTIN[0]);
            w6.setBlocks(PUTIN[0]);
            w7.setBlocks(PUTIN[0]);
            w8.setBlocks(PUTIN[0]);
            w9.setBlocks(PUTIN[1]);
            w10.setBlocks(PUTIN[3]);
            w11.setBlocks(PUTIN[0]);
            w12.setBlocks(PUTIN[4]);
            w13.setBlocks(PUTIN[1]);
            w14.setBlocks(PUTIN[1]);
            w15.setBlocks(PUTIN[0]);
            w16.setBlocks(PUTIN[1]);
            enemy.setBlocks(PUTIN[5]);

            w.draw(g);
            w1.draw(g);
            w2.draw(g);
            w3.draw(g);
            w4.draw(g);
            w5.draw(g);
            w6.draw(g);
            w7.draw(g);
            w8.draw(g);
            w9.draw(g);
            w10.draw(g);
            w11.draw(g);
            w12.draw(g);
            w13.draw(g);
            w14.draw(g);
            w15.draw(g);
           // w16.draw(g);
            enemy.draw(g);

            player.draw(g);
            win.draw(g);

            gameDraw();
            if (player.getX() < 30 || player.getX() > 1100 || player.getY() < 30 || player.getY() > 550) {
                state = STATES.LOSE;
                System.out.println("Gay OVer");
            }

            if(player.getX() > 860 && player.getY() < 120){
                state = STATES.WIN;
            }

            try {
                    if (touch(PUTIN[0], w) == true || touch(PUTIN[1], w1) == true
                    || touch(PUTIN[1], w2) == true || touch(PUTIN[1], w3) == true
                    || touch(PUTIN[2], w4) == true || touch(PUTIN[0], w5) == true
                    || touch(PUTIN[0], w6) == true  || touch(PUTIN[0], w16) == true
                    || touch(PUTIN[0], w8) == true || touch(PUTIN[1], w9) == true
                    || touch(PUTIN[3], w10) == true || touch(PUTIN[0], w11) == true
                    || touch(PUTIN[4], w12) == true || touch(PUTIN[5], enemy) == true) {
                        state = STATES.LOSE;
                    }
                } catch(IOException e1){
                    e1.printStackTrace();
            }
        }
    }

    public boolean touch(String PUTIN, Walls w) throws IOException {

           if ((player.getY() > w.getY() - 30) && (player.getX() > w.getX() - 30) &&
                   (player.getY() < w.getY() + w.getH()) && player.getX() < w.getX() + w.getW()) {
               System.out.println(w.getX() + " " + w.getY() + " " + w.getW() + " " + w.getH() + "\n");
               System.out.println(player.getX() + " " + player.getY());
               return true;
           } else {
               return false;
           }


       /* if ((player.getY() + 35 > w.getY()) && (player.getX() > w.getX() - 30) &&
                (player.getY() < w.getY() + w.getH() + 5) && player.getX() < w.getX() + w.getW() + 5) {
            System.out.println(w.getX() + " " + w.getY() + " " + w.getW() + " " + w.getH() + "\n");
            System.out.println(player.getX() + " " + player.getY());
            return true;
        } else {
            return false;
        }*/
    }

    public void gameUpdate(){
        player.update();
        enemy.update();
    }

    public void gameDraw(){
        Graphics g2 = this.getGraphics(); //переопределяет graphics2d на graphics
        g2.drawImage(img,0,0,null);
        g2.dispose();//команда для уборщика мусора
    }

    public void restart(){
        path = "src/com/company/back.jpg";
        back.draw(g,path);
        player.draw(g);

        player.setY(40);
        player.setX(40);

      /* player.setX(400);
       player.setY(200);*/

       enemy.setX(500);
       enemy.setY(330);
       enemy.setCount(0);
        Player.up = false;
        Player.down = false;
        Player.right = false;
        Player.left = false;
    }
}