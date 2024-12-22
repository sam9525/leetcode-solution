/*
 * @lc app=leetcode id=392 lang=cpp
 *
 * [392] Is Subsequence
 */

// @lc code=start
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
  bool isSubsequence(string s, string t) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int i = 0, j = 0;
    while (j < t.size() && i < s.size()) {
      if (s[i] == t[j]) {
        i++;
      }
      j++;
    }
    return i == s.size();
  }
};

int main() {
  Solution sol;
  cout << boolalpha;
  cout << sol.isSubsequence("abc", "ahbgdc") << "\n"; // true
  cout << sol.isSubsequence("axc", "ahbgdc");         // false
}
// @lc code=end
