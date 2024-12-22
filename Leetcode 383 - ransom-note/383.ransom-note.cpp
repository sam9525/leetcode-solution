/*
 * @lc app=leetcode id=383 lang=cpp
 *
 * [383] Ransom Note
 */

// @lc code=start

#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
  bool canConstruct(string ransomNote, string magazine) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    std::unordered_map<char, int> charCount;

    for (char c : magazine) {
      charCount[c]++;
    }

    for (char c : ransomNote) {
      if (charCount[c] == 0) {
        return false;
      }
      charCount[c]--;
    }
    return true;
  }
};

int main() {
  Solution sol;

  cout << boolalpha;
  cout << sol.canConstruct("a", "b") << "\n";    // false
  cout << sol.canConstruct("aa", "ab") << "\n";  // false
  cout << sol.canConstruct("aa", "aab") << "\n"; // true
  cout << sol.canConstruct(
      "bg",
      "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"); // true
}
// @lc code=end
