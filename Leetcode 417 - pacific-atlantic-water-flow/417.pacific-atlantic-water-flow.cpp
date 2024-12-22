/*
 * @lc app=leetcode id=417 lang=cpp
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> pacificAtlantic(vector<vector<int>> &heights) {
    vector<vector<int>> res;
    int m = heights.size(), n = heights[0].size();
    vector<vector<bool>> pacific(m, vector<bool>(n, false));
    vector<vector<bool>> atlantic(m, vector<bool>(n, false));

    for (int i = 0; i < m; i++) {
      dfs(i, 0, heights, pacific, -1);
      dfs(i, n - 1, heights, atlantic, -1);
    }
    for (int j = 0; j < n; j++) {
      dfs(0, j, heights, pacific, -1);
      dfs(m - 1, j, heights, atlantic, -1);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          res.push_back({i, j});
        }
      }
    }

    return res;
  }

  void dfs(int i, int j, vector<vector<int>> &heights,
           vector<vector<bool>> &visited, int prev) {
    if (i < 0 || j < 0 || i >= heights.size() || j >= heights[0].size() ||
        visited[i][j] || heights[i][j] < prev) {
      return;
    }

    visited[i][j] = true;

    dfs(i + 1, j, heights, visited, heights[i][j]);
    dfs(i - 1, j, heights, visited, heights[i][j]);
    dfs(i, j + 1, heights, visited, heights[i][j]);
    dfs(i, j - 1, heights, visited, heights[i][j]);
  }
};

int main() {
  Solution sol;

  vector<vector<int>> heights = {{1, 2, 2, 3, 5},
                                 {3, 2, 3, 4, 4},
                                 {2, 4, 5, 3, 1},
                                 {6, 7, 1, 4, 5},
                                 {5, 1, 1, 2, 4}};
  vector<vector<int>> result = sol.pacificAtlantic(heights);
  for (auto &row : result) {
    for (auto &col : row) {
      cout << col << " ";
    }
    cout << endl;
  }
  // {0, 4}, {1, 3}, {1, 4}, {2, 2}, {3, 0}, {3, 1}, {4, 0}

  //   heights = {{1}};
  //   result = sol.pacificAtlantic(heights);
  //   for (auto &row : result) {
  //     for (auto &col : row) {
  //       cout << col << " ";
  //     }
  //     cout << endl;
  //   }
  // {0, 0}
}
// @lc code=end
