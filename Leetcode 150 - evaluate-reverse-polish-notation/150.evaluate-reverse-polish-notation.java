/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start

import java.util.Stack;

class Solution {

  public int evalRPN(String[] tokens) {
    Stack<Integer> st = new Stack<>();

    for (String token : tokens) {
      if (!"+-*/".contains(token)) {
        st.push(Integer.parseInt(token));
        continue;
      }

      int first = st.pop();
      int sec = st.pop();

      switch (token) {
        case "+":
          st.push(sec + first);
          break;
        case "-":
          st.push(sec - first);
          break;
        case "*":
          st.push(sec * first);
          break;
        case "/":
          st.push(sec / first);
          break;
      }
    }

    return st.peek();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] tokens = { "2", "1", "+", "3", "*" };
    System.out.println(solution.evalRPN(tokens)); // 9

    tokens = new String[] { "4", "13", "5", "/", "+" };
    System.out.println(solution.evalRPN(tokens)); // 6

    tokens =
      new String[] {
        "10",
        "6",
        "9",
        "3",
        "+",
        "-11",
        "*",
        "/",
        "*",
        "17",
        "+",
        "5",
        "+",
      };
    System.out.println(solution.evalRPN(tokens)); // 22
  }
}
// @lc code=end
