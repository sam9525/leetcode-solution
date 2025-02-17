/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

import java.util.Stack;

class Solution {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        // Push the opening bracket to the stack
        stack.push(c);
      } else {
        if (stack.empty()) {
          return false;
        }

        // Pop the top of the stack
        char top = stack.pop();

        // If the top of the stack is not the corresponding opening bracket, return false
        if (
          (c == ')' && top != '(') ||
          (c == ']' && top != '[') ||
          (c == '}' && top != '{')
        ) {
          return false;
        }
      }
    }

    return stack.empty();
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.isValid("()")); // true
    System.out.println(sol.isValid("()[]{}")); // true
    System.out.println(sol.isValid("(]")); // false
  }
}
// @lc code=end
