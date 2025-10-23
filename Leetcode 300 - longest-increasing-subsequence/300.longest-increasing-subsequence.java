/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start

import java.util.Arrays;

class Solution {

  // Dynamic Programming (Bottom-up)
  public int lengthOfLIS(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    Arrays.fill(dp, 1);

    for (int i = len - 1; i >= 0; i--) {
      for (int j = i + 1; j < len; j++) {
        if (nums[i] < nums[j]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }

  // Time Complexity: O(n ^ 2)
  // Space Complexity: O(n)

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] nums1 = { 10, 9, 2, 5, 3, 7, 101, 18 };
    System.out.println(sol.lengthOfLIS(nums1)); // 4

    int[] nums2 = { 0, 1, 0, 3, 2, 3 };
    System.out.println(sol.lengthOfLIS(nums2)); // 4

    int[] nums3 = { 7, 7, 7, 7, 7, 7, 7 };
    System.out.println(sol.lengthOfLIS(nums3)); // 1

    int[] nums4 = { 4, 10, 4, 3, 8, 9 };
    System.out.println(sol.lengthOfLIS(nums4)); // 3

    int[] nums5 = { 9, 1, 4, 2, 3, 3, 7 };
    System.out.println(sol.lengthOfLIS(nums5)); // 4
  }
}
// @lc code=end
