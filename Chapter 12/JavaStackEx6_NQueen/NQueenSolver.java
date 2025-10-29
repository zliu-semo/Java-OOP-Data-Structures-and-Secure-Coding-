package res;

import java.util.Stack;

/**
 * Class that implements the N-Queen solver algorithm using a stack
 */
public class NQueenSolver {
    private int N;
    private Stack<Queen> queens;
    private int filled;
    
    /**
     * Explicit-value constructor
     * @param N the size of the game
     */
    public NQueenSolver(int N) {
        this.N = N;
        this.queens = new Stack<Queen>();
        this.filled = 0;
    }
    
    /**
     * Implement the N-Queen algorithm
     * @return a String representation of the solved N-Queen puzzle
     */
    public String solve() {
        Queen curr = null;
        while (filled < N) {
            // the current Queen is null if we started a new row
            if (curr == null) { curr = new Queen(filled); }
            while (curr != null && curr.getCol() < N) {
                if (hasConflict(curr)) { curr.shiftRight(); } 
                else {
                    queens.push(curr);
                    filled++;
                    curr = null;    // start a new row
                    break;
                }
            }
            // if out of bounds, shift an old Queen.
            while (curr != null && curr.getCol() >= N) {
                curr = queens.pop();
                filled--;
                curr.shiftRight();
            }
        }
        return writeToArray();
    }
    
    /**
     * Helper function to determine whether the current queen piece has a conflict with 
     * previously placed queens.
     * @param current the current queen piece
     * @return {@code true} if a conflict exists (same row, column, or diagonal as another queen),
     * {@code false} otherwise
     */
    private boolean hasConflict(Queen current) {
        // Check all previous Queen pieces.
        Queen[] previousQueens = queens.toArray(new Queen[queens.size()]);
        
        for (Queen previous: previousQueens) {
            int previousRow = previous.getRow();
            int previousCol = previous.getCol();
            int currentRow = current.getRow();
            int currentCol = current.getCol();
            
            if (previousRow == currentRow) return true;
            if (previousCol == currentCol) return true;
            
            // Diagonals: same distance between rows and columns
            if (Math.abs(previousRow - currentRow) == 
                    Math.abs(previousCol - currentCol)) return true;
        }
        return false;
    }
    
    /**
     * Helper function to return the solved N-Queen puzzle to an array.
     * @return String grid, containing "Q" where a queen lies, and "-" everywhere else
     */
    private String writeToArray() {
        String[][] result = new String[N][N];
        // Pre-populate the grid with "empty", "-".
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = "-";
            }
        }
        // Overwrite the squares with a Queen piece.
        Queen[] queensArr = queens.toArray(new Queen[queens.size()]);
        for (Queen queen: queensArr) {
            int row = queen.getRow();
            int col = queen.getCol();
            result[row][col] = "Q";
        }
        StringBuilder builder = new StringBuilder();
        // Write the rows in reverse order so (0, 0) is in bottom left corner.
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                builder.append(result[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}