package easy;

import org.junit.Assert;
import org.junit.Test;

public class RemoveOuterParenthesesProblemTest {
    private RemoveOuterParenthesesProblem solution;

    public RemoveOuterParenthesesProblemTest() {
        solution = new RemoveOuterParenthesesProblem();
    }

    @Test
    public void leetcodeSampleTest01() {
        // SETUP
        String input = "(()())(())";
        String expected = "()()()";

        // EXECUTE
        String actual = solution.removeOuterParentheses(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leetcodeSampleTest02() {
        // SETUP
        String input = "(()())(())(()(()))";
        String expected = "()()()()(())";

        // EXECUTE
        String actual = solution.removeOuterParentheses(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leetcodeSampleTest03() {
        // SETUP
        String input = "()()";
        String expected = "";

        // EXECUTE
        String actual = solution.removeOuterParentheses(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void solutionAcceptsEmptyStrings() {
        // SETUP
        String input = "";
        String expected = "";

        // EXECUTE
        String actual = solution.removeOuterParentheses(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void solutionAcceptsNestedParenthesesString() {
        // SETUP
        String input = "(((((())))))";
        String expected = "((((()))))";

        // EXECUTE
        String actual = solution.removeOuterParentheses(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void solutionSolvesASingleParenthesesTest() {
        // SETUP
        String input = "()";
        String expected = "";

        // EXECUTE
        String actual = solution.removeOuterParentheses(input);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }
}
