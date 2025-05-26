/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {

  public int minCostClimbingStairs(int[] cost) {
    int stairs = cost.length;

    int[] dp = new int[stairs + 1];
    dp[0] = 0;
    dp[1] = 0;

    for (int i = 2; i <= stairs; i++) {
      // dp[i] is the minimum cost to reach the i-th stair
      dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    }

    return dp[stairs];
  }

  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(
      solution.minCostClimbingStairs(new int[] { 10, 15, 20 })
    ); // 15
    System.out.println(
      solution.minCostClimbingStairs(
        new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }
      )
    ); // 6
  }
}
// @lc code=end
