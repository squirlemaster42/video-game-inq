package com.winfirst.space;

import com.winfirst.entity.Entity;
import com.winfirst.entity.EntityManager;
import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.util.ArrayList;

public class Alien extends Entity {

    private double xMove;
    private int tickCounter = 0;
    private EntityManager entityManager;

    public Alien(Handler handler, float x, float y, int width, int height, EntityManager entityManager) {
        super(handler, x, y, width, height);
        this.entityManager = entityManager;
    }

    @Override
    public void tick() {
        x += xMove;
        xMove = Math.sin(tickCounter / 30) * 3;
        tickCounter++;

        if(!entityBelow() && tickCounter % 60 == 0){
            entityManager.addEntity(new Laser(handler, x + width / 2, y + 50, 4, 10, -5, entityManager));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.alien, (int) x, (int) y, null);
    }

    private boolean entityBelow(){
        ArrayList<Entity> entities = entityManager.getEntities();
        int indexOfThis = entities.indexOf(this);

        for(int i  = indexOfThis + 1; i < entities.size(); i++){
            if(entities.get(i).getX() == x && entities.get(i) instanceof Alien){
                return true;
            }
        }
        return false;
    }
}
