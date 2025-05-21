/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // Create graph adjacent
    List<List<Integer>> graph = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    // Store the in-degree of each node
    int[] inDegree = new int[numCourses];

    for (int[] pre : prerequisites) {
      graph.get(pre[1]).add(pre[0]);
      inDegree[pre[0]]++;
    }

    // Initialize queue
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        q.offer(i);
      }
    }

    // Topological sort
    List<Integer> sort = new ArrayList<>();

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int neighbour : graph.get(cur)) {
        if (--inDegree[neighbour] == 0) {
          q.offer(neighbour);
        }
      }

      sort.add(cur);
    }

    // Check for cycle
    if (sort.size() != numCourses) {
      return false;
    }

    return true;
  }

  // Time Complexity: O(V + E)
  // Space Complexity: O(V + E)
  // V is the number of vertices and E is the number of edges

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
    int numCourses = 4;
    System.out.println(solution.canFinish(numCourses, prerequisites)); // true

    int[][] prerequisites2 = {
      { 1, 0 },
      { 2, 0 },
      { 3, 1 },
      { 3, 2 },
      { 1, 3 },
    };
    int numCourses2 = 4;
    System.out.println(solution.canFinish(numCourses2, prerequisites2)); // false
  }
}
// @lc code=end
