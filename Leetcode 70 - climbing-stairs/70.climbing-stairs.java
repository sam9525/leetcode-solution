/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {

  public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.climbStairs(2)); // 2
    System.out.println(solution.climbStairs(3)); // 3
  }
}
// @lc code=end
