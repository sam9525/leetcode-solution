/*
 * @lc app=leetcode id=1004 lang=cpp
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int longestOnes(vector<int> &nums, int k) {
    int left = 0, zeroCount = 0, maxLength = 0;

    for (int right = 0; right < nums.size(); right++) {
      if (nums[right] == 0) {
        zeroCount++;
      }

      while (zeroCount > k) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++;
      }

      maxLength = max(maxLength, right - left + 1);
    }

    return maxLength;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
  int k = 2;
  cout << sol.longestOnes(nums, k) << endl; // 6

  nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
  k = 3;
  cout << sol.longestOnes(nums, k) << endl; // 10
}
// @lc code=end
