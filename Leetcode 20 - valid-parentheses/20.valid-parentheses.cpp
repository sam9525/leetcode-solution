/*
 * @lc app=leetcode id=20 lang=cpp
 *
 * [20] Valid Parentheses
 */

// @lc code=start
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
  bool isValid(string s) {
    stack<char> st;
    for (int i = 0; i < s.length(); i++) {
      if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
        st.push(s[i]);
      } else {
        if (st.empty()) {
          return false;
        }

        char top = st.top();
        st.pop();

        if ((s[i] == ')' && top != '(') || (s[i] == ']' && top != '[') ||
            (s[i] == '}' && top != '{')) {
          return false;
        }
      }
    }

    return st.empty();
  }
};

int main() {
  Solution sol;

  cout << boolalpha;
  cout << sol.isValid("()") << endl;     // true
  cout << sol.isValid("()[]{}") << endl; // true
  cout << sol.isValid("(]") << endl;     // false
}
// @lc code=end
