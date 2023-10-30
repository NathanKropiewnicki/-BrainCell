/****************************************
/* Author: Teacher
/* Course: CSC 221, Fall 2023
/* Lab: Inheritance Group Lab
/* Modified: October 29th 2023
/* Modified by Nick Bohm,MicahYoder,Nathan Kropiewnicki
*****************************************/

import java.io.*;
import java.util.*;
public class GameDriver {
    public static void main(String[] args) {
        TicTacToeGame tttGame;
        ReversiGame RGame;
        Connect4Game CGame;
        ChekcersGame ChGame;
        InputOutput scanner;
        int choice;
        int size;
        String filename;
        System.out.println("press 1 for tictactoe");
        System.out.println("press2 for Reversi");
        System.out.println("press 3 for connect4");
        System.out.println("press 4 for checkers");
        answer = scanner.nextInt();
        if(answer == 1){
            System.out.println("press 1 for a default board");
            System.out.println("press 2 for a custom board");
            answer = scanner.nextInt();
        if(answer == 1){
            tttGame = new TicTacToeGame();
            tttGame.playGame();
        }else{
           System.out.println("what board size?");
           size = scanner.nextInt();
           tttGame = new TicTacToeGame(size);
           tttGame.playGame();
           
        
    }
  
