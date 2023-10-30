/****************************************
/* Author: Micah Yoder
/* Course: CSC 221, Fall 2023
/* Lab: Inheritance Group Lab
/* Modified: October 29th 2023
*****************************************/
import java.io.*;
import java.util.*;

public class Connect4Game extends Game {
    private C4Board connect4Board;
    private Player redPlayer, blackPlayer;
    private Player currentPlayer;
    
    public Connect4Game () {
        super();
        ioDevice = new InputOutput();
        connect4Board = new C4Board();
        ioDevice.print("What is the name of the Red player? ");
        redPlayer = new Player(ioDevice.nextString(),new Piece(Piece.R));
        ioDevice.flushLine();
        ioDevice.print("What is the name of the Black player? ");
        blackPlayer = new Player(ioDevice.nextString(),new Piece(Piece.B));
        ioDevice.flushLine();
    }
    
    public Connect4Game(int size) {
        super();
        ioDevice = new InputOutput();
        connect4Board = new C4Board(size);
        ioDevice.print("What is the name of the Red player? ");
        redPlayer = new Player(ioDevice.nextString(),new Piece(Piece.R));
        ioDevice.flushLine();
        ioDevice.print("What is the name of the Black player? ");
        blackPlayer = new Player(ioDevice.nextString(),new Piece(Piece.B));
        ioDevice.flushLine();
    }
    
    public void playGame() {
        Move move;
        currentPlayer = redPlayer;
        
        while (!gameOver()) {
            displayBoard();
            move = getMoveRow(currentPlayer);
            while (!connect4Board.C4LegalMove(move)) {
                ioDevice.println("Illegal move");
                move = getMoveRow(currentPlayer);
            }
            connect4Board.C4MakeMove(move, currentPlayer);
            if (currentPlayer == redPlayer) currentPlayer = blackPlayer;
            else currentPlayer = redPlayer;
        }
        if (connect4Board.full())
            ioDevice.println("There is no winner");
        else if (connect4Board.winner(redPlayer))
            ioDevice.println(redPlayer.getName()+" is the winner.");
        else if (connect4Board.winner(blackPlayer))
            ioDevice.println(blackPlayer.getName()+" is the winner.");
    }
    
    public boolean gameOver() {
        if (connect4Board.winner(redPlayer) ||
            connect4Board.winner(blackPlayer))
            return true;
        if (connect4Board.full())
            return true;
        return false;
    }
    
    protected void displayBoard(){
        Board myBoard = getBoard();
        ioDevice.print(myBoard.toString());
    }
    
    protected Player getStartingPlayer() {
        return redPlayer;
    }
    
    protected Board getBoard() {
        return connect4Board;
    }
    
    protected Player switchPlayer() {
        if (currentPlayer == redPlayer)
            currentPlayer = blackPlayer;
        else
            currentPlayer = redPlayer;
        return currentPlayer;
    }
}