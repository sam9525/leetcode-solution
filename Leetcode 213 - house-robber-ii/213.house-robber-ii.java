/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start

import java.util.Arrays;

class Solution {

  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];

    // Split the problem into two subproblems
    // 1. Rob the first house
    // 2. Don't rob the first house
    return Math.max(
      helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
      helper(Arrays.copyOfRange(nums, 1, nums.length))
    );
  }

  private int helper(int[] nums) {
    int len = nums.length;

    int[] dp = new int[len];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    // Either rob the i-th house or not
    for (int i = 2; i < len; i++) {
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }

    return dp[len - 1];
  }

  // Time Complexity: O(n)
  // Space Complexity: O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.rob(new int[] { 2, 3, 2 })); // 3
    System.out.println(solution.rob(new int[] { 1, 2, 3, 1 })); // 3
  }
}
// @lc code=end
