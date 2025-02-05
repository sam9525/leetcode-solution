/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {

  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxWater = 0;

    while (left < right) {
      int h = Math.min(height[left], height[right]);
      maxWater = Math.max(maxWater, h * (right - left));

      // Move the pointer to the next higher bar
      if (height[left] <= height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxWater;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // 49
    System.out.println(sol.maxArea(new int[] { 1, 1 })); // 1
    System.out.println(sol.maxArea(new int[] { 2, 3, 10, 5, 7, 8, 9 })); // 36
  }
}
// @lc code=end
