/*
 * @lc app=leetcode id=242 lang=cpp
 *
 * [242] Valid Anagram
 */

// @lc code=start
#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
  bool isAnagram(string s, string t) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<char, int> countS;

    if (s.size() != t.size()) {
      return false;
    }

    for (int i = 0; i < s.size(); i++) {
      countS[s[i]]++;
      countS[t[i]]--;
    }

    for (const auto &pair : countS) {
      if (pair.second != 0) {
        return false;
      }
    }

    return true;
  }
};

int main() {
  Solution sol;

  cout << boolalpha;
  cout << sol.isAnagram("anagram", "nagaram") << "\n"; // true
  cout << sol.isAnagram("rat", "car");                 // false
}
// @lc code=end
