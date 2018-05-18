package com.winfirst.pong;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Ball extends Entity {

    private int xMove, yMove;
    private Paddle[] paddles;

    public Ball(Handler handler, float x, float y, int width, Paddle[] paddles) {
        super(handler, x, y, width, width);
        xMove = 5;
        yMove = 5;
        this.paddles = paddles;
    }

    @Override
    public void tick() {
        move();
    }

    private void move(){
        //TODO Reset ball
        x += xMove;
        y += yMove;

        if (x < 0){
            xMove *= -1;
            paddles[0].score++;
            resetBall();
        }

        if (x > handler.getGame().getWidth() - width){
            xMove *= -1;
            paddles[1].score++;
            resetBall();
        }

        if ((y < 0) || (y > handler.getGame().getHeight() - width)){
            yMove *= -1;
        }

        if(checkEntityCollision(xMove, 0, paddles)){
            xMove *= -1;
        }

        if(checkEntityCollision(0, yMove, paddles)){
            yMove *= -1;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, width, width);
    }

    private void resetBall(){
        x = 600;
        y = 300;
    }
}
