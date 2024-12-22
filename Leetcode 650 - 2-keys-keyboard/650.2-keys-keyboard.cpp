/*
 * @lc app=leetcode id=650 lang=cpp
 *
 * [650] 2 Keys Keyboard
 */

// @lc code=start
#include <iostream>
#include <vector>
using namespace std;

// copy, paste, paste, paste (4),
class Solution {
public:
  int minSteps(int n) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    if (n == 1)
      return 0;

    vector<int> dp(n + 1, 0);

    for (int i = 2; i <= n; i++) {
      dp[i] = i;
      for (int j = i - 1; j > 1; j--) {
        if (i % j == 0) {
          dp[i] = min(dp[i], dp[j] + i / j);
          break;
        }
      }
    }

    return dp[n];
  }
};

int main() {
  Solution sol;

  cout << sol.minSteps(3) << endl; // 3
  cout << sol.minSteps(4) << endl; // 4
  cout << sol.minSteps(8) << endl; // 6
}
// @lc code=end
