/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {

  public int orangesRotting(int[][] grid) {
    // Top, Right, Bottom, Left
    int[][] directions = new int[][] {
      { -1, 0 },
      { 0, 1 },
      { 1, 0 },
      { 0, -1 },
    };
    int time = 0;
    int fresh = 0;
    int rows = grid.length, cols = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    // Iterate through all element in the graph
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // Count the fresh fruit
        if (grid[i][j] == 1) {
          fresh++;
        }
        // Put the rotten fruit in the queue
        if (grid[i][j] == 2) {
          queue.offer(new int[] { i, j });
        }
      }
    }

    while (fresh > 0 && !queue.isEmpty()) {
      // Number of rotten fruits
      int len = queue.size();
      // Rot the fresh fruit
      for (int i = 0; i < len; i++) {
        int[] cur = queue.poll();
        int r = cur[0];
        int c = cur[1];

        // Check all 4 directions
        for (int[] direction : directions) {
          int row = r + direction[0];
          int col = c + direction[1];
          if (
            row >= 0 &&
            row < grid.length &&
            col >= 0 &&
            col < grid[0].length &&
            grid[row][col] == 1
          ) {
            grid[row][col] = 2;
            queue.offer(new int[] { row, col });
            fresh--;
          }
        }
      }
      time++;
    }

    return fresh == 0 ? time : -1;
  }
}
// @lc code=end
