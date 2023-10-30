/****************************************
/* Author: Nick Bohm
/* Course: CSC 221, Fall 2023
/* Lab: Inheritance Group Lab
/* Modified: October 29th 2023

*****************************************/

public class ReversiBoard extends Board {
    private Player player;
    public static final int size = 8;

    public ReversiBoard() {
        super(size);
    }

    public ReversiBoard(int size) {
        super(size);
    }
    
   

    public boolean Winner(Player player) {
        int bCount = 0;
        int wCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (myBoard[i][j].getPiece() == Piece.B) {
                    bCount++;
                } else if (myBoard[i][j].getPiece() == Piece.W) {
                    wCount++;
                }
            }
        }

        if (player.getPiece().getPiece() == Piece.B) {
            return bCount > wCount;
        } else {
            return wCount > bCount;
        }
    }

    public boolean canFlipPiece(int row, int column, Player player) {
        boolean canFlip = false;
        Piece opponentPiece = new Piece(player.getPiece().getOpponentPiece());

        // Check horizontal and vertical
        for (int i = 1; i < size; i++) {
            if (myBoard[row][column - i].getPiece() == opponentPiece.getPiece() && 
                myBoard[row][column + i].getPiece() == 
                player.getPiece().getPiece()) {
                canFlip = true;
                break;
            }

            if (myBoard[row - i][column].getPiece() == opponentPiece.getPiece() &&
                 myBoard[row + i][column].getPiece() ==
                 player.getPiece().getPiece()) {
                canFlip = true;
                break;
            }
        }

        // Check diagonal
        for (int i = 1; i < size; i++) {
            if (myBoard[row - i][column - i].getPiece() ==
                opponentPiece.getPiece() &&
                 myBoard[row + i][column + i].getPiece() ==
                 player.getPiece().getPiece()) {
                canFlip = true;
                break;
            }

            if (myBoard[row - i][column + i].getPiece() ==
                 opponentPiece.getPiece() &&
                 myBoard[row + i][column - i].getPiece() ==
                 player.getPiece().getPiece()) {
                canFlip = true;
                break;
            }
        }

        return canFlip;
    }

    public void flipPiece(int row, int column, Player player) {
        Piece opponentPiece = new Piece(player.getPiece().getOpponentPiece());    

        // Flip horizontal and vertical
        for (int i = 1; i < size; i++) {
            if (myBoard[row][column - i].getPiece() == opponentPiece.getPiece() &&
                 myBoard[row][column + i].getPiece() ==
                 player.getPiece().getPiece()) {
                for (int j = column - i + 1; j <= column + i - 1; j++) {
                    myBoard[row][j] = new Piece(player.getPiece().getPiece());
                }
            }

            if (myBoard[row - i][column].getPiece() == opponentPiece.getPiece() &&
                 myBoard[row + i][column].getPiece() ==
                 player.getPiece().getPiece()) {
                for (int j = row - i + 1; j <= row + i - 1; j++) {
                    myBoard[j][column] = new Piece(player.getPiece().getPiece());
                }
            }
        }

        // Flip diagonal
        for (int i = 1; i < size; i++) {
            if (myBoard[row - i][column - i].getPiece() == opponentPiece.getPiece() && 
                myBoard[row + i][column + i].getPiece() == player.getPiece().getPiece()) {
                for (int j = 1; j <= i * 2 - 1; j++) {
                    myBoard[row - i + j][column - i + j] =
                    new Piece(player.getPiece().getPiece());
                }
            }

            if (myBoard[row - i][column + i].getPiece() == opponentPiece.getPiece() &&
             myBoard[row + i][column - i].getPiece() == player.getPiece().getPiece()) {
                for (int j = 1; j <= i * 2 - 1; j++) {
                    myBoard[row - i + j][column + i - j] = 
                    new Piece(player.getPiece().getPiece());
                }
            }
        }
    }
    public  void makeMove(Move move, Player player) {
        myBoard[move.getRow()][move.getColumn()] = player.getPiece();
    }
    public boolean LegalMove(Move move) {
        
        // Check if move is within the bounds of the board
        if (move.getRow() < 0 || move.getRow() >= size || move.getColumn() <
         0 || move.getColumn() >= size) {
        return false;
    }

        // Check if position is empty
        if (myBoard[move.getRow()][move.getColumn()].getPiece() !=
             myBoard[move.getRow()][move.getColumn()].getPiece()) {
        return false;
    }

        // Check if move leads to any possible flips
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (canFlipPiece(move.getRow() + i, move.getColumn() + 
                    j, player)) {
                    return true;
                }
            }
        }

        return false;
    }
    public void initializeBoard(int size) {
        
        myBoard = new Piece[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                myBoard[i][j] = new Piece(Piece.BLANK);
            }
        }

        // Place the initial 4 pieces in the center
        myBoard[size / 2 - 1][size / 2 - 1] = new Piece(Piece.W);
        myBoard[size / 2 - 1][size / 2] = new Piece(Piece.B);
        myBoard[size / 2][size / 2 - 1] = new Piece(Piece.B);
        myBoard[size / 2][size / 2] = new Piece(Piece.W);
    }
    
}