/****************************************
/* Author: Micah Yoder
/* Course: CSC 221, Fall 2023
/* Lab: Inheritance Group Lab
/* Modified: October 29th 2023
*****************************************/
import java.io.*;
import java.util.*;

public class C4Board extends Board {
    public static final int DEFAULTSIZE = 8;
    private Player redPlayer, blackPlayer;
    
    public C4Board() {
        super(DEFAULTSIZE);
    }
    
    public C4Board(int size) {
        super(size);
    }
    
    public boolean full() {
        int column, count;
        count = 0;
        for (column = 0; column < myBoard.length; column ++) {
            if (!myBoard[0][column].isAvailable())
                count++;
        }
        if (count == myBoard.length) {
            return true;
        }
        return false;
    }
    
    public boolean C4LegalMove (Move move) {
        int row, column;
        column = move.getColumn();
        if (column < 0) 
            return false;
        if (column >= myBoard.length)
            return false;
        if (myBoard[0][column].isAvailable())
            return true;
        return false;
    }
    
    public void C4MakeMove (Move move, Player player) {
        int row, column;
        row = myBoard.length-1;
        column = move.getColumn();
        while (!myBoard[row][column].isAvailable())
            row--;
        myBoard[row][column] = player.getPiece();
    }
    
    public boolean winner(Player player) {
        Piece curPiece = player.getPiece();
        int count = 0;
    
        // Check rows for a win
        for (int row = 0; row < myBoard.length; row++) {
            count = 0;
            for (int column = 0; column < myBoard[0].length; column++) {
                if (curPiece.equals(myBoard[row][column])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
    
        // Check columns for a win
        for (int column = 0; column < myBoard[0].length; column++) {
            count = 0;
            for (int row = 0; row < myBoard.length; row++) {
                if (curPiece.equals(myBoard[row][column])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
    
        // Check diagonals for a win
        for (int row = 0; row < myBoard.length - 3; row++) {
            for (int column = 0; column < myBoard[0].length - 3; column++) {
                count = 0;
                for (int i = 0; i < 4; i++) {
                    if (curPiece.equals(myBoard[row + i][column + i])) {
                        count++;
                        if (count == 4) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
    
        // Check reverse diagonals for a win
        for (int row = 3; row < myBoard.length; row++) {
            for (int column = 0; column < myBoard[0].length - 3; column++) {
                count = 0;
                for (int i = 0; i < 4; i++) {
                    if (curPiece.equals(myBoard[row - i][column + i])) {
                        count++;
                        if (count == 4) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
    
        return false;
    }   
    public int getSize() {
        return myBoard.length;
    }
    public Piece[][] getPiece() {
        return myBoard;
    }
}
