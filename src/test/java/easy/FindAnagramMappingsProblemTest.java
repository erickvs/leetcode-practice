package easy;

import org.junit.Assert;
import org.junit.Test;

public class FindAnagramMappingsProblemTest {
    FindAnagramMappingsProblem solution;

    public FindAnagramMappingsProblemTest() {
        solution = new FindAnagramMappingsProblem();
    }

    @Test
    public void leetcodeSampleInputAndSolution01() {
        // SETUP
        int[] a = {12, 28, 46, 32, 50};
        int[] b = {50, 12, 32, 46, 28};
        int[] expectedOutput =  {1,4,3,2,0};

        // EXECUTE
        int[] actualOutput = solution.anagramMappings(a, b);

        // VERIFY
        Assert.assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void leetcodeSampleInputAndSolution02() {
        // SETUP
        int[] a = {21,5,74,5,74,21};
        int[] b = {21,5,74,74,5,21};

        // EXECUTE
        int[] actualOutput = solution.anagramMappings(a, b);

        // VERIFY
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[actualOutput[i]]) {
                Assert.fail(
                        String.format(
                                "Failed at index %d: P[%d]=%d, A[%d]=%d, B[%d]=%d",
                                i,
                                i,
                                actualOutput[i],
                                i,
                                a[i],
                                actualOutput[i],
                                b[actualOutput[i]]
                        )
                );
            }
        }

    }
}
