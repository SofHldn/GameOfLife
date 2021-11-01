package gameoflife;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;

public class GameTest {
    Game game = new Game();

    boolean[][] firstGenerationGrid = new boolean[4][8];

    @Test
    void returnsSameArrayWithAllCellsDead(){
        assertArrayEquals(firstGenerationGrid, game.nextGeneration(firstGenerationGrid));
    }



}
