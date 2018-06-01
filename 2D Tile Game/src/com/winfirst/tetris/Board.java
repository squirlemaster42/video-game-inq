package com.winfirst.tetris;

import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

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

    private Random random;

    private Queue<Piece> pieceQueue;
    
    private Piece activePiece = null;

    public Board(Handler handler){
        this.handler = handler;
        this.random = new Random();
        this.pieceQueue = new PriorityQueue<>();

        pieceList = new ArrayList<>();
        pieceList.add(new Piece(handler, pieces[0], Color.YELLOW));
        pieceList.add(new Piece(handler, pieces[1], Color.ORANGE));
        pieceList.add(new Piece(handler, pieces[2], Color.RED));
        pieceList.add(new Piece(handler, pieces[3], Color.BLUE));
        pieceList.add(new Piece(handler, pieces[4], Color.CYAN));
        pieceList.add(new Piece(handler, pieces[5], Color.GREEN));
        pieceList.add(new Piece(handler, pieces[6], Color.MAGENTA));
    }

    public void tick(){
        ArrayList<Integer> removedLines = new ArrayList<>();
        if(pieceQueue.size() < 4) {
            pieceQueue.add(pieceList.get(random.nextInt(pieceList.size())).clone());
        }
        
        if(activePiece == null){
            activePiece = pieceQueue.poll();
        }
        
        if(!canMoveDown(activePiece)){
            activePiece = null;
        }
           
        activePiece.tick();
           
        for(int i = 0; i < board.length; i++){
            int sum = 0;
            for(int j = 0; j < board[0].length; j++){
                sum += board[i][j];
            }
            
            if(sum == 10){
                for(int j = 0; j < board[0].length; j++){
                    board[i][j] = 0;
                }
                removedLines.add(i);
            }
        }
           
        for(int i = 0; i < removedLines.size(); i++){
            for(int j = removedLines.get(i); j > 0; j--){
                for(int k = 0; k < board[0].length; k++){
                    board[j][k] = board[j - 1][k];
                }
            }
        }
    }

    public void render(Graphics g){
        pieceList.forEach(e -> e.render(g));
    }
           
    private boolean canMoveDown(Piece piece){
        return true;
    }
           
    private int findRowWithFirstPiece(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(array[i][j] != 0){
                    return i;
                }
            }
        }
        return 0;
    }
}
