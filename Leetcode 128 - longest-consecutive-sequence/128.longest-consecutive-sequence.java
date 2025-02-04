/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;

    // Add all numbers to a set
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int res = 0;

    for (int num : numSet) {
      // Find the smallest number in the sequence
      if (!numSet.contains(num - 1)) {
        int cur = num;
        int curLong = 1;

        // Count the length of the sequence
        while (numSet.contains(cur + 1)) {
          cur++;
          curLong++;
        }

        // Update the result
        res = Math.max(res, curLong);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(
      sol.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 })
    ); // 4
    System.out.println(
      sol.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 })
    ); // 9
  }
}
// @lc code=end
