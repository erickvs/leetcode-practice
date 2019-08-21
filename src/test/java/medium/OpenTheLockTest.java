package medium;

import org.junit.Assert;
import org.junit.Test;

public class OpenTheLockTest {
    OpenTheLock solution;

    public OpenTheLockTest() {
        solution = new OpenTheLock();
    }

    @Test
    public void leetcodeSampleTest01() {
        // SETUP
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int expected = 6;

        // EXECUTE
        int actual = solution.openLock(deadends, target);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leetcodeSampleTest02() {
        // SETUP
        String[] deadends = {"8888"};
        String target = "0009";
        int expected = 1;

        // EXECUTE
        int actual = solution.openLock(deadends, target);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leetcodeSampleTest03() {
        // SETUP
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        int expected = -1;

        // EXECUTE
        int actual = solution.openLock(deadends, target);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leetcodeSampleTest04() {
        // SETUP
        String[] deadends = {"0000"};
        String target = "8888";
        int expected = -1;

        // EXECUTE
        int actual = solution.openLock(deadends, target);

        // VERIFY
        Assert.assertEquals(expected, actual);
    }
}
