/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {

  public int countSubstrings(String s) {
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      // Odd length
      count += search(s, i, i);

      // Even length
      count += search(s, i, i + 1);
    }

    return count;
  }

  private int search(String s, int left, int right) {
    int count = 0;
    while (
      left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
    ) {
      count++;
      left--;
      right++;
    }
    return count;
  }

  // Time Complexity : O(n^2)
  // Sapce Complextiy : O(1)

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.countSubstrings("abc")); // 3
    System.out.println(solution.countSubstrings("aaa")); // 6
    System.out.println(solution.countSubstrings("babad")); // 7
  }
}
// @lc code=end
