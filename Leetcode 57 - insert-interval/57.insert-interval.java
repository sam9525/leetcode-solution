/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList<>();

    for (int[] interval : intervals) {
      if (newInterval == null || interval[1] < newInterval[0]) {
        res.add(interval);
      } else if (interval[0] > newInterval[1]) {
        res.add(newInterval);
        res.add(interval);
        newInterval = null;
      } else {
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      }
    }

    if (newInterval != null) res.add(newInterval);
    return res.toArray(new int[res.size()][]);
  }

  // Time complexity: O(n)
  // Space complexity: O(1)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] intervals = { { 1, 3 }, { 6, 9 } };
    int[] newInterval = { 2, 5 };
    int[][] result = solution.insert(intervals, newInterval);
    System.out.println(Arrays.deepToString(result)); // [[1, 5], [6, 9]]

    intervals =
      new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
    newInterval = new int[] { 4, 8 };
    result = solution.insert(intervals, newInterval);
    System.out.println(Arrays.deepToString(result)); // [[1, 2], [3, 10], [12, 16]]
  }
}
// @lc code=end
