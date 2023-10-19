import java.io.*;
import java.util.*;
public class GameDrive {
    public static void main(String[] args) {
        TicTacToeGame myGame;
        InputOutput scanner;
        int option;
        int size;
        String filename;
        scanner  = new InputOutput();
        
        System.out.println("1 for 3x3");
        System.out.println("2 for your choice of size");
        System.out.println("Press 3 to read from file");
        
        option = scanner.nextInt();
               
        if(option == 1){
            myGame = new TicTacToeGame();
             myGame.playGame();
        }
        else if(option == 2){
            System.out.println("enter board size");
            size = scanner.nextInt();
            myGame = new TicTacToeGame(size);
             myGame.playGame();
        }
        else if(option == 3){
            System.out.println("enter file name");
            filename = scanner.nextString();
            myGame = new TicTacToeGame(filename);
             myGame.playGame();
        }
           
        
    }
}