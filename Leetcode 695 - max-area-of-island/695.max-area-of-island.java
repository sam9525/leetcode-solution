/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {

  // Right, Left, Top, Bottom
  private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int maxAreaOfIsland(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int maxIsland = 0;

    // Go through all elements in the grid
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          maxIsland = Math.max(maxIsland, dfs(grid, i, j));
        }
      }
    }

    return maxIsland;
  }

  private int dfs(int[][] grid, int row, int col) {
    if (
      row < 0 ||
      row >= grid.length ||
      col < 0 ||
      col >= grid[0].length ||
      grid[row][col] == 0
    ) {
      return 0;
    }

    // Mark the current cell as visited
    grid[row][col] = 0;
    int lands = 1;

    // Explore all four directions
    for (int[] direction : directions) {
      lands += dfs(grid, row + direction[0], col + direction[1]);
    }

    return lands;
  }

  // Time Complexity: O(n * m)
  // Space Complexity: O(n * m)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] grid = {
      { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
      { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
      { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
    };

    System.out.println(solution.maxAreaOfIsland(grid)); // 6
  }
}
// @lc code=end
