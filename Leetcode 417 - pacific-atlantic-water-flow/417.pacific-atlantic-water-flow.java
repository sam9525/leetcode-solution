/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int[][] directs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> result = new ArrayList<>();
    int rows = heights.length, cols = heights[0].length;
    boolean[][] pac = new boolean[rows][cols];
    boolean[][] atl = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      // start from the first column, and check if the cell is reachable from the pacific
      dfs(heights, i, 0, pac, -1);
      // start from the last column, and check if the cell is reachable from the atlantic
      dfs(heights, i, cols - 1, atl, -1);
    }

    for (int j = 0; j < cols; j++) {
      // start from the first row, and check if the cell is reachable from the pacific
      dfs(heights, 0, j, pac, -1);
      // start from the last row, and check if the cell is reachable from the atlantic
      dfs(heights, rows - 1, j, atl, -1);
    }

    // check if the cell is reachable from both the pacific and atlantic
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (pac[i][j] && atl[i][j]) {
          result.add(Arrays.asList(i, j));
        }
      }
    }

    return result;
  }

  // Time Complexity: O(m * n)
  // Space Complexity: O(m * n)

  private void dfs(
    int[][] heights,
    int i,
    int j,
    boolean[][] visited,
    int prev
  ) {
    if (
      i < 0 ||
      j < 0 ||
      i >= heights.length ||
      j >= heights[0].length ||
      visited[i][j] ||
      heights[i][j] < prev
    ) {
      return;
    }

    visited[i][j] = true;

    for (int[] direct : directs) {
      dfs(heights, i + direct[0], j + direct[1], visited, heights[i][j]);
    }
  }
}
// @lc code=end
