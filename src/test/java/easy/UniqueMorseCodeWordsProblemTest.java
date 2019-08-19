package easy;

import org.junit.Assert;
import org.junit.Test;

public class UniqueMorseCodeWordsProblemTest {
    private UniqueMorseCodeWordsProblem solution;

    public UniqueMorseCodeWordsProblemTest() {
        solution = new UniqueMorseCodeWordsProblem();
    }

    @Test
    public void leetcodeSampleTest01() {
        // SETUP
        String[] input = {"gin", "zen", "gig", "msg"};
        int expectedOutput = 2;

        // EXECUTE
        int actualOutput = solution.uniqueMorseRepresentations(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
