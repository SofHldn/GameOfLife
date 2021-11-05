package gameoflife;


public class Game {

    public boolean[][] nextGeneration (boolean[][] grid ){

        boolean [][] tempGrid = createTempGrid(grid);
        boolean [][] nextGenGrid = createTempGrid(grid);

        for (int i = 1; i < tempGrid.length-1; i++) {
            for (int j = 1; j < tempGrid[0].length-1; j++) {
                nextGenGrid[i][j] = updateCell(tempGrid[i][j], countNeighbours(tempGrid, i, j));
            }
        }

        grid = convertBackToOriginalSize(nextGenGrid);

        return grid;

    }

   public void printGrid(boolean[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    private boolean updateCell(boolean cell, int neighbours) {
        if(cell && neighbours < 2 || cell && neighbours > 3){
            cell = false;
        }else if(!cell && neighbours == 3){
            cell = true;
        }
        return cell;
    }

    public int countNeighbours(boolean[][] tempGrid, int row, int column) {
        int count = 0;
        for (int i = row-1; i <= row+1 ; i++) {
            for (int j = column-1; j <=column+1 ; j++) {
                if(i == row && j == column){
                }else if(tempGrid[i][j]){
                    count++;
                }
            }
        }
        return count;
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
