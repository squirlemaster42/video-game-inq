package com.winfirst.pong;

import com.winfirst.states.State;
import com.winfirst.utils.Handler;

import java.awt.Graphics;

public class PongState extends State {

    private Board board;

    public PongState(Handler handler) {
        super(handler);
        board = new Board(handler);
    }

    @Override
    public void tick() {
        board.tick();
    }

    @Override
    public void render(Graphics g) {
        board.render(g);
    }
}
