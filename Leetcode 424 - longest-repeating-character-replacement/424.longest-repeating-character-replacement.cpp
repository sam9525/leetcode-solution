/*
 * @lc app=leetcode id=424 lang=cpp
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int characterReplacement(string s, int k) {
    vector<int> count(26, 0);
    int left = 0, maxCount = 0, result = 0;

    for (int right = 0; right < s.size(); right++) {
      count[s[right] - 'A']++;
      maxCount = max(maxCount, count[s[right] - 'A']);

      if ((right - left + 1) - maxCount > k) {
        count[s[left] - 'A']--;
        left++;
      }

      result = max(result, right - left + 1);
    }

    return result;
  }
};

int main() {
  Solution sol;

  string s = "ABAB";
  int k = 2;
  cout << sol.characterReplacement(s, k) << endl; // 4

  s = "AABABBA";
  k = 1;
  cout << sol.characterReplacement(s, k) << endl; // 4
}
// @lc code=end
