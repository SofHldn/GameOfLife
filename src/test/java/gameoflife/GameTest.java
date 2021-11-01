package gameoflife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Game game = new Game();

    boolean[][] firstGenerationGrid = new boolean[4][8];

    @Test
    void returnsSameArrayWithAllCellsDead(){
        Assertions.assertArrayEquals(firstGenerationGrid, game.nextGeneration(firstGenerationGrid));
    }

    @Test
    void givenGridWithDimsXAndYReturnsGridWithDimsXPlusTwoAndYPlusTwo(){
        boolean[][] expectedResponse = new boolean[firstGenerationGrid.length+2][firstGenerationGrid[0].length+2];
        Assertions.assertArrayEquals(expectedResponse, game.createTempGrid(firstGenerationGrid));
    }

    @Test
    void OneAliveCellInGridGetsPositionXPlus1YPlus1InNewGrid(){

        firstGenerationGrid[0][0] = true;
        boolean[][] expectedResponse = new boolean[firstGenerationGrid.length+2][firstGenerationGrid[0].length+2];
        expectedResponse[1][1] = true;

        boolean[][] response = game.createTempGrid(firstGenerationGrid);
        assertEquals(expectedResponse[1][1],response[1][1]);
        assertEquals(expectedResponse[0][0], response[0][0]);
    }




}
