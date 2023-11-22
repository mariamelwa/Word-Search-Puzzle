public class Grid {
    private final int rows;
    private final int cols;
    private final char[][] grid;
    private final String[] words;

    // Constructor to initialize the Grid object with rows, columns, grid content, and words to search
    public Grid(int rows, int cols, char[][] grid, String[] words) {
        this.rows = rows;
        this.cols = cols;
        this.grid = grid;
        this.words = words;
    }

    // Method to initiate the word search for each word in the Grid
    public void solve(){
        for(String word : this.words){
            for(int row=0; row<this.rows; row++){
                for(int col=0; col<this.cols; col++){

                    // For each starting point, find the word in all eight possible directions
                    Coordinate[] path = new Coordinate[word.length()];
                    findWord(word, row, col, "", path);
                }
            }
        }
    }

    // Recursive method to find a word in all eight directions starting from a given position
    private void findWord(String word, int row, int col, String string, Coordinate[] path){

        // Base cases: check for out-of-bounds and mismatch with word characters
        if(row < 0 || row >= this.rows || col < 0 || col >= this.cols){
            return;
        }
        if(this.grid[row][col] != word.charAt(string.length())){
            return;
        }

        // Update the current string and path information
        string += this.grid[row][col];
        path[string.length()-1] = new Coordinate(row, col);

        // Check if the current string matches the target word
        if(string.equals(word)){

            // Print the word and its path coordinates
            System.out.print(word + " ");
            for(int i = 0; i< path.length; i++){
                System.out.print(path[i]);
                if(i != path.length-1){
                    System.out.print("->");
                }
            }
            System.out.print("\n");
            return;
        }
        
        // Recursively explore in all eight possible directions
        findWord(word, row-1, col-1, string, path); //top left
        findWord(word, row-1, col+1, string, path); //top right
        findWord(word, row-1, col, string, path); //top
        findWord(word, row, col-1, string, path); //left
        findWord(word, row, col, string, path); //self
        findWord(word, row, col+1, string, path); //right
        findWord(word, row+1, col-1, string, path); //bottom left
        findWord(word, row+1, col, string, path); //bottom
        findWord(word, row+1, col+1, string, path); //bottom right
    }
}
