package gameoflife;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunGame {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/java/gameoflife/input.txt"));
        List<String> grid = new ArrayList<>();

        while (sc.hasNextLine()){
            grid.add(sc.nextLine());
        }

        boolean[][] firstGenGrid = new boolean[grid.size()][grid.get(0).length()];

        for (int i = 0; i< grid.size(); i++ ){
            for (int j = 0; j < grid.get(0).length(); j++) {
                if(grid.get(i).toCharArray()[j]== '*'){
                    firstGenGrid[i][j] = true;
                }else {
                    firstGenGrid[i][j] = false;
                }
            }
        }
        Game game = new Game();

        System.out.println("-----GEN 1-----");
        game.printGrid(firstGenGrid);

        System.out.println("-----GEN 2-----");
        game.printGrid(game.nextGeneration(firstGenGrid));


    }

}
