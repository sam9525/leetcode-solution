/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {

  public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] == target) return mid;

      if (nums[mid] >= nums[low]) {
        // Check if target is in left half
        if (nums[low] <= target && nums[mid] > target) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        // Check if target is in right half
        if (nums[mid] < target && nums[high] >= target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
    int target = 0;
    System.out.println(solution.search(nums, target)); // 4

    nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
    target = 3;
    System.out.println(solution.search(nums, target)); // -1

    nums = new int[] { 1 };
    target = 0;
    System.out.println(solution.search(nums, target)); // -1
  }
}
// @lc code=end
