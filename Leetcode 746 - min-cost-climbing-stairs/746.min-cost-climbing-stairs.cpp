/*
 * @lc app=leetcode id=746 lang=cpp
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int minCostClimbingStairs(vector<int> &cost) {
    int n = cost.size();
    vector<int> dp(n + 1);

    dp[0] = 0;
    dp[1] = 0;

    for (int i = 2; i <= n; i++) {
      dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    }

    return dp[n];
  }
};

int main() {
  Solution sol;

  vector<int> cost1 = {10, 15, 20}; // 15
  cout << sol.minCostClimbingStairs(cost1) << endl;

  vector<int> cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}; // 6
  cout << sol.minCostClimbingStairs(cost2) << endl;
}
// @lc code=end
