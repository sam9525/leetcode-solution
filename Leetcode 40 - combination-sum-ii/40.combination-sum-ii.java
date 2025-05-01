/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    backtrack(candidates, 0, target, new ArrayList<>());
    return result;
  }

  private void backtrack(
    int[] candidates,
    int start,
    int target,
    List<Integer> subset
  ) {
    if (target == 0) {
      if (!result.contains(subset)) {
        result.add(new ArrayList<>(subset));
        return;
      }
    }

    if (target < 0 && start > candidates.length) {
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      // Avoid duplicates
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }

      subset.add(candidates[start]);
      backtrack(candidates, start + 1, target - candidates[start], subset);
      subset.remove(subset.size() - 1);
    }
  }

  // Time complexity : O(n * 2^n)
  // Space complexity : O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
    int target = 8;
    for (List<Integer> combination : solution.combinationSum2(
      candidates,
      target
    )) {
      System.out.println(combination);
    } // [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

    int[] candidates2 = { 2, 5, 2, 1, 2 };
    int target2 = 5;
    for (List<Integer> combination : solution.combinationSum2(
      candidates2,
      target2
    )) {
      System.out.println(combination);
    } // [[1, 2, 2], [5]]
  }
}
// @lc code=end
