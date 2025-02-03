/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start

import java.util.Arrays;

class Solution {

  public int[] productExceptSelf(int[] nums) {
    // Prefix and Suffix product
    int[] newNums = new int[nums.length];
    Arrays.fill(newNums, 1);

    // Prefix product
    int leftSum = 1;
    for (int i = 0; i < nums.length; i++) {
      newNums[i] *= leftSum;
      leftSum *= nums[i];
    }

    // Suffix product
    int rightSum = 1;
    for (int j = nums.length - 1; j >= 0; j--) {
      newNums[j] *= rightSum;
      rightSum *= nums[j];
    }

    return newNums;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(
      Arrays.toString(sol.productExceptSelf(new int[] { 1, 2, 3, 4 }))
    ); // [24, 12, 8, 6]
    System.out.println(
      Arrays.toString(sol.productExceptSelf(new int[] { -1, 1, 0, -3, 3 }))
    ); // [0, 0, 9, 0, 0]
  }
}
// @lc code=end
