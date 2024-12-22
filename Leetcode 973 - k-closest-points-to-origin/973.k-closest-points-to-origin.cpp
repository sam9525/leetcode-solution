/*
 * @lc app=leetcode id=973 lang=cpp
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
#include <cmath>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> kClosest(vector<vector<int>> &points, int k) {
    // min-heap
    priority_queue<pair<double, pair<int, int>>,
                   vector<pair<double, pair<int, int>>>,
                   greater<pair<double, pair<int, int>>>>
        pq;

    for (auto &point : points) {
      double distance = sqrt(point[0] * point[0] + point[1] * point[1]);
      pq.push({distance, {point[0], point[1]}});
    }

    vector<vector<int>> result;
    for (int i = 0; i < k; i++) {
      result.push_back({pq.top().second.first, pq.top().second.second});
      pq.pop();
    }

    return result;
  }
};

int main() {
  Solution sol;

  vector<vector<int>> points = {{1, 3}, {-2, 2}};
  int k = 1;
  vector<vector<int>> result = sol.kClosest(points, k);
  for (auto &point : result) {
    cout << point[0] << " " << point[1] << endl;
  } // -2 2

  points = {{3, 3}, {5, -1}, {-2, 4}};
  k = 2;
  result = sol.kClosest(points, k);
  for (auto &point : result) {
    cout << point[0] << " " << point[1] << endl;
  } // -2 4 3 3
}
// @lc code=end
