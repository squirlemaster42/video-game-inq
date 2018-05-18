package com.winfirst.pong;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Ball extends Entity {

    public Ball(Handler handler, float x, float y, int width) {
        super(handler, x, y, width, width);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int) x, (int) y, width, width);
    }
}
