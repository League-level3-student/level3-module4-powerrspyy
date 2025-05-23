package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

    private static int rows;
    private static int cols;

    private static Maze maze;

    private static Random randGen = new Random();
    private static Stack<Cell> uncheckedCells = new Stack<Cell>();

    public static Maze generateMaze(int r, int c) {
        rows = r;
        cols = c;
        maze = new Maze(rows, cols);

        // 1. Pick a random cell along the border and remove its exterior wall.
        //    This will be the starting point. Then select a random cell along
        //    the opposite wall and remove its exterior wall. This will be the
        //    finish line.
        
        Cell start = maze.cells[randGen.nextInt(cols)][0];
        start.setNorthWall(false);
        
        Cell end = maze.cells[randGen.nextInt(cols)][rows-1];
        end.setSouthWall(false);
        
        
        // 2. select a randGenom cell in the maze to start 
        
        // 3. call the selectNextPath method with the randGenomly selected cell
        Cell curCell = maze.cells[randGen.nextInt(cols)][randGen.nextInt(rows)];
        while(curCell != null) {
        	curCell = selectNextPath(curCell);
        }
        

        return maze;
    }

    // 4. Complete the selectNextPathMethod
    private static Cell selectNextPath(Cell curCell) {
        // A. SET currentCell as visited
    	curCell.setBeenVisited(true);

        // B. check for unvisited neighbors using the cell
    	int[] up = {curCell.getCol(), curCell.getRow()-1};
    	int[] down = {curCell.getCol(), curCell.getRow()+1};
    	int[] left = {curCell.getCol()-1, curCell.getRow()};
    	int[] right = {curCell.getCol()+1, curCell.getRow()};
    	
    	ArrayList<Cell> nearby = new ArrayList<>();
    	if(valid_cell(up[0], up[1])) {
    		Cell up_cell = maze.cells[up[0]][up[1]];
    		if(!up_cell.hasBeenVisited()) {
    			nearby.add(up_cell);
    		}
    	}
    	if(valid_cell(down[0], down[1])) {
    		Cell down_cell = maze.cells[down[0]][down[1]];
    		if(!down_cell.hasBeenVisited()) {
    			nearby.add(down_cell);
    		}
    	}
    	if(valid_cell(left[0], left[1])) {
    		Cell left_cell = maze.cells[left[0]][left[1]];
    		if(!left_cell.hasBeenVisited()) {
    			nearby.add(left_cell);
    		}
    	}
    	if(valid_cell(right[0], right[1])) {
    		Cell right_cell = maze.cells[right[0]][right[1]];
    		if(!right_cell.hasBeenVisited()) {
    			nearby.add(right_cell);
    		}
    	}
    	
    	if(nearby.size()>=1) {
    		int selected = randGen.nextInt(nearby.size());
    		Cell next = nearby.get(selected);
    		uncheckedCells.push(next);
    		removeWalls(curCell, next);
    		return next;
    		
    	}
    	else {
    		if(!uncheckedCells.empty()) {
    			curCell = uncheckedCells.pop();
    			return curCell;
    		}
    	}
		return null;

        // C. if has unvisited neighbors,

        // C1. select one at random.

        // C2. push it to the stack

        // C3. remove the wall between the two cells

        // C4. make the new cell the current cell and SET it as visited

        // C5. call the selectNextPath method with the current cell


        // D. if all neighbors are visited

        // D1. if the stack is not empty

        // D1a. pop a cell from the stack

        // D1b. make that the current cell

        // D1c. call the selectNextPath method with the current cell

    }
    
    private static boolean valid_cell(int x, int y) {
    	if(x < 0 || x >= cols || y < 0 || y >= rows)return false;
    	else return true;
    }
    private static void rerun(Cell curCell) {
    	selectNextPath(curCell);
    }
    
    

    // This method will check if c1 and c2 are adjacent.
    // If they are, the walls between them are removed.
    private static void removeWalls(Cell c1, Cell c2) {
        if (c1.getRow() == c2.getRow()) {
            if (c1.getCol() > c2.getCol()) {
                c1.setWestWall(false);
                c2.setEastWall(false);
            } else {
                c1.setEastWall(false);
                c2.setWestWall(false);
            }
        } else {
            if (c1.getRow() > c2.getRow()) {
                c1.setNorthWall(false);
                c2.setSouthWall(false);
            } else {
                c1.setSouthWall(false);
                c2.setNorthWall(false);
            }
        }
    }

    // This method returns a list of all the neighbors around the specified
    // cell that have not been visited. There are up to 4 neighbors per cell.
    //          1
    //       2 cell 3
    //          4
    private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
        int row = c.getRow();
        int col = c.getCol();

        ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

        if (row > 0 && !maze.getCell(row - 1, col).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row - 1, col));
        }

        if (col > 0 && !maze.getCell(row, col - 1).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row, col - 1));
        }

        if (row < rows - 1 && !maze.getCell(row + 1, col).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row + 1, col));
        }

        if (col < cols - 1 && !maze.getCell(row, col + 1).hasBeenVisited()) {
            unvisitedNeighbors.add(maze.getCell(row, col + 1));
        }

        return unvisitedNeighbors;
    }
}
