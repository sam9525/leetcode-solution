/*
 * @lc app=leetcode id=739 lang=cpp
 *
 * [739] Daily Temperatures
 */

// @lc code=start
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> dailyTemperatures(vector<int> &temperatures) {
    stack<int> st;
    vector<int> wait(temperatures.size(), 0);

    for (int i = 0; i < temperatures.size(); i++) {
      while (!st.empty() && temperatures[i] > temperatures[st.top()]) {
        wait[st.top()] = i - st.top();
        st.pop();
      }
      st.push(i);
    }

    return wait;
  }
};

int main() {
  Solution sol;

  vector<int> temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
  vector<int> result = sol.dailyTemperatures(temperatures);
  for (int i = 0; i < result.size(); i++) {
    cout << result[i] << " ";
  }
  cout << endl; // 1 1 4 2 1 1 0 0

  temperatures = {30, 40, 50, 60};
  result = sol.dailyTemperatures(temperatures);
  for (int i = 0; i < result.size(); i++) {
    cout << result[i] << " ";
  }
  cout << endl; // 1 1 1 0

  temperatures = {30, 60, 90};
  result = sol.dailyTemperatures(temperatures);
  for (int i = 0; i < result.size(); i++) {
    cout << result[i] << " ";
  }
  cout << endl; // 1 1 0
}
// @lc code=end
