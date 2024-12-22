/*
 * @lc app=leetcode id=39 lang=cpp
 *
 * [39] Combination Sum
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> combinationSum(vector<int> &candidates, int target) {
    vector<vector<int>> result;
    vector<int> path;
    backtrack(candidates, target, 0, result, path);
    return result;
  }

private:
  void backtrack(vector<int> &candidates, int target, int start,
                 vector<vector<int>> &result, vector<int> &path) {
    if (target == 0) {
      result.push_back(path);
      return;
    }

    for (int i = start; i < candidates.size(); i++) {
      if (candidates[i] > target) {
        continue;
      }
      path.push_back(candidates[i]);
      backtrack(candidates, target - candidates[i], i, result, path);
      path.pop_back();
    }
  }
};

int main() {
  Solution sol;

  vector<int> candidates = {2, 3, 6, 7};
  int target = 7;
  vector<vector<int>> result = sol.combinationSum(candidates, target);
  for (const auto &comb : result) {
    for (int num : comb) {
      cout << num << " ";
    }
    cout << endl; // 2 2 3
                  // 7
  }

  candidates = {2, 3, 5};
  target = 8;
  result = sol.combinationSum(candidates, target);
  for (const auto &comb : result) {
    for (int num : comb) {
      cout << num << " ";
    }
    cout << endl; // 2 3 3
                  // 3 5
  }
}
// @lc code=end
