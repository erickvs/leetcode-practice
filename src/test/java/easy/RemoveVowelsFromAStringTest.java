package easy;

import org.junit.Assert;
import org.junit.Test;

public class RemoveVowelsFromAStringTest {
    private RemoveVowelsFromAString solution;

    public RemoveVowelsFromAStringTest() {
         solution = new RemoveVowelsFromAString();
    }

    @Test
    public void vowelsRemovedFromSimpleWordTest() {

        // SETUP
        String input = "erick";
        String expectedOutput = "rck";

        // EXECUTE
        String actual = solution.removeVowels(input);

        // VERIFY
        Assert.assertEquals("erick should return rck", expectedOutput, actual);
    }

    @Test
    public void leetcodeSampleInputAndOutput_01() {
        // SETUP
        String input = "leetcodeisacommunityforcoders";
        String expectedOutput = "ltcdscmmntyfrcdrs";

        // EXECUTE
        String actual = solution.removeVowels(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actual);
    }


    @Test
    public void leetcodeSampleInputAndOutput_02() {
        // SETUP
        String input = "aeiou";
        String expectedOutput = "";

        // EXECUTE
        String actual = solution.removeVowels(input);

        // VERIFY
        Assert.assertEquals(expectedOutput, actual);
    }
}
