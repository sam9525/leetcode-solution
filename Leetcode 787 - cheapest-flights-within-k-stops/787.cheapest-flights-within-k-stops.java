/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  public int findCheapestPrice(
    int n,
    int[][] flights,
    int src,
    int dst,
    int k
  ) {
    // Build adjacent with the price
    List<int[]>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      adj[flights[i][0]].add(new int[] { flights[i][1], flights[i][2] });
    }

    int[] price = new int[n];
    for (int i = 0; i < n; i++) {
      price[i] = Integer.MAX_VALUE;
    }

    // Store {cost, node, stop}
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { 0, src, 0 });
    price[src] = 0;

    // Find the minmum cost for each node
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curCost = cur[0], node = cur[1], stop = cur[2];

      if (stop > k) continue;

      for (int[] neighbour : adj[node]) {
        int v = neighbour[0], w = neighbour[1];

        if (w + curCost < price[v]) {
          price[v] = w + curCost;
          queue.offer(new int[] { price[v], v, stop + 1 });
        }
      }
    }

    return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
  }

  // Time Complexity: O(n * k)
  // Space Complexity: O(n + m)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 4;
    int[][] flights = {
      { 0, 1, 100 },
      { 1, 2, 100 },
      { 2, 0, 100 },
      { 1, 3, 600 },
      { 2, 3, 200 },
    };
    int src = 0;
    int dst = 3;
    int k = 1;
    System.out.println(solution.findCheapestPrice(n, flights, src, dst, k)); // 700

    n = 3;
    flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
    src = 0;
    dst = 2;
    k = 1;
    System.out.println(solution.findCheapestPrice(n, flights, src, dst, k)); // 200

    n = 3;
    flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
    src = 0;
    dst = 2;
    k = 0;
    System.out.println(solution.findCheapestPrice(n, flights, src, dst, k)); // 500
  }
}
// @lc code=end
