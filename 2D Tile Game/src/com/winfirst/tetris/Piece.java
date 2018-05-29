package com.winfirst.tetris;

import com.winfirst.utils.Handler;

import java.awt.Color;
import java.awt.Graphics;

public class Piece {

    private Handler handler;
    private int row, col;
    private Color color;
    private int[][][] diagrams;
    private int[][] currentPiece;

    public Piece(Handler handler, int[][][] diagrams, Color color) {
        this.handler = handler;
        this.color = color;
        this.row = 3;
        this.col = 0;
        this.diagrams = diagrams;
        this.currentPiece = this.diagrams[0];
    }

    public void rotateClockwise(){

    }

    public void rotateCounterClockwise(){

    }

    public void tick() {

    }

    public void render(Graphics g) {

    }

    public int[][] currentPiece(){
        return currentPiece;
    }
}
