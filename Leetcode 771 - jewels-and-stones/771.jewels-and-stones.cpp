/*
 * @lc app=leetcode id=771 lang=cpp
 *
 * [771] Jewels and Stones
 */

// @lc code=start
#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
  int numJewelsInStones(string jewels, string stones) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<char, int> count;

    for (char c : jewels) {
      for (char cs : stones) {
        if (cs == c) {
          count[c]++;
        }
      }
    }

    int totalCount = 0;
    for (const auto &pair : count) {
      totalCount += pair.second;
    }

    return totalCount;
  }
};

int main() {
  Solution sol;
  cout << sol.numJewelsInStones("aA", "aAAbbbb") << "\n"; // 3
  cout << sol.numJewelsInStones("z", "ZZ");               // 0
}
// @lc code=end
