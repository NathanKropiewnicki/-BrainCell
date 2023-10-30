/****************************************
/* Author: Nick Bohm
/* Course: CSC 221, Fall 2023
/* Lab: Inheritance Group Lab
/* Modified: October 29th 2023
/*****************************************/

public class ReversiGame extends Game {
    private ReversiBoard reversiboard;
    private Player wPlayer, bPlayer;
    private InputOutput ioDevice;
    
    public ReversiGame(){
        ioDevice = new InputOutput();
        reversiboard = new ReversiBoard(); 
        ioDevice.print("what is the name of player w");
        wPlayer = new Player(ioDevice.nextString(),new Piece(Piece.W));
        ioDevice.flushLine();
        ioDevice.print("What is the name of the B player? ");
        bPlayer = new Player(ioDevice.nextString(),new Piece(Piece.B));
        ioDevice.flushLine();
    }
    
    public void playGame(){
        Player currentPlayer;
        currentPlayer = bPlayer;
        Move move;
        reversiboard.initializeBoard(8);
        while (!gameOver()) {
            displayBoard();
            move = super.getMove(currentPlayer);
            while(!reversiboard.LegalMove(move)){
                ioDevice.println("Illegal move");
                move = super.getMove(currentPlayer);
            }
            reversiboard.makeMove(move, currentPlayer);
            if(currentPlayer == bPlayer) currentPlayer = wPlayer;
            else 
                currentPlayer = bPlayer;
            }
            if(reversiboard.Winner(wPlayer))
                ioDevice.println(wPlayer.getName()+ " is the winner.");
            else
            ioDevice.println(bPlayer.getName()+" is the winner");
      }         
    private void displayBoard() {
        ioDevice.print(reversiboard.toString());
    }
    private boolean gameOver(){
        if (reversiboard.Winner(wPlayer) || reversiboard.Winner(bPlayer)) return true;
        return false;

    }
}
