/*
 * @lc app=leetcode id=983 lang=cpp
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int mincostTickets(vector<int> &days, vector<int> &costs) {
    const int lastDay = days.back();
    vector<int> dp(lastDay + 1, 0);
    int dayIndex = 0;

    for (int i = 1; i <= lastDay; i++) {
      if (days[dayIndex] != i) {
        dp[i] = dp[i - 1];
        continue;
      }

      dp[i] = min({dp[max(0, i - 1)] + costs[0], dp[max(0, i - 7)] + costs[1],
                   dp[max(0, i - 30)] + costs[2]});

      dayIndex++;
    }

    return dp[lastDay];
  }
};

int main() {
  Solution sol;

  vector<int> days1 = {1, 4, 6, 7, 8, 20};
  vector<int> costs1 = {2, 7, 15};
  cout << sol.mincostTickets(days1, costs1) << endl; // 11

  vector<int> days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
  vector<int> costs2 = {2, 7, 15};
  cout << sol.mincostTickets(days2, costs2) << endl; // 17
}
// @lc code=end
