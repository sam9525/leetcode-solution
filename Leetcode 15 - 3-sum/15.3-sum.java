/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      int left = i + 1, right = nums.length - 1;

      while (left < right) {
        int cur = nums[i] + nums[left] + nums[right];

        if (cur == 0) {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1]) left++;
          while (left < right && nums[right] == nums[right - 1]) right--;
          left++;
          right--;
        } else if (cur < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.threeSum(new int[] { -1, 0, 1, 2, -1, -4 })); // [[-1, 0, 1], [-1, -1, 2]]
    System.out.println(sol.threeSum(new int[] { 0, 1, 1 })); // []
    System.out.println(sol.threeSum(new int[] { 0, 0, 0 })); // [[0, 0, 0]]
  }
}
// @lc code=end
