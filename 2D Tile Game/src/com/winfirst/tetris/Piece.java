package com.winfirst.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import com.winfirst.utils.Handler;

public class Piece implements Comparable, Cloneable{

    private Handler handler;
    private int row, col;
    private Color color;
    private int[][][] diagrams;
    private int[][] currentPiece;
    private int index = 0;

    public Piece(Handler handler, int[][][] diagrams, Color color) {
        this.handler = handler;
        this.color = color;
        this.row = 3;
        this.col = 0;
        this.diagrams = diagrams;
        this.currentPiece = this.diagrams[index];
    }

    public void rotateClockwise(){
        index++;

        try{
            this.currentPiece = this.diagrams[index];
        }catch (ArrayIndexOutOfBoundsException e){
            index = 0;
            this.currentPiece = this.diagrams[index];
        }
    }

    public void rotateCounterClockwise(){
        index--;

        try{
            this.currentPiece = this.diagrams[index];
        }catch (ArrayIndexOutOfBoundsException e){
            index = 0;
            this.currentPiece = this.diagrams[index];
        }
    }

    public void moveDown(){
        col++;
    }

    public void moveRight(){
        row++;
    }

    public void moveLeft(){
        row--;
    }


    public int[][] currentPiece(){
        return currentPiece;
    }

    public int getRow(){
	return row;
    }
	
    public int getCol(){
	return col;
    }
	
    public int[][] getCurrentPiece(){
	return currentPiece;
    }

    @Override
    public Piece clone() throws CloneNotSupportedException {
        return (Piece) super.clone();
    }

    @Override
    public int compareTo(Object arg0) {
    	return 0;
    }

    @Override
    public String toString(){
        return Arrays.deepToString(currentPiece);
    }
}
