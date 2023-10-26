public class TicTacToeGame extends Game{
    private TTTBoard tttBoard;
    private Player xPlayer, oPlayer;
    private InputOutput ioDevice;
    
    public TicTacToeGame() {
        ioDevice = new InputOutput();
        tttBoard = new TTTBoard();
        ioDevice.print("What is the name of the X player? ");
        xPlayer = new Player(ioDevice.nextString(),new Piece(Piece.X));
        ioDevice.flushLine();
        ioDevice.print("What is the name of the O player? ");
        oPlayer = new Player(ioDevice.nextString(),new Piece(Piece.O));
        ioDevice.flushLine();
    }
    
    public TicTacToeGame(int size) {
        ioDevice = new InputOutput();
        tttBoard = new TTTBoard(size);
        ioDevice.print("What is the name of the X player? ");
        xPlayer = new Player(ioDevice.nextString(),new Piece(Piece.X));
        ioDevice.flushLine();
        ioDevice.print("What is the name of the O player? ");
        oPlayer = new Player(ioDevice.nextString(),new Piece(Piece.O));
        ioDevice.flushLine();
    }

    public TicTacToeGame(String filename) {
        int size;
        String str;
        ioDevice = new InputOutput(filename);
        size = ioDevice.nextInt();
        tttBoard = new TTTBoard(size);
        ioDevice.flushLine();
        xPlayer = new Player(ioDevice.nextString(),new Piece(Piece.X));
        ioDevice.flushLine();
        oPlayer = new Player(ioDevice.nextString(),new Piece(Piece.O));
        ioDevice.flushLine();
    }

    public void playGame() {
        Player currentPlayer;
        Move move;
        
        currentPlayer = xPlayer;
        while (!gameOver()) {
            displayBoard();
            move = super.getMove(currentPlayer);
            while (!tttBoard.legalMove(move)) {
                ioDevice.println("Illegal move");
                move = super.getMove(currentPlayer);
            }
            tttBoard.makeMove(move, currentPlayer);
            if (currentPlayer == xPlayer) currentPlayer = oPlayer;
            else currentPlayer = xPlayer;
        }
        
        if (tttBoard.winner(xPlayer)) 
            ioDevice.println(xPlayer.getName()+" is the winner.");
        else ioDevice.println(oPlayer.getName()+" is the winner.");
    }
    
    private boolean gameOver() {
        if (tttBoard.winner(xPlayer) || tttBoard.winner(oPlayer)) return true;
        return false;
    }
    private void displayBoard() {
        ioDevice.print(tttBoard.toString());
    }

}
