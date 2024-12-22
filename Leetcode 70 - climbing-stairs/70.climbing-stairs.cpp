/*
 * @lc app=leetcode id=70 lang=cpp
 *
 * [70] Climbing Stairs
 */

// @lc code=start
#include <iostream>
using namespace std;
class Solution {
public:
  int climbStairs(int n) {
    int dp[n + 1];

    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
};

int main() {
  Solution sol;

  cout << sol.climbStairs(2) << endl; // 2
  cout << sol.climbStairs(3) << endl; // 3
}
// @lc code=end
