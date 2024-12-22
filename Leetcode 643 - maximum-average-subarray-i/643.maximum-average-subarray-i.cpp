/*
 * @lc app=leetcode id=643 lang=cpp
 *
 * [643] Maximum Average Subarray I
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  double findMaxAverage(vector<int> &nums, int k) {
    int left = 0, right = k - 1, count = 0, maxCount = INT_MIN;

    for (int i = left; i <= right; i++) {
      count += nums[i];
    }

    maxCount = max(count, maxCount);

    left++;
    right++;

    while (right <= nums.size() - 1) {
      count += nums[right];
      count -= nums[left - 1];

      maxCount = max(count, maxCount);

      left++;
      right++;
    }

    return double(maxCount) / k;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {1, 12, -5, -6, 50, 3};
  int k = 4;
  cout << sol.findMaxAverage(nums, k) << endl; // 12.75

  nums = {5};
  k = 1;
  cout << sol.findMaxAverage(nums, k) << endl; // 5.00000
}
// @lc code=end
