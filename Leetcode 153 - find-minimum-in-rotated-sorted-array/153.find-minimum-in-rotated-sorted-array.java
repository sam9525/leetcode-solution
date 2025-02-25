/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start

class Solution {

  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] >= nums[high]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return nums[low];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { 3, 4, 5, 1, 2 };
    System.out.println(solution.findMin(nums)); // 1

    int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
    System.out.println(solution.findMin(nums2)); // 0

    int[] nums3 = { 11, 13, 15, 17 };
    System.out.println(solution.findMin(nums3)); // 11
  }
}
// @lc code=end
