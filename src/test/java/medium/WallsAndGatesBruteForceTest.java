package medium;

import org.junit.Assert;
import org.junit.Test;

public class WallsAndGatesBruteForceTest {
    // WallsAndGatesBruteForce solution = new WallsAndGatesBruteForce();
    WallsAndGates solution = new WallsAndGates();
    @Test
    public void leetcodeSampleTest() {
        // SETUP
        int inf = Integer.MAX_VALUE;
        int[][] input = {
                {inf,  -1,   0, inf},
                {inf, inf, inf,  -1},
                {inf,  -1, inf,  -1},
                {  0,  -1, inf, inf}
        };
        int[][] expectedOutput = {
                {  3,  -1,   0,   1},
                {  2,   2,   1,  -1},
                {  1,  -1,   2,  -1},
                {  0,  -1,   3,   4}
        };

        // EXECUTE
        solution.wallsAndGates(input);

        // VERIFY
        verify(4,4, expectedOutput, input);
    }

    @Test
    public void solutionAcceptsEmptyInputTest() {
        // SETUP
        int [][] emptyInput = {};
        int [][] expected = {};

        // EXECUTE
        solution.wallsAndGates(emptyInput);

        // VERIFY
        verify(0,0, expected, emptyInput);
    }

    private void verify(int rows, int cols, int[][] expected, int[][] actual) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (actual[row][col] != expected[row][col]) {
                    Assert.fail(
                            String.format(
                                    "Mismatch in row: %d, col: %d, expected: %d, actual: %d",
                                    row,
                                    col,
                                    expected[row][col],
                                    actual[row][col]
                            )
                    );
                }
            }
        }
    }
}
