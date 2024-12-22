/*
 * @lc app=leetcode id=198 lang=cpp
 *
 * [198] House Robber
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int rob(vector<int> &nums) {

    if (nums.empty())
      return 0;
    if (nums.size() == 1)
      return nums[0];

    vector<int> dp(nums.size());

    dp[0] = nums[0];
    dp[1] = max(nums[0], nums[1]);

    for (int i = 2; i < nums.size(); i++) {
      dp[i] = max(dp[i - 1], nums[i] + dp[i - 2]);
    }

    return dp[nums.size() - 1];
  }
};

int main() {
  Solution sol;
  vector<int> nums1 = {1, 2, 3, 1}; // 4
  cout << sol.rob(nums1) << endl;

  vector<int> nums2 = {2, 7, 9, 3, 1}; // 12
  cout << sol.rob(nums2) << endl;

  vector<int> nums3 = {0}; // 0
  cout << sol.rob(nums3) << endl;
}
// @lc code=end
