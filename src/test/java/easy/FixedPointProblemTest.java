package easy;

import org.junit.Assert;
import org.junit.Test;

public class FixedPointProblemTest {
    private FixedPointProblem solution;

    public FixedPointProblemTest() {
        this.solution = new FixedPointProblem();
    }

    @Test
    public void leetcodeSampleTest01() {
        // SETUP
        int[] input = {-10, -5, 0 , 3, 7};
        int expectedOutput = 3;

        // EXECUTE
        int actualOutput = solution.fixedPoint(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void leetcodeSampleTest02() {
        // SETUP
        int[] input = {0, 2, 5, 8, 17};
        int expectedOutput = 0;

        // EXECUTE
        int actualOutput = solution.fixedPoint(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void leetcodeSampleTest03() {
        // SETUP
        int[] input = {-10, -5, 3, 4, 7, 9};
        int expectedOutput = -1;

        // EXECUTE
        int actualOutput = solution.fixedPoint(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void zeroElementIsLastElementInInput() {
        // SETUP
        int[] input = {-10, -5, -4, -3, -2, 0};
        int expectedOutput = -1;

        // EXECUTE
        int actualOutput = solution.fixedPoint(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void correctElementIsLastInput() {
        // SETUP
        int[] input = {-10, -5, -4, -3, -2, 5};
        int expectedOutput = 5;

        // EXECUTE
        int actualOutput = solution.fixedPoint(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void allElementsAreNegative() {
        // SETUP
        int[] input = {-10, -5, -4, -3, -2, -1};
        int expectedOutput = -1;

        // EXECUTE
        int actualOutput = solution.fixedPoint(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
