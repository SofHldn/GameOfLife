package gameoflife;

public class Game {

    public boolean[][] nextGeneration (boolean[][] grid ){

        boolean [][] tempGrid = createTempGrid(grid);

        int count = 0;
        for (int i = 1; i < tempGrid.length-1; i++) {
            for (int j = 1; j < tempGrid[0].length; j++) {

                if(tempGrid[i][j]== true){
                    count++;
                }
            }
        }
        boolean[][] allDeadGrid = new boolean[grid.length][grid[0].length];
        if(count < 3){
            return allDeadGrid;
        }

        grid = convertBackToOriginalSize(tempGrid);
        return grid;

    }

    public boolean[][] convertBackToOriginalSize(boolean[][] tempGrid) {
        boolean[][] grid = new boolean[tempGrid.length-2][tempGrid[0].length-2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = tempGrid[i+1][j+1];
            }
        }
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
