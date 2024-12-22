/*
 * @lc app=leetcode id=1143 lang=cpp
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int longestCommonSubsequence(string text1, string text2) {
    vector<vector<int>> dp(text1.size() + 1, vector<int>(text2.size() + 1));

    for (int i = 1; i <= text1.size(); i++) {
      for (int j = 1; j <= text2.size(); j++) {
        if (text1[i - 1] == text2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[text1.size()][text2.size()];
  }
};

int main() {
  Solution sol;

  string text1 = "abcde";
  string text2 = "ace";
  cout << sol.longestCommonSubsequence(text1, text2) << endl; // 3

  text1 = "abc";
  text2 = "abc";
  cout << sol.longestCommonSubsequence(text1, text2) << endl; // 3

  text1 = "abc";
  text2 = "def";
  cout << sol.longestCommonSubsequence(text1, text2) << endl; // 0
}
// @lc code=end
