package easy;

import org.junit.Assert;
import org.junit.Test;

public class ArmstrongNumberProblemTest {
    private ArmstrongNumberProblem solution;

    public ArmstrongNumberProblemTest() {
        solution = new ArmstrongNumberProblem();
    }

    @Test
    public void leetcodeExample01Test() {
        // SETUP
        int input = 153;

        // EXECUTE
        boolean actualOutput = solution.isArmstrong(153);

        // VERIFY
        Assert.assertTrue("Expected 153 to be true.", actualOutput);
    }

    @Test
    public void leetcodeExample02Test() {
        // SETUP
        int input = 123;

        // EXECUTE
        boolean actualOutput = solution.isArmstrong(123);

        // VERIFY
        Assert.assertFalse("Expected 123 to not be an Armstrong number", actualOutput);
    }
}
