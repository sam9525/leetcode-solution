/*
 * @lc app=leetcode id=22 lang=cpp
 *
 * [22] Generate Parentheses
 */

// @lc code=start
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  void generateParenthesisHelper(int open, int close, string s,
                                 vector<string> &result) {
    if (open == 0 && close == 0) {
      result.push_back(s);
      return;
    }

    if (open > 0) {
      string cur = s + '(';
      generateParenthesisHelper(open - 1, close, cur, result);
    }

    if (open < close) {
      string cur = s + ')';
      generateParenthesisHelper(open, close - 1, cur, result);
    }
  }
  vector<string> generateParenthesis(int n) {
    vector<string> result;
    string s = "";
    generateParenthesisHelper(n, n, s, result);
    return result;
  }
};

int main() {
  Solution sol;

  vector<string> result = sol.generateParenthesis(3);
  for (string s : result) {
    cout << s << endl; // ((())) (()()) (())() ()(()) ()()() (()) (()()) ((()))
  }

  result = sol.generateParenthesis(1);
  for (string s : result) {
    cout << s << endl; // ()
  }
}
// @lc code=end
