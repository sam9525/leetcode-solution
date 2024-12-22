/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

class Solution {
public:
  int lengthOfLongestSubstring(string s) {
    if (s.empty())
      return 0;

    unordered_set<char> letters;
    int left = 0, right = 0, maxSub = 0;

    while (right < s.size()) {
      if (letters.find(s[right]) == letters.end()) {
        letters.insert(s[right]);
        maxSub = max(maxSub, right - left + 1);
        right++;
      } else {
        letters.erase(s[left]);
        left++;
      }
    }

    return maxSub;
  }
};

int main() {
  Solution sol;

  string s = "abcabcbb";
  cout << sol.lengthOfLongestSubstring(s) << endl; // 3

  s = "bbbbb";
  cout << sol.lengthOfLongestSubstring(s) << endl; // 1

  s = "pwwkew";
  cout << sol.lengthOfLongestSubstring(s) << endl; // 3
}
// @lc code=end
