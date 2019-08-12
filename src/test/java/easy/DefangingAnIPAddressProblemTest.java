package easy;

import org.junit.Assert;
import org.junit.Test;

public class DefangingAnIPAddressProblemTest {
    private DefangingAnIPAddressProblem solution;
    public DefangingAnIPAddressProblemTest() {
        solution = new DefangingAnIPAddressProblem();
    }

    @Test
    public void testDefangingAnIPAddress() {
        // SETUP
        String input = "1.1.1.1";
        String expectedOutput = "1[.]1[.]1[.]1";

        // EXECUTE
        String actualOutput = solution.defangIPaddr(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
