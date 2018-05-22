package com.winfirst.space;

import com.winfirst.entity.Entity;
import com.winfirst.entity.EntityManager;
import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.Graphics;

public class Ship extends Entity {

    private int xMove, yMove;
    private EntityManager entityManager;
    private int timeSinceLastShot = 0;

    public Ship(Handler handler, float x, float y, int width, int height, EntityManager entityManager) {
        super(handler, x, y, width, height);
        this.entityManager = entityManager;
        xMove = 5;
        yMove = 5;
    }

    @Override
    public void tick() {
        if (handler.getKeyManager().left && x > 0){
            x -= xMove;
        }else if(handler.getKeyManager().right && x < handler.getGame().getWidth() - width){
            x += xMove;
        }

        if(handler.getKeyManager().space && timeSinceLastShot > 20){
            entityManager.addEntity(new Laser(handler,(int) x + width / 2, (int) y - 10, 4, 10, entityManager));
            timeSinceLastShot = 0;
        }
        timeSinceLastShot++;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spaceShip, (int) x, (int) y, null);
    }
}
