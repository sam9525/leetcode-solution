/*
 * @lc app=leetcode id=1584 lang=java
 *
 * [1584] Min Cost to Connect All Points
 */

// @lc code=start
import java.util.PriorityQueue;

class Solution {

  public int minCostConnectPoints(int[][] points) {
    // Prim's algorithm Modified
    int len = points.length;

    boolean[] visited = new boolean[len];

    // Store the key value of each vertex
    int[] key = new int[len];
    for (int i = 0; i < len; i++) {
      key[i] = Integer.MAX_VALUE;
      visited[i] = false;
    }

    // Priority queue to store the vertices and their key values
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[] { 0, 0 });

    key[0] = 0;

    int totalCost = 0;
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int u = cur[0];

      if (visited[u]) continue;
      visited[u] = true;
      totalCost += cur[1];

      // Update the key value of all the vertices adjacent to u
      for (int i = 0; i < len; i++) {
        if (visited[i]) continue;

        int dist =
          Math.abs(points[u][0] - points[i][0]) +
          Math.abs(points[u][1] - points[i][1]);

        // If the distance is less than the current key value, update the key value and add the vertex to the priority queue
        if (dist < key[i]) {
          key[i] = dist;
          pq.offer(new int[] { i, dist });
        }
      }
    }

    return totalCost;
  }

  // Time Complexity: O(n^2 log n)
  // Space Complexity: O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
    System.out.println(solution.minCostConnectPoints(points)); // 20

    int[][] points2 = { { 3, 12 }, { -2, 5 }, { -4, 1 } };
    System.out.println(solution.minCostConnectPoints(points2)); // 18
  }
}
// @lc code=end
