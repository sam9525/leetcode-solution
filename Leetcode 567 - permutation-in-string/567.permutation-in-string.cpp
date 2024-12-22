/*
 * @lc app=leetcode id=567 lang=cpp
 *
 * [567] Permutation in String
 */

// @lc code=start
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  bool checkInclusion(string s1, string s2) {
    // unordered_map<char, int> s1Map;
    // for (char c : s1) {
    //   s1Map[c]++;
    // }

    vector<int> s1LetterCount(26, 0);
    for (int i = 0; i < s1.size(); i++) {
      s1LetterCount[s1[i] - 'a']++;
    }

    int left = 0, right = s1.size() - 1;

    while (right < s2.size()) {
      //   unordered_map<char, int> s1MapCopy = s1Map;
      //   for (int i = left; i <= right; i++) {
      //     if (s1MapCopy.find(s2[i]) != s1MapCopy.end()) {
      //       s1MapCopy[s2[i]]--;
      //     }
      //     if (s1MapCopy[s2[i]] == 0) {
      //       s1MapCopy.erase(s2[i]);
      //     }
      //   }

      //   if (s1MapCopy.empty()) {
      //     return true;
      //   }

      vector<int> s2LetterCount(26, 0);

      for (int i = left; i <= right; i++) {
        s2LetterCount[s2[i] - 'a']++;
      }

      if (s1LetterCount == s2LetterCount)
        return true;

      left++;
      right++;
    }

    return false;
  }
};

int main() {
  Solution sol;

  cout << boolalpha << endl;
  cout << sol.checkInclusion("ab", "eidbaooo") << endl; // true
  cout << sol.checkInclusion("ab", "eidboaoo") << endl; // false
}
// @lc code=end
