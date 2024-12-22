/*
 * @lc app=leetcode id=125 lang=cpp
 *
 * [125] Valid Palindrome
 */

// @lc code=start
#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
  bool isPalindrome(string s) {
    int left = 0, right = s.size() - 1;

    while (left < right) {
      while (left < right && !isalnum(s[left])) {
        left++;
      }
      while (left < right && !isalnum(s[right])) {
        right--;
      }
      if (tolower(s[left]) != tolower(s[right])) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }
};

int main() {
  Solution sol;

  cout << boolalpha;
  string s = "A man, a plan, a canal: Panama";
  cout << sol.isPalindrome(s) << endl; // true

  string s2 = "race a car";
  cout << sol.isPalindrome(s2) << endl; // false

  return 0;
}
// @lc code=end
