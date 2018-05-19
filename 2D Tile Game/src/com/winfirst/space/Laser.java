package com.winfirst.space;

import com.winfirst.entity.Entity;
import com.winfirst.entity.EntityManager;
import com.winfirst.utils.Handler;

import java.awt.Color;
import java.awt.Graphics;

public class Laser extends Entity {

    private int xMove, yMove;
    private EntityManager entityManager;

    public Laser(Handler handler, float x, float y, int width, int height, EntityManager entityManager) {
        super(handler, x, y, width, height);
        this.entityManager = entityManager;
        xMove = 5;
        yMove = 5;
    }

    @Override
    public void tick() {
        y -= yMove;
        if(checkEntityCollision(0, yMove, entityManager)){
            entityManager.getEntities().remove(this);
            Entity collidedEntity = getCollideEntity(0, yMove, entityManager);
            entityManager.getEntities().remove(collidedEntity);

            if(collidedEntity instanceof Alien){

            }else if(collidedEntity instanceof Ship){

            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, width, height);
    }
}
