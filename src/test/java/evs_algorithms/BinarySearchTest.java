package evs_algorithms;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    private BinarySearch solution;

    public BinarySearchTest() {
        solution = new BinarySearch();
    }

    @Test
    public void binarySearch_returnsCorrectIndexOfElement() {
        // SETUP
        int[] input = {1,2,3,4,5};
        int elementToSearch = 3;
        int expectedOutput = 2;

        // EXECUTE
        int actualOutput = solution.binarySearchAndReturnExpectedIndexLocationIfNotFound(input, 0, 4, elementToSearch);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void binarySearch_returnsCorrectIndexOfMissingElementOddArray() {
        // SETUP
        int[] input = {1,2,2,4,5};
        int elementToSearch = 3;
        int expectedOutput = 3;

        // EXECUTE
        int actualOutput = solution.binarySearchAndReturnExpectedIndexLocationIfNotFound(input, 0, 4, elementToSearch);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void binarySearch_returnsCorrectIndexOfMissingElementEvenArray() {
        // SETUP
        int[] input = {1,2,2,2,4,5};
        int elementToSearch = 3;
        int expectedOutput = 4;

        // EXECUTE
        int actualOutput = solution.binarySearchAndReturnExpectedIndexLocationIfNotFound(input, 0, 5, elementToSearch);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void binarySearch_returnsCorrectIndexOfFirstElement() {
        // SETUP
        int[] input = {1,2,2,2,4,5};
        int elementToSearch = 1;
        int expectedOutput = 0;

        // EXECUTE
        int actualOutput = solution.binarySearchAndReturnExpectedIndexLocationIfNotFound(input, 0, 5, elementToSearch);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void binarySearch_returnsCorrectIndexOfFirstElementWhenMissing() {
        // SETUP
        int[] input = {2,2,2,2,4,5};
        int elementToSearch = 1;
        int expectedOutput = 0;

        // EXECUTE
        int actualOutput = solution.binarySearchAndReturnExpectedIndexLocationIfNotFound(input, 0, 5, elementToSearch);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void binarySearch_returnsCorrectIndexOfLastElement() {
        // SETUP
        int[] input = {1,2,2,2,4,5};
        int elementToSearch = 5;
        int expectedOutput = 5;

        // EXECUTE
        int actualOutput = solution.binarySearchAndReturnExpectedIndexLocationIfNotFound(input, 0, 5, elementToSearch);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void binarySearch_returnsCorrectIndexOfLastElementWhenMissing() {
        // SETUP
        int[] input = {2,2,2,2,4,4};
        int elementToSearch = 5;
        int expectedOutput = 5;

        // EXECUTE
        int actualOutput = solution.binarySearchAndReturnExpectedIndexLocationIfNotFound(input, 0, 5, elementToSearch);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
