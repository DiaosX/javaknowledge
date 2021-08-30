package com.my.javabasic.arithmetic.buildqueuewithstack;

import java.util.Stack;

public class BuildQueueWithStack {
    public static final String Empty = "";

    public BuildQueueWithStack() {

    }

    private Stack<String> stack1 = new Stack<>();
    private Stack<String> stack2 = new Stack<>();

    public void enqueue(String elelment) {
        if (stack1.isEmpty()) {
            stack1.push(elelment);
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(elelment);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public String dequeue() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        }
        return BuildQueueWithStack.Empty;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public int size() {
        return stack1.size();
    }
}
