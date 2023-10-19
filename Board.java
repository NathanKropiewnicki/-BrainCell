public class Board{

 public Board() {
        myBoard = new Piece[DEFAULTSIZE][DEFAULTSIZE];
        initBoard();
    }
  public Board(int size) {
        myBoard = new Piece[size][size];
        initBoard();
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