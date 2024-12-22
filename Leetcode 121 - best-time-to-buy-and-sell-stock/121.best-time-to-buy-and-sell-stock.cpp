/*
 * @lc app=leetcode id=121 lang=cpp
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  int maxProfit(vector<int> &prices) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int profit = 0;
    int lowestPrice = prices[0];
    for (int i = 0; i < prices.size(); i++) {
      if (lowestPrice > prices[i]) {
        lowestPrice = prices[i];
      } else if (prices[i] - lowestPrice > profit) {
        profit = prices[i] - lowestPrice;
      }
    }
    return profit;
  }
};

int main() {
  Solution sol;
  vector<int> prices1 = {7, 1, 5, 3, 6, 4}; // 5
  vector<int> prices2 = {7, 6, 4, 3, 1};    // 0
  vector<int> prices3 = {2, 4, 1};          // 2
  cout << sol.maxProfit(prices1) << "\n";
  cout << sol.maxProfit(prices2) << "\n";
  cout << sol.maxProfit(prices3);
}
// @lc code=end
