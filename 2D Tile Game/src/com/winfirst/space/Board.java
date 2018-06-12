package com.winfirst.space;

import com.winfirst.entity.Entity;
import com.winfirst.entity.EntityManager;
import com.winfirst.utils.Handler;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Board {

    private Handler handler;
    private EntityManager entityManager;

    private boolean gameOver = false;
    private boolean gameWon = false;
    private int timePassed = 0;

    private long tickCounter = 0;

    public Board(Handler handler){
        this.handler = handler;
        this.entityManager = new EntityManager(handler);
        init();
    }

    private void init(){
        gameOver = false;
        gameWon = false;
        timePassed = 0;
        tickCounter = 0;
        entityManager.getEntities().removeAll(entityManager.getEntities());
        entityManager.addEntity(new Ship(handler, 50, 600, 64, 64, entityManager));
        for(int j = 1; j < 4; j++){ //4
            for(int i = 0; i < 12; i++){ //12
                entityManager.addEntity(new Alien(handler, i * 98, j * 100, 32, 26, entityManager));
            }
            System.out.println();
        }
    }

    public void tick(){
        entityManager.tick();

        if(!gameOver && !gameWon){
            tickCounter++;
        }else{
            timePassed++;
        }

        if (timePassed >= 180) {
            init();
            handler.getGame().setState(handler.getGame().getState("Menu"));
        }

        if(entityManager.getEntities().stream().noneMatch(Ship.class::isInstance)){
            gameOver = true;
        }else if(entityManager.getEntities().stream().noneMatch(Alien.class::isInstance)){
            gameWon = true;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
        g.setColor(Color.WHITE);
        g.drawString("Elapsed Time: " + tickCounter / 60 + " Seconds", 1100, 50);
        entityManager.render(g);

        g.setColor(Color.WHITE);
        if(gameOver){
            g.drawString("Game Over", 550, 350);
            g.drawString("You survived for: " + tickCounter / 60 + " Seconds", 550, 376);
        }else if(gameWon){
            g.drawString("You Win!", 550, 350);
            g.drawString("It took you " + tickCounter / 60 + " Seconds to complete the game!", 550, 376);
        }
    }
}
