/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {

  public int search(int[] nums, int target) {
    int n = nums.length;
    int left = 0, right = n - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) return mid;

      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { -1, 0, 3, 5, 9, 12 };
    int target = 9;
    int result = solution.search(nums, target);
    System.out.println(result); // 4

    nums = new int[] { -1, 0, 3, 5, 9, 12 };
    target = 2;
    result = solution.search(nums, target);
    System.out.println(result); // -1
  }
}
// @lc code=end
