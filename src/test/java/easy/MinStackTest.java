package easy;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {
    @Test
    public void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(5);
        Assert.assertEquals(5, minStack.top());
        minStack.pop();
        Assert.assertEquals(10, minStack.top());
    }

    @Test
    public void testMinStackGetMinMethod() {
        // stack: 0 1 -5 -2  3  1 -10  10
        // minst: 0 0 -5 -5 -5 -5 -10 -10
        MinStack minStack = new MinStack();
        minStack.push(0);
        Assert.assertEquals(0, minStack.getMin());
        minStack.push(1);
        Assert.assertEquals(0, minStack.getMin());
        minStack.push(-5);
        Assert.assertEquals(-5, minStack.getMin());
        minStack.push(-2);
        Assert.assertEquals(-5, minStack.getMin());
        minStack.push(-3);
        Assert.assertEquals(-5, minStack.getMin());
        minStack.push(1);
        Assert.assertEquals(-5, minStack.getMin());
        minStack.push(-10);
        Assert.assertEquals(-10, minStack.getMin());
        minStack.push(10);
        Assert.assertEquals(-10, minStack.getMin());
        // stack: 0 1 -5 -2  3  1 -10  10
        // minst: 0 0 -5 -5 -5 -5 -10 -10
        minStack.pop();
        // stack: 0 1 -5 -2  3  1 -10
        // minst: 0 0 -5 -5 -5 -5 -10
        Assert.assertEquals(-10, minStack.getMin());
        minStack.pop();
        // stack: 0 1 -5 -2  3  1
        // minst: 0 0 -5 -5 -5 -5
        Assert.assertEquals(-5, minStack.getMin());
        minStack.pop();
        // stack: 0 1 -5 -2  3
        // minst: 0 0 -5 -5 -5
        Assert.assertEquals(-5, minStack.getMin());
        minStack.pop();
        // stack: 0 1 -5 -2
        // minst: 0 0 -5 -5
        Assert.assertEquals(-5, minStack.getMin());
        minStack.pop();
        // stack: 0 1 -5
        // minst: 0 0 -5
        Assert.assertEquals(-5, minStack.getMin());
        minStack.pop();
        // stack: 0 1
        // minst: 0 0
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        // stack: 0
        // minst: 0
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        // stack:
        // minst:
        Assert.assertEquals(0, minStack.getMin());
    }

    @Test
    public void leetcodeSampleTest() {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.getMin());
    }


}
