package Stack.MinimumStack;

import java.util.Stack;

/**
 * Created by namrataojha on 6/26/16.
 * Min Stack
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Solution
 Keep an auxilary stack for the min, update as elements are moved around
 https://www.youtube.com/watch?v=8Ub73n4ySYk

 Tip - only retrive minimum element rest all should remian same ....
 */
class MinStack {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> minData = new Stack<Integer>();
    public MinStack() {}

    public void push(int x) {
        data.push(x);
        if (minData.isEmpty() || x <= getMin()) {
            minData.push(x);
        }
    }

    public int pop() {
        if (!data.isEmpty()) {
            int v = data.pop();
            if (v == getMin()) {
                minData.pop();
            }
            return v;
        } else {
            throw new RuntimeException();
        }
    }

    public int top() {
        if (data.isEmpty()) throw new RuntimeException();
        return data.peek();
    }

    public int getMin() {
        if (minData.isEmpty()) throw new RuntimeException();
        return minData.peek();
    }
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-1);
        ms.push(-2);
        ms.push(0);
        System.out.format("%d\n", ms.getMin());
        System.out.println("Pop Element "+ ms.pop());

        System.out.format("%d\n", ms.getMin());
        System.out.println("Pop Element "+ ms.pop());
        System.out.format("%d\n", ms.getMin());
    }
}
