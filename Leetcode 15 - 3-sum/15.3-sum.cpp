/*
 * @lc app=leetcode id=15 lang=cpp
 *
 * [15] 3Sum
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> threeSum(vector<int> &nums) {
    sort(nums.begin(), nums.end());

    vector<vector<int>> ans;

    for (int i = 0; i < nums.size() - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;

      int left = i + 1, right = nums.size() - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
          ans.push_back({nums[i], nums[left], nums[right]});
          while (left < right && nums[left] == nums[left + 1])
            left++;
          while (left < right && nums[right] == nums[right - 1])
            right--;
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return ans;
  }
};

int main() {
  Solution s;
  // {-4, -1, -1, 0, 1, 2}
  vector<int> nums = {-1, 0, 1, 2, -1, -4}; // [[-1, -1, 2], [-1, 0, 1]]
  auto res = s.threeSum(nums);
  for (auto &v : res) {
    cout << "[";
    for (auto &i : v) {
      cout << i << " ";
    }
    cout << "]" << endl;
  }

  vector<int> nums2 = {0, 0, 0}; // [[0, 0, 0]]
  auto res2 = s.threeSum(nums2);
  for (auto &v : res2) {
    cout << "[";
    for (auto &i : v) {
      cout << i << " ";
    }
    cout << "]" << endl;
  }

  vector<int> nums3 = {0, 1, 1}; // []
  auto res3 = s.threeSum(nums3);
  for (auto &v : res3) {
    cout << "[";
    for (auto &i : v) {
      cout << i << " ";
    }
    cout << "]" << endl;
  }
}
// @lc code=end
