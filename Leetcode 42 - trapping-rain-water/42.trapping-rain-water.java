/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {

  public int trap(int[] height) {
    int left = 0, right = height.length - 1, count = 0;

    // Record the max height of left and right that we have seen
    int maxLeft = 0, maxRight = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        // If the current height is less than the max height of left, we can trap water
        maxLeft = Math.max(maxLeft, height[left]);
        count += maxLeft - height[left];
        left++;
      } else {
        // If the current height is less than the max height of right, we can trap water
        maxRight = Math.max(maxRight, height[right]);
        count += maxRight - height[right];
        right--;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    System.out.println(sol.trap(height)); // 6

    height = new int[] { 4, 2, 0, 3, 2, 5 };
    System.out.println(sol.trap(height)); // 9

    height = new int[] { 5, 4, 1, 2 };
    System.out.println(sol.trap(height)); // 1
  }
}
// @lc code=end
