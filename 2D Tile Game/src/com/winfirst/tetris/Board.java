package com.winfirst.tetris;

import com.winfirst.utils.Handler;

import java.awt.Graphics;
import java.awt.Color;
import java.util.*;

public class Board {

    //Drawing constants
    private static final int singleTileWidth = 32;
    private static final int singleTileHeight = 32;

    //Define pieces and rotations
    private static final int[][][][] pieces = new int[][][][]{
            //T
            {{{1, 1, 1}, {0, 1, 0}}, {{0, 1}, {1, 1}, {0, 1}}, {{0, 1, 0}, {1, 1, 1}}, {{1, 0}, {1, 1}, {1, 0}}},
            //Straight Piece
            {{{1, 1, 1, 1}}, {{1}, {1}, {1}, {1}}},
            //Square
            {{{1, 1}, {1, 1}}},
            //J
            {{{1, 1}, {1, 0}, {1, 0}}, {{1, 1, 1}, {0, 0, 1}}, {{0, 1}, {0, 1}, {1, 1}}, {{1, 0, 0}, {1, 1, 1}}},
            //L
            {{{1, 1}, {0, 1}, {0, 1}}, {{0, 0, 1}, {1, 1, 1}}, {{1, 0}, {1, 0}, {1, 1}}, {{1, 1, 1}, {1, 0, 0}}},
            //Z
            {{{1, 0}, {1, 1}, {0, 1}}, {{0, 1, 1}, {1, 1, 0}}},
            //S
            {{{0, 1}, {1, 1}, {1, 0}}, {{1, 1, 0}, {0, 1, 1}}}
    };

    private ArrayList<Piece> pieceList;
    
    private static final int[][] board = new int[22][10];

    private Handler handler;

    private Random random;

    private Queue<Piece> pieceQueue;

    private Piece activePiece = null;

    private long totalTicks = 0;

    private boolean rightPressed = false;
    private boolean leftPressed = false;

    Board(Handler handler){
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
        totalTicks++;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 1){
                    board[i][j] = 0;
                }
            }
        }

        ArrayList<Integer> removedLines = new ArrayList<>();

        //Adding new pieces
        if(pieceQueue.size() < 4) {
            try {
                pieceQueue.add(pieceList.get(random.nextInt(pieceList.size())).clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        if(activePiece == null){
            activePiece = pieceQueue.poll();
        }

        System.out.println(activePiece.toString());
        System.out.println(Arrays.deepToString(board));

        //Add piece to board
        assert activePiece != null;
        for(int i = 0; i < activePiece.getCurrentPiece().length; i++){
            for(int j = 0; j < activePiece.getCurrentPiece()[0].length; j++){
                board[activePiece.getRow() + i][activePiece.getCol() + j] = activePiece.getCurrentPiece()[i][j];
            }
        }

        //Moving piece left and right
        if(handler.getKeyManager().right && !rightPressed && !(activePiece.getRow() + activePiece.getCurrentPiece()[0].length == 10)){
            activePiece.moveRight();
            rightPressed = true;
        }else if(handler.getKeyManager().left && !leftPressed && !(activePiece.getRow() == 0)){
            activePiece.moveLeft();
            leftPressed = true;
        }else if(handler.getKeyManager().down && canMoveDown(activePiece)){
            activePiece.moveDown();
        }

        if(!handler.getKeyManager().right){
            rightPressed = false;
        }

        if(!handler.getKeyManager().left){
            leftPressed = false;
        }
        
        //Moves piece down
        assert activePiece != null;
        if(canMoveDown(activePiece)){
            if(totalTicks % 60 == 0){
                activePiece.moveDown();
            }

        }else{
            for(int i = 0; i < activePiece.getCurrentPiece().length; i++){
                for(int j = 0; j < activePiece.getCurrentPiece()[0].length; j++){
                    board[activePiece.getRow() + i][activePiece.getCol() + j] = activePiece.getCurrentPiece()[i][j] + 1;
                }
            }
            activePiece = null;
        }

        //Removing completed lines
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
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());

        g.setColor(Color.WHITE);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 1 || board[i][j] == 2){
                    g.fillRect(i * singleTileWidth, j * singleTileHeight, singleTileWidth, singleTileHeight);
                }
            }
        }
    }
           
    private boolean canMoveDown(Piece piece){
        ArrayList<Integer> lowestPoints = new ArrayList<>();

        for(int i = 0; i < piece.getCurrentPiece()[0].length; i++){
            int lowestPoint = 0;
            for(int j = 0; j < piece.getCurrentPiece().length; j++){
                if(piece.getCurrentPiece()[j][i] != 0){
                    lowestPoint = j;
                }
            }
            lowestPoints.add(lowestPoint);
        }

        try{
            for(int i = 0; i < lowestPoints.size(); i++){
                int row = piece.getRow();
                int col = piece.getCol();
                int numBelowLowestPoint = board[row][col + lowestPoints.get(i) + 1];

                if(numBelowLowestPoint == 1){
                    return false;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }


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
