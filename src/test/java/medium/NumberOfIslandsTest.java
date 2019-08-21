package medium;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfIslandsTest {
    NumberOfIslands solution = new NumberOfIslands();
    private static final char FILLED = 'o';
    private static final char EMPTY = ' ';


    @Test
    public void leetcodeSampleTest01() {
        // SETUP
        char[][] input = {
                {FILLED, FILLED, FILLED, FILLED, EMPTY},
                {FILLED, FILLED, EMPTY, FILLED, EMPTY},
                {FILLED, FILLED, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        };
        int expected = 1;

        // EXECUTE
        int actual = solution.numIslands(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leetcodeSampleTest02() {
        // SETUP
        char[][] input = {
                {FILLED, FILLED, EMPTY, EMPTY, EMPTY},
                {FILLED, FILLED, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, FILLED, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, FILLED, FILLED},
        };
        int expected = 3;

        // EXECUTE
        int actual = solution.numIslands(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void solutionHandlesEmptyCase() {
        // SETUP
        char[][] input = {};
        int expected = 0;

        // EXECUTE
        int actual = solution.numIslands(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void solutionShouldHandleALargeNumberOfIslands() {
        // SETUP
        char[][] input = {
                {FILLED, EMPTY, FILLED, EMPTY, FILLED},
                {EMPTY, FILLED, EMPTY, FILLED, EMPTY},
                {FILLED, EMPTY, FILLED, EMPTY, FILLED},
                {EMPTY, FILLED, EMPTY, FILLED, EMPTY},
        };
        int expected = 10;

        // EXECUTE
        int actual = solution.numIslands(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void solutionShouldHandleExtraLargeNumberOfIslands() {
        // SETUP
        char[][] input = {
                {FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,EMPTY,FILLED,FILLED},
                {EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY},
                {FILLED,EMPTY,FILLED,FILLED,FILLED,EMPTY,EMPTY,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,EMPTY,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED},
                {EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,EMPTY,FILLED,FILLED,FILLED,FILLED,EMPTY,EMPTY},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED},
                {FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED,FILLED}
        };
        int expected = 1;

        // EXECUTE
        int actual = solution.numIslands(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void forMyEntertainment() {
        // SETUP
        int rows = 40;
        int columns = 40;
        char[][] input = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                input[i][j] = EMPTY;
            }
        }
        int expected = 0;

        // EXECUTE
        int actual = solution.numIslands(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }
}
