/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start

class Solution {

  public int lengthOfLIS(int[] nums) {
    return helper(nums, 0, -1);
  }

  // Recursion
  // Checking from backward
  private int helper(int[] nums, int i, int j) {
    if (i == nums.length) return 0;

    int LIS = helper(nums, i + 1, j);

    if (j == -1 || nums[i] > nums[j]) {
      LIS = Math.max(LIS, 1 + helper(nums, i + 1, i));
    }

    return LIS;
  }

  // Time Complexity: O(2 ^ n)
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
  }
}
// @lc code=end
