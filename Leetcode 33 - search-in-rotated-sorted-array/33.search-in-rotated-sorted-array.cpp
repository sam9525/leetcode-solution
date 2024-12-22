/*
 * @lc app=leetcode id=33 lang=cpp
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int search(vector<int> &nums, int target) {
    int low = 0, high = nums.size() - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] == target)
        return mid;

      // check if left half is sorted
      if (nums[low] <= nums[mid]) {
        // check if target is in left half
        if (target >= nums[low] && target < nums[mid])
          high = mid - 1;
        else
          low = mid + 1;
      }
      // check if right half is sorted
      else {
        // check if target is in right half
        if (target > nums[mid] && target <= nums[high])
          low = mid + 1;
        else
          high = mid - 1;
      }
    }

    return -1;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {4, 5, 6, 7, 0, 1, 2};
  int target = 0;
  cout << sol.search(nums, target) << endl; // 4

  nums = {4, 5, 6, 7, 0, 1, 2};
  target = 3;
  cout << sol.search(nums, target) << endl; // -1
}
// @lc code=end
