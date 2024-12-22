/*
 * @lc app=leetcode id=14 lang=cpp
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  string longestCommonPrefix(vector<string> &strs) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string newStr = "";

    for (int i = 0; i < strs[0].size(); i++) {
      int count = 0;
      for (int j = 0; j < strs.size(); j++) {
        char test = strs[0][i];
        char s = strs[j][i];
        if (test == s) {
          count++;
        } else {
          return newStr;
        }
        if (count == strs.size()) {
          newStr += test;
        }
      }
    }

    return newStr;
  }
};

int main() {
  Solution sol;
  vector<string> str1 = {"flower", "flow", "flight"}; // "fl"
  vector<string> str2 = {"dog", "racecar", "car"};    // ""
  vector<string> str3 = {"cir", "car"};               // "c"
  cout << sol.longestCommonPrefix(str1) << "\n";
  cout << sol.longestCommonPrefix(str2) << "\n";
  cout << sol.longestCommonPrefix(str3);
}
// @lc code=end
