/*
 * @lc app=leetcode id=344 lang=cpp
 *
 * [344] Reverse String
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  void reverseString(vector<char> &s) {
    int j = s.size() - 1;
    for (int i = 0; i < s.size() / 2; i++) {
      swap(s[i], s[j - i]);
    }
  }
};

int main() {
  Solution sol;
  vector<char> s = {'h', 'e', 'l', 'l', 'o'}; // o l l e h
  sol.reverseString(s);
  for (char c : s) {
    cout << c << " ";
  }
  cout << endl;

  vector<char> s2 = {'H', 'a', 'n', 'n', 'a', 'h'}; // h a n n a H
  sol.reverseString(s2);
  for (char c : s2) {
    cout << c << " ";
  }
  cout << endl;
}
// @lc code=end
