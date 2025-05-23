package _04_Maze_Maker;
import java.awt.Graphics;

public class Maze {
    // 1. Create a 2D array of cells. Don't initialize it.
	Cell[][] cells;
    
    private int rows;
    private int cols;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        // 2. Initialize the cells array using the rows and cols variables
        cells = new Cell[this.cols][this.rows];

        // 3. Iterate through each cell and initialize it
        //    using row and col as the cell location
        for(int x = 0; x < this.cols; x++) {
        	for(int y = 0; y < this.rows; y++) {
            	cells[x][y] = new Cell(x, y);
            }
        }

    }

    // 4. This method iterates through the cells and draws them
    public void draw(Graphics g) {
    	for(int x = 0; x < this.cols; x++) {
        	for(int y = 0; y < this.rows; y++) {
            	cells[x][y].draw(g);
            }
        }
    }

    // 5. This method returns the selected cell
    public Cell getCell(int x, int y){
        return  cells[x][y];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
