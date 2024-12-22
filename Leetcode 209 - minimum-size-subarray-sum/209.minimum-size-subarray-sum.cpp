/*
 * @lc app=leetcode id=209 lang=cpp
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int minSubArrayLen(int target, vector<int> &nums) {
    int left = 0, right = 0, minCount = INT_MAX, sum = 0;

    while (right < nums.size()) {
      sum += nums[right];
      while (sum >= target) {
        minCount = min(minCount, right - left + 1);
        sum -= nums[left];
        left++;
      }

      right++;
    }

    return minCount == INT_MAX ? 0 : minCount;
  }
};

int main() {
  Solution s;

  vector<int> nums = {2, 3, 1, 2, 4, 3};
  cout << s.minSubArrayLen(7, nums) << endl; // 2

  nums = {1, 4, 4};
  cout << s.minSubArrayLen(4, nums) << endl; // 1

  nums = {1, 1, 1, 1, 1, 1, 1, 1};
  cout << s.minSubArrayLen(11, nums) << endl; // 0
}
// @lc code=end
