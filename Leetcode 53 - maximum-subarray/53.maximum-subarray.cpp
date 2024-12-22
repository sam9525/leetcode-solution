/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int maxSubArray(vector<int> &nums) {
    int count = nums[0];
    int maxEnding = nums[0];

    for (int i = 1; i < nums.size(); i++) {
      maxEnding = max(maxEnding + nums[i], nums[i]);
      count = max(maxEnding, count);
    }

    return count;
  }
};

int main() {
  Solution sol;

  vector<int> nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
  cout << sol.maxSubArray(nums1) << endl; // 6

  vector<int> nums2 = {5, 4, -1, 7, 8};
  cout << sol.maxSubArray(nums2) << endl; // 23

  vector<int> nums3 = {1};
  cout << sol.maxSubArray(nums3) << endl; // 1
}
// @lc code=end
