/*
 * @lc app=leetcode id=13 lang=cpp
 *
 * [13] Roman to Integer
 */

// @lc code=start
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
  int romanToInt(string s) {
    int roman[128] = {};
    roman['I'] = 1;
    roman['V'] = 5;
    roman['X'] = 10;
    roman['L'] = 50;
    roman['C'] = 100;
    roman['D'] = 500;
    roman['M'] = 1000;
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      if (roman[s[i]] < roman[s[i + 1]]) {
        res -= roman[s[i]];
      } else {
        res += roman[s[i]];
      }
    }
    return res;
  }
};

int main() {
  Solution sol;
  cout << sol.romanToInt("LVIII") << "\n"; // 58
  cout << sol.romanToInt("MCMXCIV");       // 1994
}
// @lc code=end
