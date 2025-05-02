/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    backtrack(nums, 0, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] nums, int start, List<Integer> subset) {
    result.add(new ArrayList<>(subset));

    for (int i = start; i < nums.length; i++) {
      // skip duplicates
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }

      subset.add(nums[i]);
      backtrack(nums, i + 1, subset);
      subset.remove(subset.size() - 1);
    }
  }

  // Time Complexity : O(n * 2^n)
  // Space Complexity : O(n * 2^n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { 1, 2, 2 };
    List<List<Integer>> result = solution.subsetsWithDup(nums);
    for (List<Integer> list : result) {
      System.out.println(list);
    } // [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]

    int[] nums2 = { 0 };
    List<List<Integer>> result2 = solution.subsetsWithDup(nums2);
    for (List<Integer> list : result2) {
      System.out.println(list);
    } // [[], [0]]
  }
}
// @lc code=end
