/*
 * @lc app=leetcode id=682 lang=cpp
 *
 * [682] Baseball Game
 */

// @lc code=start
#include <iostream>
#include <numeric>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int calPoints(vector<string> &operations) {
    vector<int> newOps;
    for (string c : operations) {
      if (c == "+") {
        newOps.push_back(newOps[newOps.size() - 1] + newOps[newOps.size() - 2]);
      } else if (c == "D") {
        newOps.push_back(newOps[newOps.size() - 1] * 2);
      } else if (c == "C") {
        newOps.pop_back();
      } else {
        newOps.push_back(stoi(c));
      }
    }
    return accumulate(newOps.begin(), newOps.end(), 0);
  }
};

int main() {
  Solution sol;
  vector<string> operations = {"5", "2", "C", "D", "+"};
  cout << sol.calPoints(operations) << endl; // 30

  operations = {"5", "-2", "4", "C", "D", "9", "+", "+"};
  cout << sol.calPoints(operations) << endl; // 27
}
// @lc code=end
