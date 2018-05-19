package com.winfirst.space;

import com.winfirst.entity.EntityManager;
import com.winfirst.utils.Handler;

import java.awt.Graphics;

public class Board {

    private Handler handler;
    private EntityManager entityManager;

    public Board(Handler handler){
        this.handler = handler;
        this.entityManager = new EntityManager(handler);
        entityManager.addEntity(new Ship(handler, 50, 50, 64, 64));
    }

    public void tick(){
        entityManager.tick();
    }

    public void render(Graphics g){
        entityManager.render(g);
    }
}
