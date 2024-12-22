/*
 * @lc app=leetcode id=1971 lang=cpp
 *
 * [1971] Find if Path Exists in Graph
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  bool validPath(int n, vector<vector<int>> &edges, int source,
                 int destination) {

    vector<bool> visited(n, false);
    queue<int> queue;
    vector<vector<int>> graph(n);

    for (const auto &edge : edges) {
      graph[edge[0]].push_back(edge[1]);
      graph[edge[1]].push_back(edge[0]);
    }

    visited[source] = true;
    queue.push(source);

    while (!queue.empty()) {
      int curr = queue.front();
      queue.pop();

      if (curr == destination) {
        return true;
      }

      for (int neighbor : graph[curr]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.push(neighbor);
        }
      }
    }

    return false;
  }
};

int main() {
  Solution sol;

  cout << boolalpha;
  vector<vector<int>> edges1 = {{0, 1}, {1, 2}, {2, 0}};
  cout << sol.validPath(3, edges1, 0, 2) << endl; // true

  vector<vector<int>> edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
  cout << sol.validPath(6, edges2, 0, 5) << endl; // false
}
// @lc code=end
