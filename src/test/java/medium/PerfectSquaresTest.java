package medium;

import org.junit.Assert;
import org.junit.Test;

public class PerfectSquaresTest {
    private PerfectSquares solution = new PerfectSquares();

    @Test
    public void leetcodeSampleTest01() {
        // SETUP
        int n = 12;
        int expected = 3;

        // EXECUTE
        int actual = solution.numSquares(n);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leetcodeSampleTest02() {
        // SETUP
        int n = 13;
        int expected = 2;

        // EXECUTE
        int actual = solution.numSquares(n);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void trivialTest_One() {
        // SETUP
        int n = 1;
        int expected = 1;

        // EXECUTE
        int actual = solution.numSquares(n);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void trivialTest_Zero() {
        // SETUP
        int n = 0;
        int expected = 1;

        // EXECUTE
        int actual = solution.numSquares(n);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTwo() {
        // SETUP
        int n = 2;
        int expected = 2;

        // EXECUTE
        int actual = solution.numSquares(n);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSeven() {
        // SETUP
        int n = 7;
        int expected = 4;

        // EXECUTE
        int actual = solution.numSquares(n);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }
}
