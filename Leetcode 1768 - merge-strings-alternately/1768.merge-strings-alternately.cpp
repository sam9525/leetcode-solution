/*
 * @lc app=leetcode id=1768 lang=cpp
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
#include <iostream>
#include <string>

using namespace std;
class Solution {
public:
  string mergeAlternately(string word1, string word2) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string newString = "";
    int i = 0;
    while (i < word1.size() || i < word2.size()) {
      if (i < word1.size()) {
        newString += word1[i];
      }
      if (i < word2.size()) {
        newString += word2[i];
      }
      i++;
    }
    return newString;
  }
};

int main() {
  Solution sol;
  cout << sol.mergeAlternately("abc", "pqr") << "\n"; // apbqcr
  cout << sol.mergeAlternately("ab", "pqrs") << "\n"; // apbqrs
  cout << sol.mergeAlternately("abcd", "pq") << "\n"; // apbqcd
  return 0;
}
// @lc code=end
