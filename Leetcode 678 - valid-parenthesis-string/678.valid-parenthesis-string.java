/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {

  public boolean checkValidString(String s) {
    int leftMin = 0, leftMax = 0;
    for (int i = 0; i < s.length(); i++) {
      int cur = s.charAt(i);

      if (cur == '(') {
        leftMin++;
        leftMax++;
      } else if (cur == ')') {
        leftMin--;
        leftMax--;
      } else {
        leftMin--;
        leftMax++;
      }

      if (leftMin < 0) {
        leftMin = 0;
      }

      if (leftMax < 0) {
        return false;
      }
    }

    return leftMin == 0;
  }

  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.checkValidString("()")); // true
    System.out.println(solution.checkValidString("(*)")); // true
    System.out.println(solution.checkValidString("(*))")); // true
    System.out.println(solution.checkValidString("((*)")); // true
    System.out.println(solution.checkValidString("((*))")); // true
    System.out.println(solution.checkValidString("((*)*)")); // true
  }
}
// @lc code=end
