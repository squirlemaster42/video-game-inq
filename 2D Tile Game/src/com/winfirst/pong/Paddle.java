package com.winfirst.pong;

import com.winfirst.entity.Entity;
import com.winfirst.utils.Handler;

import java.awt.*;

public class Paddle extends Entity {

    public int score;
    private int playerNum;

    public Paddle(Handler handler, float x, float y, int width, int height, int playerNum) {
        super(handler, x, y, width, height);
        this.playerNum = playerNum;
    }

    @Override
    public void tick() {
        if(playerNum == 1){
            if(handler.getKeyManager().p1Up && y > 0){
                y -= 5;
            }else if(handler.getKeyManager().p1Down && y < handler.getGame().getHeight() - height){
                y += 5;
            }
        }else if(playerNum == 2){
            if(handler.getKeyManager().p2Up && y > 0){
                y -= 5;
            }else if(handler.getKeyManager().p2Down && y < handler.getGame().getHeight() - height){
                y += 5;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, width, height);
    }
}
