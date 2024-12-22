/*
 * @lc app=leetcode id=78 lang=cpp
 *
 * [78] Subsets
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> subsets(vector<int> &nums) {
    int n = nums.size();
    vector<vector<int>> result;
    for (int mask = 0; mask < (1 << n); mask++) {
      vector<int> subset;
      for (int i = 0; i < n; i++) {
        if (mask & (1 << i)) {
          subset.push_back(nums[i]);
        }
      }
      result.push_back(subset);
    }
    return result;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {1, 2, 3};
  vector<vector<int>> result = sol.subsets(nums);
  for (const auto &subset : result) {
    for (int num : subset) {
      cout << num << " ";
    }
    cout << endl; // 1 2 3
                  // 1 2
                  // 1 3
                  // 1
                  // 2 3
                  // 2
                  // 3
                  //
  }

  nums = {0};
  result = sol.subsets(nums);
  for (const auto &subset : result) {
    for (int num : subset) {
      cout << num << " ";
    }
    cout << endl; // 0
  }
  // @lc code=end
