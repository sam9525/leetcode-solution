/*
 * @lc app=leetcode id=150 lang=cpp
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int evalRPN(vector<string> &tokens) {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    stack<int> st;

    for (const string &token : tokens) {
      if (token == "+" || token == "-" || token == "*" || token == "/") {
        const int num2 = st.top();
        st.pop();
        const int num1 = st.top();
        st.pop();

        switch (token[0]) {
        case '+':
          st.push(num1 + num2);
          break;
        case '-':
          st.push(num1 - num2);
          break;
        case '*':
          st.push(num1 * num2);
          break;
        case '/':
          st.push(num1 / num2);
          break;
        }
      } else {
        st.push(stoi(token));
      }
    }

    return st.top();
  }
};

int main() {
  Solution sol;

  cout << sol.evalRPN({{"2", "1", "+", "3", "*"}}) << endl;
  cout << sol.evalRPN({{"4", "13", "5", "/", "+"}}) << endl;
  cout << sol.evalRPN({{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17",
                        "+", "5", "+"}})
       << endl;
}
// @lc code=end
