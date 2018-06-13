package com.winfirst.pacman;

import com.winfirst.states.State;
import com.winfirst.utils.Handler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

//Credit to leonardo-ono on GitHub for inspiration, and some code
//https://github.com/leonardo-ono/Java2DPacmanGame

public class PacmanState extends State {

    private PacmanGame game;

    public PacmanState(Handler handler) {
        super(handler);
        game = new PacmanGame(handler);
        game.init();
    }

    @Override
    public void tick() {
        update();
    }

    @Override
    public void render(Graphics g) {
        ((Graphics2D) g).setBackground(Color.BLACK);
        g.clearRect(0, 0, handler.getWidth(), handler.getHeight());
        ((Graphics2D) g).scale(game.screenScale.getX(), game.screenScale.getY());
        draw((Graphics2D) g);
        g.dispose();
    }

    public void update() {
        game.update();
    }

    public void draw(Graphics2D g) {
        game.draw(g);
    }
}
