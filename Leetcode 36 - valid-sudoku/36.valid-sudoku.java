/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {

  public boolean isValidSudoku(char[][] board) {
    // Traverse the board
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (!isValid(board, i, j, board[i][j])) {
            return false;
          }
        }
      }
    }

    return true;
  }

  public boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      // Check row
      if (board[row][i] == c && col != i) {
        return false;
      }
      // Check column
      if (board[i][col] == c && row != i) {
        return false;
      }
      // Check 3x3 sub-box
      if (
        (3 * (row / 3) + i / 3) != row &&
        (3 * (col / 3) + i % 3) != col &&
        board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c
      ) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(
      sol.isValidSudoku(
        new char[][] {
          { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
          { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
          { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
          { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
          { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
          { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
          { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
          { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
          { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
        }
      )
    ); // true
    System.out.println(
      sol.isValidSudoku(
        new char[][] {
          { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
          { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
          { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
          { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
          { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
          { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
          { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
          { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
          { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
        }
      )
    ); // false
  }
}
// @lc code=end
