/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    backtrack(nums, new boolean[nums.length], new ArrayList<>());
    return result;
  }

  private void backtrack(int[] nums, boolean[] used, List<Integer> subset) {
    if (subset.size() == nums.length) {
      result.add(new ArrayList<>(subset));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }

      subset.add(nums[i]);
      used[i] = true;
      backtrack(nums, used, subset);
      subset.remove(subset.size() - 1);
      used[i] = false;
    }
  }

  // Time Complexity : O(n * n!)
  // Space Complexity : O(n * n!)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { 1, 2, 3 };
    List<List<Integer>> result = solution.permute(nums);

    for (List<Integer> list : result) {
      System.out.println(list);
    } // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

    int[] nums2 = { 0, 1 };
    List<List<Integer>> result2 = solution.permute(nums2);

    for (List<Integer> list : result2) {
      System.out.println(list);
    } // [[0, 1], [1, 0]]
  }
}
// @lc code=end
