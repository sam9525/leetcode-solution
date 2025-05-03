/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {

  boolean[][] visited;
  int rows;
  int cols;

  public boolean exist(char[][] board, String word) {
    rows = board.length;
    cols = board[0].length;
    visited = new boolean[rows][cols];

    // Loop through all nodes in the board
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (dfs(board, word, i, j, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(char[][] board, String word, int row, int col, int len) {
    if (len == word.length()) {
      return true;
    }

    // Check if the current node is out of bounds or already visited or the character is not the same as the current character
    if (
      row < 0 ||
      row >= rows ||
      col < 0 ||
      col >= cols ||
      visited[row][col] ||
      board[row][col] != word.charAt(len)
    ) {
      return false;
    }

    // Mark the current node as visited
    visited[row][col] = true;

    // Check all 4 directions
    boolean res =
      dfs(board, word, row + 1, col, len + 1) ||
      dfs(board, word, row - 1, col, len + 1) ||
      dfs(board, word, row, col + 1, len + 1) ||
      dfs(board, word, row, col - 1, len + 1);

    // Backtrack
    visited[row][col] = false;

    return res;
  }

  // Time Complexity: O(M×N×4^L), where M and N are board dimensions, L is word length
  // Space Complexity: O(M×N + L), where M×N is for visited matrix, L is recursion stack depth

  public static void main(String[] args) {
    Solution solution = new Solution();

    char[][] board = {
      { 'A', 'B', 'C', 'E' },
      { 'S', 'F', 'C', 'S' },
      { 'A', 'D', 'E', 'E' },
    };
    String word = "ABCCED";
    System.out.println(solution.exist(board, word)); // true

    board =
      new char[][] {
        { 'A', 'B', 'C', 'E' },
        { 'S', 'F', 'C', 'S' },
        { 'A', 'D', 'E', 'E' },
      };
    word = "SEE";
    System.out.println(solution.exist(board, word)); // true
  }
}
// @lc code=end
