package com.winfirst.pacman.actor;

import com.winfirst.pacman.PacmanActor;
import com.winfirst.pacman.PacmanGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Food extends PacmanActor {
    
    private int col;
    private int row;
    
    public Food(PacmanGame game, int col, int row) {
        super(game);
        this.col = col;
        this.row = row;
    }

    @Override
    public void init() {
        loadFrames("/food.png");
        x = col * 8 + 3 - 32;
        y = (row + 3) * 8 + 3;
        collider = new Rectangle(0, 0, 2, 2);
    }

    @Override
    public void updatePlaying() {
        if (game.checkCollision(this, Pacman.class) != null) {
            visible = false;
            game.currentFoodCount--;
            game.addScore(10);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        if (!visible) {
            return;
        }
        g.setColor(Color.WHITE);
        g.fillRect((int) (x), (int) (y), 2, 2);
    }
    
    // broadcast messages

    @Override
    public void stateChanged() {
        if (game.getState() == PacmanGame.State.TITLE) {
            visible = false;
        }
        else if (game.getState() == PacmanGame.State.READY) {
            visible = true;
        }
    }

    public void hideAll() {
        visible = false;
    }
    
}
