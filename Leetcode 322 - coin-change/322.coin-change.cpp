/*
 * @lc app=leetcode id=322 lang=cpp
 *
 * [322] Coin Change
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int coinChange(vector<int> &coins, int amount) {
    vector<int> dp(amount + 1, amount + 1);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }
};

int main() {
  Solution sol;

  vector<int> coins1 = {1, 2, 5};
  cout << sol.coinChange(coins1, 11) << endl; // 3

  vector<int> coins2 = {2};
  cout << sol.coinChange(coins2, 3) << endl; // -1

  vector<int> coins3 = {1};
  cout << sol.coinChange(coins3, 0) << endl; // 0

  vector<int> coins4 = {186, 419, 83, 408};
  cout << sol.coinChange(coins4, 6249) << endl; // 20
}
// @lc code=end
