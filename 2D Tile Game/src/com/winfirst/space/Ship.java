package com.winfirst.space;

import com.winfirst.entity.Entity;
import com.winfirst.tile.Assets;
import com.winfirst.utils.Handler;

import java.awt.Graphics;

public class Ship extends Entity {

    public Ship(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.spaceShip, (int) x, (int) y, null);
    }
}