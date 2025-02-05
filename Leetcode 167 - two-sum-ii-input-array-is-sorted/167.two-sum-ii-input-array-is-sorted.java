/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start

import java.util.Arrays;

class Solution {

  public int[] twoSum(int[] numbers, int target) {
    // Two pointer problem
    int left = 0, right = numbers.length - 1;

    while (left < right) {
      int cur = numbers[left] + numbers[right];

      if (cur == target) {
        return new int[] { left + 1, right + 1 };
      }

      // If the current sum is bigger than the target, means we need to have a smaller number, so move the right pointer to the left, otherwise move the left pointer to the right
      if (cur > target) {
        right--;
      } else {
        left++;
      }
    }

    return new int[] { 0, 0 };
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(
      Arrays.toString(sol.twoSum(new int[] { 2, 7, 11, 15 }, 9))
    ); // [1, 2]
    System.out.println(Arrays.toString(sol.twoSum(new int[] { 2, 3, 4 }, 6))); // [1, 3]
    System.out.println(Arrays.toString(sol.twoSum(new int[] { -1, 0 }, -1))); // [1, 2]
  }
}
// @lc code=end
