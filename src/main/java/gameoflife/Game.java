package gameoflife;

public class Game {

    public boolean[][] nextGeneration (boolean[][] grid ){

        boolean [][] tempGrid = createTempGrid(grid);
        return grid;

    }

    public boolean[][] createTempGrid(boolean[][] grid) {
        boolean[][] tempGrid = new boolean[grid.length+2][grid[0].length+2];

        for (int i = 1; i < tempGrid.length-1; i++) {
            for (int j = 1; j < tempGrid[0].length-1; j++) {
                tempGrid[i][j] = grid[i-1][j-1];
            }
        }

        return tempGrid;
    }
}
