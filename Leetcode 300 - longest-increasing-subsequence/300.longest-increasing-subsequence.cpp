/*
 * @lc app=leetcode id=300 lang=cpp
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int lengthOfLIS(vector<int> &nums) {
    vector<int> dp(nums.size(), 1);
    dp[0] = 1;
    int maxLen = 1;

    for (int i = 1; i < nums.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = max(dp[i], dp[j] + 1);
        }
      }
      maxLen = max(maxLen, dp[i]);
    }

    return maxLen;
  }
};

int main() {
  Solution sol;

  vector<int> nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
  cout << sol.lengthOfLIS(nums1) << endl; // 4

  vector<int> nums2 = {0, 1, 0, 3, 2, 3};
  cout << sol.lengthOfLIS(nums2) << endl; // 4

  vector<int> nums3 = {7, 7, 7, 7, 7, 7, 7};
  cout << sol.lengthOfLIS(nums3) << endl; // 1
}
// @lc code=end
