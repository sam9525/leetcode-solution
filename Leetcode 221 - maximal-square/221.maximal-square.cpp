/*
 * @lc app=leetcode id=221 lang=cpp
 *
 * [221] Maximal Square
 */

// @lc code=start

#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  int maximalSquare(vector<vector<char>> &matrix) {
    if (matrix.empty() || matrix[0].empty())
      return 0;

    vector<int> dp(matrix[0].size() + 1, 0);
    int max_square = 0, prev = 0;

    for (int i = 1; i <= matrix.size(); i++) {
      for (int j = 1; j <= matrix[0].size(); j++) {
        int temp = dp[j];
        if (matrix[i - 1][j - 1] == '1') {
          dp[j] = min({dp[j], dp[j - 1], prev}) + 1;
          max_square = max(max_square, dp[j]);
        } else {
          dp[j] = 0;
        }
        prev = temp;
      }
    }

    return max_square * max_square;
  }
};

int main() {
  Solution sol;

  vector<vector<char>> matrix = {{'1', '0', '1', '0', '0'},
                                 {'1', '0', '1', '1', '1'},
                                 {'1', '1', '1', '1', '1'},
                                 {'1', '0', '0', '1', '0'}};
  cout << sol.maximalSquare(matrix) << endl; // 4

  matrix = {{'0', '1'}, {'1', '0'}};
  cout << sol.maximalSquare(matrix) << endl; // 1

  matrix = {{'0'}};
  cout << sol.maximalSquare(matrix) << endl; // 0

  matrix = {{'0', '1'}};
  cout << sol.maximalSquare(matrix) << endl; // 1
}
// @lc code=end
