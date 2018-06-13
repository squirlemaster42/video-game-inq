package com.winfirst.pong;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Ball extends Entity {

    private int xMove, yMove, prevXMove, prevYMove;
    private Paddle[] paddles;
    private boolean runResetDraw = false;
    private int counter = 4;
    private int startTick = 0;
    private int totalTicks = 0;
    private static final int endScore = 5;
    private boolean gameWon = false;
    private int timePassed = 0;
    public Ball(Handler handler, float x, float y, int width, Paddle[] paddles) {
        super(handler, x, y, width, width);
        xMove = 6;
        yMove = 6;
        prevXMove = xMove;
        prevYMove = yMove;
        this.paddles = paddles;
    }

    @Override
    public void tick() {
        totalTicks++;
        move();
    }

    private void move(){
        x += xMove;
        y += yMove;

        if (x < 0){
            xMove *= -1;
            paddles[0].score++;
            if (isWon(paddles[0].score)) {
            	xMove = 0;
            	yMove = 0;
            	resetBall();
            }else{
                resetBall();
            }

        }

        if (x > handler.getGame().getWidth() - width){
            xMove *= -1;
            paddles[1].score++;
            if (isWon(paddles[1].score)) {
            	xMove = 0;
            	yMove = 0;
            	resetBall();
            }else{
                resetBall();
            }

            
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
        if(runResetDraw){
            if((totalTicks - startTick) % 60 == 0){
                System.out.println("here");
                counter--;
            }

            g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
            g.drawString(Integer.toString(counter), 685, 400);

            if(counter == 0){
                xMove = prevXMove;
                yMove = prevYMove;
                counter = 4;
                runResetDraw = false;
            }
        }

        if(isWon(paddles[0].score)){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
            g.drawString("Player 2 wins!", 685, 250);
            gameWon = true;
        }else if(isWon(paddles[1].score)){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
            g.drawString("Player 1 wins!", 685, 250);
            gameWon = true;
        }

        if(gameWon){
            timePassed++;
        }

        if(gameWon && timePassed >= 180){
            paddles[0].score = 0;
            paddles[1].score = 0;
            timePassed = 0;
            gameWon = false;
            xMove = 6;
            yMove = 6;
            resetBall();
            handler.getGame().setState(handler.getGame().getState("Menu"));
        }
    }

    private boolean isWon(int paddleScore) {
    	return paddleScore >= endScore;
    }
    

    private void resetBall(){
        x = 650;
        y = 350;
        prevXMove = xMove;
        prevYMove = yMove;
        xMove = 0;
        yMove = 0;
        startTick = totalTicks;
        runResetDraw = true;
    }
}
