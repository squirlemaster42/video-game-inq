package com.winfirst.tetris;

import java.awt.Graphics;
import java.awt.Color;
import java.utils.ArrayList;

public class Board {

    //Define pieces and rotations
    private static final int[][][][] pieces = new int[][][][]{
            {{{1, 1, 1}, {0, 1, 0}}, {{0, 1}, {1, 1}, {0, 1}}, {{0, 1, 0}, {1, 1, 1}}, {{1, 0}, {1, 1}, {1, 0}}},
            {{{1, 1, 1, 1}}, {{1}, {1}, {1}, {1}}},
            {{{1, 1}, {1, 1}}},
            {{{1, 1}, {1, 0}, {1, 0}}, {{1, 1, 1}, {0, 0, 1}}, {{0, 1}, {0, 1}, {1, 1}}, {{1, 0, 0}, {1, 1, 1}}},
            {{{1, 1}, {0, 1}, {0, 1}}, {{0, 0, 1}, {1, 1, 1}}, {{1, 0}, {1, 0}, {1, 1}}, {{1, 1, 1}, {1, 0, 0}}},
            {{{1, 0}, {1, 1}, {0, 1}}, {{0, 1, 1}, {1, 1, 0}}},
            {{{0, 1}, {1, 1}, {1, 0}}, {{1, 1, 0}, {0, 1, 1}}}
    };

    private ArrayList<Piece> pieceList;
    
    private static final int[][] board = new int[22][10];
    
    private Handler handler;
    

    public Board(Handler handler){
        this.handler = handler;
        piecesList = new ArrayList<>();
        pieceList.add(new Piece(handler, pieces[0], Colors.YELLOW));
        pieceList.add(new Piece(handler, pieces[1], Colors.ORANGE));
        pieceList.add(new Piece(handler, pieces[2], Colors.RED));
        pieceList.add(new Piece(handler, pieces[3], Colors.BLUE));
        pieceList.add(new Piece(handler, pieces[4], Colors.CYAN));
        pieceList.add(new Piece(handler, pieces[5], Colors.GREEN));
        pieceList.add(new Piece(handler, pieces[6], Colors.PURPLE));
        
    }

    public void tick(){
        pieceList.forEach(e -> e.tick());
    }

    public void render(Graphics g){
        pieceList.forEach(e -> e.render(g));
    }
}
