package com.winfirst.space;

import com.winfirst.entity.EntityManager;
import com.winfirst.utils.Handler;

import java.awt.Color;
import java.awt.Graphics;

public class Board {

    private Handler handler;
    private EntityManager entityManager;

    public Board(Handler handler){
        this.handler = handler;
        this.entityManager = new EntityManager(handler);
        entityManager.addEntity(new Ship(handler, 50, 600, 64, 64, entityManager));
        for(int j = 1; j < 4; j++){
            for(int i = 1; i < 13; i++){
                entityManager.addEntity(new Alien(handler, i * 98, j * 100, 32, 26));
            }
        }

    }

    public void tick(){
        entityManager.tick();
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
        entityManager.render(g);
    }
}
