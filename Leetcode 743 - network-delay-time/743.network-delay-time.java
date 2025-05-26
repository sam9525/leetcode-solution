/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

  public int networkDelayTime(int[][] times, int n, int k) {
    // Dijkstra's algo
    // Create the graph

    List<List<int[]>> graph = new ArrayList<>(n + 1);
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    // Building the adjacent
    for (int[] time : times) {
      graph.get(time[0]).add(new int[] { time[1], time[2] });
    }

    // List of the distnace to reach the node
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    // Initialize the distance to 0
    pq.add(new int[] { k, 0 });
    dist[k] = 0;

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int u = cur[0];

      // Traverse the neighbors
      for (int[] neighbor : graph.get(u)) {
        int v = neighbor[0];
        int weight = neighbor[1];

        // If the distance to the neighbor is less than the current distance, update the distance
        if (dist[v] > dist[u] + weight) {
          dist[v] = dist[u] + weight;
          pq.add(new int[] { v, dist[v] });
        }
      }
    }

    int max = 0;
    for (int i = 1; i <= n; i++) {
      max = Math.max(max, dist[i]);
    }

    return max == Integer.MAX_VALUE ? -1 : max;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
    int n = 4;
    int k = 2;
    System.out.println(solution.networkDelayTime(times, n, k)); // 2

    times = new int[][] { { 1, 2, 1 } };
    n = 2;
    k = 1;
    System.out.println(solution.networkDelayTime(times, n, k)); // 1
  }
}
// @lc code=end
