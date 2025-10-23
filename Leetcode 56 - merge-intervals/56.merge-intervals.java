/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> newIntervals = new ArrayList<>();
    newIntervals.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int lastEnd = newIntervals.getLast()[1];

      // Combine if the end_i is larger than start_j
      // Update the end_i to the maximum of end_i and end_j
      if (lastEnd >= intervals[i][0]) {
        newIntervals.getLast()[1] = Math.max(lastEnd, intervals[i][1]);
      } else {
        newIntervals.add(intervals[i]);
      }
    }

    return newIntervals.toArray(new int[newIntervals.size()][]);
  }

  // Time Complexity: O(n log n)
  // Time Complexity: O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    int[][] result = solution.merge(intervals);
    System.out.println(Arrays.deepToString(result)); // [[1, 6], [8, 10], [15, 18]]

    intervals = new int[][] { { 1, 4 }, { 4, 5 } };
    result = solution.merge(intervals);
    System.out.println(Arrays.deepToString(result)); // [[1, 5]]

    intervals = new int[][] { { 4, 7 }, { 1, 4 } };
    result = solution.merge(intervals);
    System.out.println(Arrays.deepToString(result)); // [[1, 7]]

    intervals =
      new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
    result = solution.merge(intervals);
    System.out.println(Arrays.deepToString(result)); // [[1, 10]]
  }
}
// @lc code=end
