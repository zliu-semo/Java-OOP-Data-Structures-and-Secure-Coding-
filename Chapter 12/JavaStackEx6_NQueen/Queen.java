package res;

/**
 * Class that mimics a queen piece in the N-Queen puzzle
 */
public class Queen {
    private int row;
    private int col;
    
    public Queen(int row) {
        this.row = row;
        this.col = 0;
    }
    
    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
    
    /**
     * Shifts the queen to the right by one column. Assumes that the client has already
     * checked whether the shift is valid (i.e. the queen will stay on the board).
     */
    public void shiftRight() { this.col++; }
}