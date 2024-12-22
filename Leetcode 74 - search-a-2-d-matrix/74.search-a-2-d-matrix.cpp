/*
 * @lc app=leetcode id=74 lang=cpp
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  bool searchMatrix(vector<vector<int>> &matrix, int target) {
    int n = matrix.size();
    int m = matrix[0].size();
    int low = 0, high = n * m - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int row = mid / m;
      int col = mid % n;

      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return false;
  }
};

int main() {
  Solution sol;

  vector<vector<int>> matrix = {
      {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
  int target = 3;

  cout << boolalpha << endl;
  cout << sol.searchMatrix(matrix, target) << endl; // true

  target = 13;
  cout << sol.searchMatrix(matrix, target) << endl; // false
}
// @lc code=end
