/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {

  // Right, left, top, bottom
  private final int[][] directions = {
    { 1, 0 },
    { -1, 0 },
    { 0, 1 },
    { 0, -1 },
  };

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;

    int rows = grid.length;
    int cols = grid[0].length;
    int islands = 0;

    // Go through all element
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          islands++;
        }
      }
    }

    return islands;
  }

  private void dfs(char[][] grid, int row, int col) {
    if (
      row < 0 ||
      row >= grid.length ||
      col < 0 ||
      col >= grid[0].length ||
      grid[row][col] == '0'
    ) {
      return;
    }

    // Vistied
    grid[row][col] = '0';

    // Explore all 4 directions
    for (int[] direction : directions) {
      dfs(grid, row + direction[0], col + direction[1]);
    }
  }
}
// @lc code=end
