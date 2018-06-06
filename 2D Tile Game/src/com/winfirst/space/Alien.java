package com.winfirst.space;

import com.winfirst.entity.Entity;
import com.winfirst.entity.EntityManager;
import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Alien extends Entity {

    private double xMove;
    private int tickCounter = 0;
    private EntityManager entityManager;
    private Random rand;

    public Alien(Handler handler, float x, float y, int width, int height, EntityManager entityManager) {
        super(handler, x, y, width, height);
        this.entityManager = entityManager;
        this.rand = new Random();
    }

    @Override
    public void tick() {
        x += xMove;
        xMove = Math.sin(tickCounter / 30) * 3;
        tickCounter++;

        if(tickCounter % 60 == 0 && !entityBelow() && rand.nextInt(6) == 3){
            entityManager.addEntity(new Laser(handler, x + width / 2, y + height, 4, 10, -5, entityManager));
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
            if((Math.abs((int) entities.get(i).getX() - (int) x) < 10) && (entities.get(i) instanceof Alien)){
                return true;
            }
        }
        return false;
    }
}
