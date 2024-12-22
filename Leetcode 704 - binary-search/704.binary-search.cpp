/*
 * @lc app=leetcode id=704 lang=cpp
 *
 * [704] Binary Search
 */

// @lc code=start
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int search(vector<int> &nums, int target) {
    int low = 0;
    int high = nums.size() - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {1, 2, 3, 4, 5};
  int target = 3;
  cout << sol.search(nums, target) << endl; // 2

  vector<int> nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  int target2 = 10;
  cout << sol.search(nums2, target2) << endl; // 9
}
// @lc code=end
