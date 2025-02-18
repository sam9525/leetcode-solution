/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>((int) Math.pow(2, n));
    helper(n, n, result, new StringBuilder(2 * n));
    return result;
  }

  private void helper(
    int open,
    int close,
    List<String> result,
    StringBuilder sb
  ) {
    if (open == 0 && close == 0) {
      result.add(sb.toString());
      return;
    }

    if (open > 0) {
      sb.append('(');
      helper(open - 1, close, result, sb);
      sb.setLength(sb.length() - 1);
    }

    if (open < close) {
      sb.append(')');
      helper(open, close - 1, result, sb);
      sb.setLength(sb.length() - 1);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.generateParenthesis(3)); // ["((()))","(()())","(())()","()(())","()()()"]

    System.out.println(solution.generateParenthesis(1)); // ["()"]

    System.out.println(solution.generateParenthesis(2)); // ["(())","()()"]
  }
}
// @lc code=end
