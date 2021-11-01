package gameoflife;

public class Game {

    public boolean[][] nextGeneration (boolean[][] grid ){

        boolean [][] tempGrid = createTempGrid(grid);
        return grid;

    }

    public boolean[][] createTempGrid(boolean[][] grid) {
        boolean[][] tempGrid = new boolean[grid.length+2][grid[0].length+2];
        return tempGrid;
    }
}
