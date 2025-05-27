/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {

  public int rob(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];

    // First house
    dp[0] = nums[0];

    // Either rob the first house or the second house
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < len; i++) {
      // dp[i] is the maximum money we can rob from i houses
      // Either rob the i-th house and add the money from the (i-2)-th house
      // Or don't rob the i-th house and take the money from the (i-1)-th house
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }

    return dp[len - 1];
  }

  // Time Complexity : O(n)
  // Space Complexity : O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.rob(new int[] { 1, 2, 3, 1 })); // 4
    System.out.println(solution.rob(new int[] { 2, 7, 9, 3, 1 })); // 12
  }
}
// @lc code=end
