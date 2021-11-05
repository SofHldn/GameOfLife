package gameoflife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameTest {
    Game game = new Game();

    boolean[][] firstGenGrid = new boolean[4][8];

    @Test
    void returnsSameArrayWithAllCellsDead(){
        Assertions.assertArrayEquals(firstGenGrid, game.nextGeneration(firstGenGrid));
    }

    @Test
    void givenGridWithDimsXAndYReturnsGridWithDimsXPlusTwoAndYPlusTwo(){
        boolean[][] expectedResponse = new boolean[firstGenGrid.length+2][firstGenGrid[0].length+2];
        Assertions.assertArrayEquals(expectedResponse, game.createTempGrid(firstGenGrid));
    }

    @Test
    void OneAliveCellInGridGetsPositionXPlus1YPlus1InNewGrid(){

        firstGenGrid[0][0] = true;
        boolean[][] expectedResponse = new boolean[firstGenGrid.length+2][firstGenGrid[0].length+2];
        expectedResponse[1][1] = true;

        boolean[][] response = game.createTempGrid(firstGenGrid);
        assertEquals(expectedResponse[1][1],response[1][1]);
        assertEquals(expectedResponse[0][0], response[0][0]);
    }

    @Test
    void givenGridWithDimsXAndYReturnsGridWithDimsXMinusTwoAndYMinusTwo(){
        boolean[][] expectedResponse = new boolean[firstGenGrid.length-2][firstGenGrid[0].length-2];
        Assertions.assertArrayEquals(expectedResponse, game.convertBackToOriginalSize(firstGenGrid));
    }

    @Test
    void givenGridWithOneAliveCellReturnsAllDead(){
        firstGenGrid[1][1] = true;
        boolean[][] expectedResponse = new boolean[4][8];

        Assertions.assertArrayEquals(expectedResponse, game.nextGeneration(firstGenGrid));
    }

    @Test
    void givenThreeAliveCellsReturnTwoNeighbours(){

        firstGenGrid[1][4] = true;
        firstGenGrid[2][3] = true;
        firstGenGrid[2][4] = true;

        assertEquals(2, game.countNeighbours(firstGenGrid, 1, 5));
        assertEquals(2, game.countNeighbours(firstGenGrid, 2, 4));
        assertEquals(2, game.countNeighbours(firstGenGrid, 2, 5));
    }

    @Test
    void liveCellWithLessThanTwoNeighboursDies(){
        firstGenGrid[1][1] = true;
        boolean[][] expectedResponse = new boolean[4][8];

        Assertions.assertArrayEquals(expectedResponse, game.nextGeneration(firstGenGrid));

    }

    @Test
    void liveCellWithTwoOrThreeNeighboursLivesOn(){
        firstGenGrid[1][4] = true;
        firstGenGrid[2][3] = true;
        firstGenGrid[2][4] = true;

        boolean[][] expectedResponse = new boolean[4][8];
        expectedResponse[1][4] = true;
        expectedResponse[2][3] = true;
        expectedResponse[2][4] = true;

        boolean[][] actualResponse = game.nextGeneration(firstGenGrid);
        assertEquals(expectedResponse[1][4], actualResponse[1][4]);
        assertEquals(expectedResponse[2][3], actualResponse[2][3]);
        assertEquals(expectedResponse[2][4], actualResponse[2][4]);

    }

    @Test
    void liveCellWithMoreThanThreeNeighboursDies(){
        firstGenGrid[0][4] = true;
        firstGenGrid[1][3] = true;
        firstGenGrid[1][4] = true;
        firstGenGrid[2][3] = true;
        firstGenGrid[2][4] = true;

        boolean[][] actualResponse = game.nextGeneration(firstGenGrid);

        assertFalse(actualResponse[1][3]);
        assertFalse(actualResponse[1][4]);

    }

    @Test
    void deadCellWithExactlyThreeNeighboursLives(){

        firstGenGrid[1][4] = true;
        firstGenGrid[2][3] = true;
        firstGenGrid[2][4] = true;

        boolean[][] expectedResponse = new boolean[4][8];

        expectedResponse[1][3] = true;
        expectedResponse[1][4] = true;
        expectedResponse[2][3] = true;
        expectedResponse[2][4] = true;

        Assertions.assertArrayEquals(expectedResponse, game.nextGeneration(firstGenGrid));

    }



}
