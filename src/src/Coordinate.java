/**
 * Represents a 2D coordinate with a row and column
 */

public class Coordinate {
    private final int row;
    private final int col;

    /**
     * Constructs a Coordinate with specified row and column values
     * 
     * @param row The row value
     * @param col The column value
     */
    public Coordinate(int row, int col){
        this.row = row;
        this.col = col;
    }

    /**
     * Returns a string representation of the Coordinate in the form (row,col)
     * 
     * @return A string representation of the Coordinate
     */
    public String toString(){
        return "(" + this.row + "," + this.col + ")";
    }
}
