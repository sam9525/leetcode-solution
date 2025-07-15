/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start

class Solution {

  public int maxProduct(int[] nums) {
    int res = nums[0];
    int curMin = 1, curMax = 1;

    for (int num : nums) {
      int tempMax = curMax * num;
      int tempMin = curMin * num;

      curMax = Math.max(Math.max(tempMax, tempMin), num);
      curMin = Math.min(Math.min(tempMax, tempMin), num);

      res = Math.max(res, curMax);
    }

    return res;
  }

  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { 2, 3, -2, 4 };
    System.out.println(solution.maxProduct(nums)); // 6

    nums = new int[] { -2, 0, -1 };
    System.out.println(solution.maxProduct(nums)); // 0
  }
}
// @lc code=end
