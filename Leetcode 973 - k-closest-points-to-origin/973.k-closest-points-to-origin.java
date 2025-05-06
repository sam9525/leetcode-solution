/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  public int[][] kClosest(int[][] points, int k) {
    // Sort based on their distance to the origin
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
      Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1])
    );

    // Add points to the priority queue
    for (int[] point : points) {
      pq.add(point);
    }

    // Get the k closest points
    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
      result[i] = pq.poll();
    }

    return result;
  }

  // Time Complexity : O(n log n)
  // Space Complexity : O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(
      Arrays.deepToString(
        solution.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1)
      )
    ); // [[-2, 2]]

    System.out.println(
      Arrays.deepToString(
        solution.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)
      )
    ); // [[3, 3], [-2, 4]]
  }
}
// @lc code=end
