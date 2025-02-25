/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    int left = 0, right = m * n - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      int cur = matrix[mid / n][mid % n];

      if (cur == target) return true;

      if (cur > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
    int target = 3;
    System.out.println(solution.searchMatrix(matrix, target)); //true

    matrix =
      new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
    target = 13;
    System.out.println(solution.searchMatrix(matrix, target)); // false
  }
}
// @lc code=end
