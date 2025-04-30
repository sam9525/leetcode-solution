/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
      result.add(new ArrayList<>(subset));
      return;
    }

    if (target < 0 || start >= candidates.length) {
      return;
    }

    subset.add(candidates[start]);
    backtrack(candidates, start, target - candidates[start], subset);

    subset.remove(subset.size() - 1);
    backtrack(candidates, start + 1, target, subset);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] candidates = { 2, 3, 6, 7 };
    int target = 7;
    for (List<Integer> combination : solution.combinationSum(
      candidates,
      target
    )) {
      System.out.println(combination);
    } // [[2, 2, 3], [7]]

    int[] candidates2 = { 2, 3, 5 };
    int target2 = 8;
    for (List<Integer> combination : solution.combinationSum(
      candidates2,
      target2
    )) {
      System.out.println(combination);
    } // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
  }
}
// @lc code=end
