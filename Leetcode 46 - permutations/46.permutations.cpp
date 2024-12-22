/*
 * @lc app=leetcode id=46 lang=cpp
 *
 * [46] Permutations
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> permute(vector<int> &nums) {
    vector<vector<int>> result;
    backtrack(nums, 0, result);
    return result;
  }

private:
  void backtrack(vector<int> &nums, int start, vector<vector<int>> &result) {
    if (start == nums.size()) {
      result.push_back(nums);
      return;
    }

    for (int i = start; i < nums.size(); i++) {
      swap(nums[i], nums[start]);
      backtrack(nums, start + 1, result);
      swap(nums[i], nums[start]);
    }
  }
};

int main() {
  Solution sol;

  vector<int> nums = {1, 2, 3};
  vector<vector<int>> result = sol.permute(nums);
  for (const auto &perm : result) {
    for (int num : perm) {
      cout << num << " ";
    }
    cout << endl; // 1 2 3
                  // 1 3 2
                  // 2 1 3
                  // 2 3 1
                  // 3 1 2
                  // 3 2 1
  }

  nums = {0};
  result = sol.permute(nums);
  for (const auto &perm : result) {
    for (int num : perm) {
      cout << num << " ";
    }
    cout << endl; // 0
  }
}
// @lc code=end
