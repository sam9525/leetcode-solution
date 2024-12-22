/*
 * @lc app=leetcode id=1130 lang=cpp
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int mctFromLeafValues(vector<int> &arr) {}
};

int main() {
  Solution sol;

  vector<int> arr = {6, 2, 4};
  cout << sol.mctFromLeafValues(arr) << endl; // 32

  arr = {4, 11};
  cout << sol.mctFromLeafValues(arr) << endl; // 44
}
// @lc code=end
