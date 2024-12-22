/*
 * @lc app=leetcode id=210 lang=cpp
 *
 * [210] Course Schedule II
 */

// @lc code=start
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> findOrder(int numCourses, vector<vector<int>> &prerequisites) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // create graph adjacent
    vector<vector<int>> graph(numCourses);
    // store the in-degree of each node
    vector<int> inDegree(numCourses, 0);

    for (const auto &pre : prerequisites) {
      graph[pre[1]].push_back(pre[0]);
      inDegree[pre[0]]++;
    }

    // init queue
    queue<int> q;
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        q.push(i);
      }
    }

    // topological sort
    vector<int> sort;

    while (!q.empty()) {
      int cur = q.front();
      q.pop();

      for (int neighbour : graph[cur]) {
        if (--inDegree[neighbour] == 0) {
          q.push(neighbour);
        }
      }

      sort.push_back(cur);
    }

    // check the cycle
    if (sort.size() != numCourses) {
      return {};
    }

    return sort;
  }
};

int main() {
  Solution sol;

  vector<vector<int>> prerequisites = {{1, 0}};
  auto res = sol.findOrder(2, prerequisites);
  for (int i : res) {
    cout << i << " ";
  }
  cout << endl; // [0, 1]

  prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
  res = sol.findOrder(4, prerequisites);
  for (int i : res) {
    cout << i << " ";
  }
  cout << endl; // [0, 1, 2, 3]

  prerequisites = {};
  res = sol.findOrder(1, prerequisites);
  for (int i : res) {
    cout << i << " ";
  }
  cout << endl; // [0]

  prerequisites = {{1, 0}, {1, 2}, {0, 1}};
  res = sol.findOrder(3, prerequisites);
  for (int i : res) {
    cout << i << " ";
  }
  cout << endl; // []
}
// @lc code=end
