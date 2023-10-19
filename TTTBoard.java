public class TTTBoard extends Board {
    public static final int DEFAULTSIZE = 3;
    private Piece[][] myBoard;
    
       
    private void initBoard() {
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
        if (myBoard[row][column].isAvailable()) return true;
        return false;
    }
    
    public void makeMove(Move move, Player player) {
        myBoard[move.getRow()][move.getColumn()] = player.getPiece();
    }
    
    public boolean winner(Player player) {
        Piece curPiece;
        int row, column;
        boolean legitSoFar;
        
        curPiece = player.getPiece();
        for (row = 0; row < myBoard.length; row++) {
            legitSoFar = true;
            for (column = 0; column < myBoard[0].length; column++)
                if (!curPiece.equals(myBoard[row][column]))
                    legitSoFar = false;
            if (legitSoFar) return true;
        }
        for (column = 0; column < myBoard[0].length; column++) {
            legitSoFar = true;
            for (row = 0; row < myBoard.length; row++)
                if (!curPiece.equals(myBoard[row][column]))
                    legitSoFar = false;
            if (legitSoFar) return true;
        }
        
        legitSoFar = true;
        for (row = 0; row < myBoard.length; row++)
            if (!curPiece.equals(myBoard[row][row]))
                legitSoFar = false;
        if (legitSoFar) return true;
        
        legitSoFar = true;
        column = myBoard[0].length-1;
        for (row = 0; row < myBoard.length; row++) {
            if (!curPiece.equals(myBoard[row][column]))
                legitSoFar = false;
            column--;
        }
        
        return legitSoFar;
        
    }
    
   }