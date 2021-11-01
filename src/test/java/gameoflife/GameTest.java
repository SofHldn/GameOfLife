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

    @Test
    void givenGridWithDimsXAndYReturnsGridWithDimsXPlusTwoAndYPlusTwo(){
        boolean[][] expectedResponse = new boolean[firstGenerationGrid.length+2][firstGenerationGrid[0].length+2];
        assertArrayEquals(expectedResponse, game.createTempGrid(firstGenerationGrid));
    }

}
