package easy;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(x < minStack.peek() ? x : minStack.peek());
    }

    public void pop() {
        if(stack.isEmpty()) return;
        minStack.pop();
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return !stack.isEmpty() ? minStack.peek() : 0;
    }
}
