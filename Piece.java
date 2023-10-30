/****************************************
/* Author: Teacher
/* Course: CSC 221, Fall 2023
/* Lab: Inheritance Group Lab
/* Modified: October 29th 2023
/*Modified by Nick Bohm,MicahYoder,Nathan Kropiewnicki
*****************************************/

public class Piece {
    public static final char BLANK = ' ';
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char B = 'B';
    public static final char R = 'R';
    public static final char W = 'W';
    private char type;
    
    public Piece() {
        type = BLANK;
    }
    
    public Piece(char inType) {
        type = inType;
    }
    
    public char getPiece() {
        return type;
    }
    public char getPiece(char inType) {
        return type;
    }
    
    public boolean equals(Piece other) {
        return type==other.getPiece();
    }
    
    public boolean isAvailable() {
        return type == BLANK;
    }
    
    public String toString() {
        if (type == BLANK) return "_";
        else return type+"";
    }
    public char getOpponentPiece() {
        switch (type) {
            case X:
                return O;
            case O:
                return X;
            case B:
                return W;
            case W:
                return B;
            case R:
                return R;
            default:
                return BLANK;
        }
    }
}
