/*
 * @lc app=leetcode id=56 lang=cpp
 *
 * [56] Merge Intervals
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
  vector<vector<int>> merge(vector<vector<int>> &intervals) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    sort(intervals.begin(), intervals.end());

    if (intervals.empty())
      return {};

    vector<vector<int>> newNums;
    int start = intervals[0][0];
    int end = intervals[0][1];

    for (int i = 1; i < intervals.size(); i++) {
      if (intervals[i][0] <= end) {
        end = max(end, intervals[i][1]);
      } else {
        newNums.push_back({start, end});
        start = intervals[i][0];
        end = intervals[i][1];
      }
    }
    newNums.push_back({start, end});
    return newNums;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> nums1 = {
      {1, 3}, {2, 6}, {8, 10}, {15, 18}}; // {{1, 6}, {8, 10}, {15, 18}}
  vector<vector<int>> result1 = sol.merge(nums1);

  for (vector<int> nums : result1) {
    cout << "{";
    for (const int &num : nums) {
      cout << num << ",";
    }
    cout << "}";
  }
  cout << endl;

  vector<vector<int>> nums2 = {{1, 4}, {4, 5}}; // {{1, 5}}
  vector<vector<int>> result2 = sol.merge(nums2);

  for (vector<int> nums : result2) {
    cout << "{";
    for (const int &num : nums) {
      cout << num << ",";
    }
    cout << "}";
  }
  cout << endl;
}
// @lc code=end
