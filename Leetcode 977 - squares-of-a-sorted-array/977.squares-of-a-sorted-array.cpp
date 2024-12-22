/*
 * @lc app=leetcode id=977 lang=cpp
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> sortedSquares(vector<int> &nums) {
    int n = nums.size();
    vector<int> result(n);
    int left = 0, right = n - 1;

    for (int i = n - 1; i >= 0; i--) {
      if (abs(nums[left]) > abs(nums[right])) {
        result[i] = nums[left] * nums[left];
        left++;
      } else {
        result[i] = nums[right] * nums[right];
        right--;
      }
    }

    return result;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {-4, -1, 0, 3, 10}; // 0 1 9 16 100
  vector<int> ans = sol.sortedSquares(nums);
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i] << " ";
  }
  cout << endl;

  vector<int> nums2 = {-7, -3, 2, 3, 11}; // 4 9 9 49 121
  vector<int> ans2 = sol.sortedSquares(nums2);
  for (int i = 0; i < ans2.size(); i++) {
    cout << ans2[i] << " ";
  }
  cout << endl;
}
// @lc code=end
