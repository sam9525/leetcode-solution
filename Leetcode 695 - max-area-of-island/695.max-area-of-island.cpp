/*
 * @lc app=leetcode id=695 lang=cpp
 *
 * [695] Max Area of Island
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int maxAreaOfIsland(vector<vector<int>> &grid) {
    int n = grid.size();
    int m = grid[0].size();
    int maxIsland = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          maxIsland = max(maxIsland, dfs(grid, i, j));
        }
      }
    }

    return maxIsland;
  }

  int dfs(vector<vector<int>> &grid, int i, int j) {

    if (i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size() ||
        grid[i][j] != 1) {
      return 0;
    }

    grid[i][j] = 0;

    return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) +
           dfs(grid, i, j - 1);
  }
};

int main() {
  Solution sol;

  vector<vector<int>> grid1 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                               {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                               {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                               {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                               {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                               {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                               {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
  cout << sol.maxAreaOfIsland(grid1) << endl; // 6

  vector<vector<int>> grid2 = {{0, 0, 0, 0, 0, 0, 0, 0}};
  cout << sol.maxAreaOfIsland(grid2) << endl; // 0
}
// @lc code=end
