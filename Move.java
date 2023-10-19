public class Move {
    int row, column;
    Player player;
    
    public Move() {
        row = -1;
        column = -1;
    }
    
    public Move(int row, int column) {
        this.row = row;
        this.column = column;
        this.player = player;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public String toString() {
        return "("+row+","+column+")";
    }
}