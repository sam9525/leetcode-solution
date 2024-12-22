/*
 * @lc app=leetcode id=994 lang=cpp
 *
 * [994] Rotting Oranges
 */

// @lc code=start

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  int orangesRotting(vector<vector<int>> &grid) {
    int count = 0, fresh = 0;
    queue<pair<int, int>> q;

    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[0].size(); j++) {
        if (grid[i][j] == 2) {
          q.push(make_pair(i, j));
        } else if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }

    while (!q.empty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        pair<int, int> cur = q.front();
        q.pop();

        static const int dx[] = {-1, 1, 0, 0};
        static const int dy[] = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
          int ni = cur.first + dx[i], nj = cur.second + dy[i];
          if (ni >= 0 && ni < grid.size() && nj >= 0 && nj < grid[0].size() &&
              grid[ni][nj] == 1) {
            grid[ni][nj] = 2;
            q.push(make_pair(ni, nj));
            fresh--;
          }
        }
      }

      if (!q.empty()) {
        count++;
      }
    }

    return fresh == 0 ? count : -1;
  }
};

int main() {
  Solution sol;

  vector<vector<int>> grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
  cout << sol.orangesRotting(grid) << endl; // 4

  grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
  cout << sol.orangesRotting(grid) << endl; // -1

  grid = {{0, 2}};
  cout << sol.orangesRotting(grid) << endl; // 0
}
// @lc code=end
