/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // Create graph adjacent
    List<List<Integer>> graph = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    // Store inDegree
    int[] inDegree = new int[numCourses];
    for (int[] preq : prerequisites) {
      graph.get(preq[1]).add(preq[0]);
      inDegree[preq[0]]++;
    }

    // Init queue
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    // Topological Sort
    int[] order = new int[numCourses];
    int finish = 0;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      order[finish++] = cur;

      for (int neighbour : graph.get(cur)) {
        if (--inDegree[neighbour] == 0) {
          queue.offer(neighbour);
        }
      }
    }

    // Check if all courses were completed
    if (finish != numCourses) {
      return new int[0];
    }

    return order;
  }
  // Time Complexity : O(V + E)
  // Space Complexity : O(V + E)
  // V is the number of vertices and E is the number of edges
}
// @lc code=end
