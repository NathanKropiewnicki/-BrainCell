public class Board{
 protected Piece[][] myBoard;

 public Board() {
        myBoard = new Piece[3][3];
        initBoard();       
    }
  public Board(int size) {
        myBoard = new Piece[size][size];
        initBoard();
    }
    protected void initBoard() {
        int row, column;
        
        for (row = 0; row < myBoard.length; row++)
            for (column = 0; column < myBoard[0].length; column++) 
                myBoard[row][column] = new Piece(Piece.BLANK);
    }
    public boolean legalMove(Move move) {
        int row, column;
        
        row = move.getRow();
        column = move.getColumn();
        if (row < 0) return false;
        if (column < 0) return false;
        if (row >= myBoard.length) return false;
        if (column >= myBoard.length) return false;
        return true;
    }


    
    public String toString() {
        int row, column;
        String result;
        
        result = "";
        for (row = 0; row < myBoard.length; row++) {
            for (column = 0; column < myBoard[0].length; column++)
                result += myBoard[row][column].toString()+" ";
            result += "\n";
        }
        return result;
    }
}
