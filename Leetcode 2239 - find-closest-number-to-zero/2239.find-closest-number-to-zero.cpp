/*
 * @lc app=leetcode id=2239 lang=cpp
 *
 * [2239] Find Closest Number to Zero
 */

// @lc code=start
#include <cstdlib>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int findClosestNumber(vector<int> &nums) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int min = nums[0];
    for (int i = 1; i < nums.size(); i++) {
      if (abs(nums[i]) < abs(min) ||
          (abs(nums[i]) == abs(min) && nums[i] > min)) {
        min = nums[i];
      }
    }
    return min;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {-4, -2, 1, 4, 8};      // 1
  vector<int> nums2 = {2, -1, 1};            // 1
  vector<int> nums3 = {2, 1, 1, -1, 100000}; // 1
  cout << sol.findClosestNumber(nums) << "\n";
  cout << sol.findClosestNumber(nums2) << "\n";
  cout << sol.findClosestNumber(nums3);
}
// @lc code=end
