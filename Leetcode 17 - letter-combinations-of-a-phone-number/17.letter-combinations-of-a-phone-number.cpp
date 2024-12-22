/*
 * @lc app=leetcode id=17 lang=cpp
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  vector<string> letterCombinations(string digits) {
    if (digits.empty())
      return {};

    vector<string> result;
    string path;
    backtrack(digits, 0, result, path);
    return result;
  }

private:
  void backtrack(string &digits, int start, vector<string> &result,
                 string &path) {
    if (start == digits.size()) {
      result.push_back(path);
      return;
    }

    string letters = getLetters(digits[start]);
    for (char letter : letters) {
      path.push_back(letter);
      backtrack(digits, start + 1, result, path);
      path.pop_back();
    }
  }

  string getLetters(char digit) {
    switch (digit) {
    case '2':
      return "abc";
    case '3':
      return "def";
    case '4':
      return "ghi";
    case '5':
      return "jkl";
    case '6':
      return "mno";
    case '7':
      return "pqrs";
    case '8':
      return "tuv";
    case '9':
      return "wxyz";
    default:
      return "";
    }
    return "";
  }
};

int main() {
  Solution sol;

  string digits = "23";
  vector<string> result = sol.letterCombinations(digits);
  for (const auto &comb : result) {
    cout << comb << endl; // ad ae af bd be bf cd ce cf
  }

  digits = "2";
  result = sol.letterCombinations(digits);
  for (const auto &comb : result) {
    cout << comb << endl; // a b c
  }
}
// @lc code=end
