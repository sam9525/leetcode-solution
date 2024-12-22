/*
 * @lc app=leetcode id=153 lang=cpp
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int findMin(vector<int> &nums) {
    int low = 0, high = nums.size() - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] >= nums[high]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return nums[low];
  }
};

int main() {
  Solution sol;

  vector<int> nums = {3, 4, 5, 1, 2};
  cout << sol.findMin(nums) << endl; // 1

  nums = {4, 5, 6, 7, 0, 1, 2};
  cout << sol.findMin(nums) << endl; // 0

  nums = {11, 13, 15, 17};
  cout << sol.findMin(nums) << endl; // 11
}
// @lc code=end
