/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.Stack;

class MinStack {

  Stack<Integer> stack = new Stack();
  Stack<Integer> minStack = new Stack();

  public MinStack() {}

  public void push(int val) {
    stack.push(val);
    if (minStack.empty() || val <= minStack.peek()) {
      minStack.push(val);
    }
  }

  public void pop() {
    if (stack.peek().equals(minStack.peek())) {
      minStack.pop();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // -3
    minStack.pop();
    System.out.println(minStack.top()); // 0
    System.out.println(minStack.getMin()); // -2
  }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
