package com.winfirst.pong;

import com.winfirst.utils.Handler;

import java.awt.Graphics;

public class Board {

    private Ball b;
    private Paddle player1, player2;
    private Handler handler;

    public Board(Handler handler){
        this.handler = handler;
        this.b = new Ball(handler, 300, 300, 10);
        this.player1 = new Paddle(handler, 50, 300, 16, 40);
        this.player2 = new Paddle(handler, 950, 300, 16, 40);
    }

    public void tick(){
        b.tick();
        player1.tick();
        player2.tick();
    }

    public void render(Graphics g){
        b.render(g);
        player1.render(g);
        player2.render(g);
    }
}
