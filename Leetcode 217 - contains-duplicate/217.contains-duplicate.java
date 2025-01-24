/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start

import java.util.HashSet;

class Solution {

  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    for (int num : nums) {
      if (!seen.add(num)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = { 1, 2, 3, 4 };
    System.out.println(solution.containsDuplicate(nums));

    int[] nums2 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
    System.out.println(solution.containsDuplicate(nums2));

    int[] nums3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    System.out.println(solution.containsDuplicate(nums3));
  }
}
// @lc code=end
