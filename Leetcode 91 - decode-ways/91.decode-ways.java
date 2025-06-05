/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {

  public int numDecodings(String s) {
    int len = s.length();
    int[] dp = new int[len + 1];
    dp[len] = 1;

    for (int i = len - 1; i >= 0; i--) {
      // If the current character is '0', it cannot be decoded, so we set dp[i] to 0
      if (s.charAt(i) == '0') {
        dp[i] = 0;
      } else {
        // If the current character is not '0', it can be decoded as a single character, so we set dp[i] to dp[i + 1]
        dp[i] = dp[i + 1];

        // Check if the current character and the next character can form a valid encoding (10-26)
        if (
          i + 1 < len &&
          (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')
        ) {
          // If the current character and the next character can form a valid encoding, we add dp[i + 2] to dp[i]
          dp[i] += dp[i + 2];
        }
      }
    }

    return dp[0];
  }

  // Time Complexity : O(n)
  // Space Complexity : O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.numDecodings("12")); // 2
    System.out.println(solution.numDecodings("226")); // 3
    System.out.println(solution.numDecodings("0")); // 0
    System.out.println(solution.numDecodings("06")); // 0
    System.out.println(solution.numDecodings("11106")); // 2
  }
}
// @lc code=end
