/*
 * @lc app=leetcode id=77 lang=cpp
 *
 * [77] Combinations
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> combine(int n, int k) {
    vector<vector<int>> result;
    vector<int> path;
    backtrack(n, k, 1, result, path);
    return result;
  }

private:
  void backtrack(int n, int k, int start, vector<vector<int>> &result,
                 vector<int> &path) {
    if (path.size() == k) {
      result.push_back(path);
      return;
    }

    for (int i = start; i <= n; i++) {
      path.push_back(i);
      backtrack(n, k, i + 1, result, path);
      path.pop_back();
    }
  }
};

int main() {
  Solution sol;

  vector<vector<int>> result = sol.combine(4, 2);
  for (const auto &comb : result) {
    for (int num : comb) {
      cout << num << " ";
    }
    cout << endl; // 1 2
                  // 1 3
                  // 1 4
                  // 2 3
                  // 2 4
                  // 3 4
  }

  result = sol.combine(1, 1);
  for (const auto &comb : result) {
    for (int num : comb) {
      cout << num << " ";
    }
    cout << endl; // 1
  }
}
// @lc code=end
