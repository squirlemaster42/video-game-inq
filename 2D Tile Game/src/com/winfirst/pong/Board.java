package com.winfirst.pong;

import com.winfirst.utils.Handler;

import java.awt.*;

public class Board {

    private Ball b;
    private Paddle player1, player2;
    private Handler handler;

    public Board(Handler handler){
        this.handler = handler;
        this.player1 = new Paddle(handler, 75, 300, 12, 60, 1);
        this.player2 = new Paddle(handler, 1200, 300, 12, 60, 2);
        Paddle[] paddles = {player1, player2};
        this.b = new Ball(handler, 600, 300, 14, paddles);
    }

    public void tick(){
        b.tick();
        player1.tick();
        player2.tick();
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
        b.render(g);
        player1.render(g);
        player2.render(g);

        //Draw score
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.drawString(Integer.toString(player1.score), 600, 45);
        g.fillRect(650, 10, 10, 20);
        g.fillRect(650, 40, 10, 20);
        g.drawString(Integer.toString(player2.score), 685, 45);
    }
}
