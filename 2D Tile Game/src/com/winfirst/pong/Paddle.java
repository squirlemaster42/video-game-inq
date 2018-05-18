package com.winfirst.pong;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Paddle extends Entity {

    private int score;

    public Paddle(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) x, (int) y, width, height);
    }
}
