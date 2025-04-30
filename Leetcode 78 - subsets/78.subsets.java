/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    backtrack(nums, 0, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] nums, int start, List<Integer> subset) {
    if (start >= nums.length) {
      result.add(new ArrayList<>(subset));
      return;
    }

    subset.add(nums[start]);
    backtrack(nums, start + 1, subset);

    subset.remove(subset.size() - 1);
    backtrack(nums, start + 1, subset);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { 1, 2, 3 };
    for (List<Integer> subset : solution.subsets(nums)) {
      System.out.println(subset);
    } // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

    int[] nums2 = { 0 };
    for (List<Integer> subset : solution.subsets(nums2)) {
      System.out.println(subset);
    } // [[], [0]]
  }
}
// @lc code=end
