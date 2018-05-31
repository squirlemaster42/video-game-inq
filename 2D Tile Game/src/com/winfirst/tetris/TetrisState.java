package com.winfirst.tetris;

import com.winfirst.states.State;
import com.winfirst.utils.Handler;

import java.awt.Graphics;

public class TetrisState extends State {

    private Board board;

    public TetrisState(Handler handler) {
        super(handler);

        this.board = new Board(handler);
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
