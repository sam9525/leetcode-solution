/*
 * @lc app=leetcode id=1189 lang=cpp
 *
 * [1189] Maximum Number of Balloons
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
  int maxNumberOfBalloons(string text) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<char, int> charCount;

    for (char c : text) {
      charCount[c]++;
    }

    int countB = charCount['b'];
    int countA = charCount['a'];
    int countL = charCount['l'] / 2;
    int countO = charCount['o'] / 2;
    int countN = charCount['n'];

    return min({countB, countA, countL, countO, countN});
  }
};

int main() {
  Solution sol;

  cout << sol.maxNumberOfBalloons("nlaebolko") << "\n";        // 1
  cout << sol.maxNumberOfBalloons("loonbalxballpoon") << "\n"; // 2
  cout << sol.maxNumberOfBalloons("leetcode") << "\n";         // 0
}
// @lc code=end
