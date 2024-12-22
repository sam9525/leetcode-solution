/*
 * @lc app=leetcode id=207 lang=cpp
 *
 * [207] Course Schedule
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  bool canFinish(int numCourses, vector<vector<int>> &prerequisites) {
    // create adjacent
    vector<vector<int>> graph(numCourses);
    vector<int> inDegree(numCourses, 0);

    for (const auto &pres : prerequisites) {
      graph[pres[1]].push_back(pres[0]);
      inDegree[pres[0]]++;
    }

    // put all element that have in-degree 0
    queue<int> q;

    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        q.push(i);
      }
    }

    // topological sort
    int visited = 0;

    while (!q.empty()) {
      int cur = q.front();
      q.pop();
      visited++;

      for (int neighbour : graph[cur]) {
        if (--inDegree[neighbour] == 0) {
          q.push(neighbour);
        }
      }
    }

    return visited == numCourses;
  }
};

// ... main function remains unchanged ...

int main() {
  Solution sol;

  cout << boolalpha;
  vector<vector<int>> prerequisites1 = {{1, 0}};
  cout << sol.canFinish(2, prerequisites1) << endl; // true

  vector<vector<int>> prerequisites2 = {{1, 0}, {0, 1}};
  cout << sol.canFinish(2, prerequisites2) << endl; // false

  vector<vector<int>> prerequisites3 = {{0, 1}, {1, 2}};
  cout << sol.canFinish(3, prerequisites3) << endl; // true
}
// @lc code=end
