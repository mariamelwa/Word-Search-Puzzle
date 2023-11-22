/**
 * @author  Mariam Elwa
 * Date: 26/10/2023
 * Goal : Find desired words in a 2D grid and display their coordinates
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Parse input and get a list of Grid objects
        ArrayList<Grid> grids = parseInput();

        // Iterate through each grid and solve it, then print the result
        for(int i=0; i<grids.size(); i++){
            System.out.println("Query " + (i+1) + ":");
            grids.get(i).solve();
        }
    }

    // Parse the input file and return a list of Grid objects
    private static ArrayList<Grid> parseInput() throws FileNotFoundException {

        // Create an ArrayList to store Grid objects
        ArrayList<Grid> grids = new ArrayList<>();

        // Specify the input file path
        File input = new File("src/TP1Input.txt");

        // Create a Scanner to read from the input file
        Scanner reader = new Scanner(input);

        // Iterate through each line in the file
        while(reader.hasNextLine()){

            // Read the dimensions of the grid
            String line = reader.nextLine();
            int rows = Integer.parseInt(line.split(" ")[0]);
            int cols = Integer.parseInt(line.split(" ")[1]);

            // Create a 2D array to represent the grid
            char [][] grid = new char[rows][cols];

            // Populate the grid with characters from the input file
            for(int i=0; i<rows; i++){
                line = reader.nextLine();
                grid[i] = line.replace(" ", "").toCharArray();
            }

            // Read the line containing words, sort them, and create a Grid object
            line = reader.nextLine();
            String[] words = line.split(" ");
            Arrays.sort(words);
            grids.add(new Grid(rows, cols, grid, words));
        }

        // Return the list of Grid objects
        return grids;
    }
}
