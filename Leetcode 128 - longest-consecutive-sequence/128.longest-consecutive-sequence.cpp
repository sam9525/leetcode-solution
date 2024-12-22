/*
 * @lc app=leetcode id=128 lang=cpp
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int longestConsecutive(vector<int> &nums) {
    if (nums.size() == 0)
      return 0;
    if (nums.size() == 1)
      return 1;

    sort(nums.begin(), nums.end());

    int count = 1;
    int ans = 1;
    for (int i = 1; i < nums.size(); i++) {
      if (nums[i] == nums[i - 1] + 1) {
        count++;
      } else if (nums[i] != nums[i - 1]) {
        ans = max(ans, count);
        count = 1;
      }
    }
    ans = max(ans, count);
    return ans;
  }
};

int main() {
  Solution sol;

  vector<int> nums1 = {100, 4, 200, 1, 3, 2, 101, 102, 103, 104, 105}; // 6
  cout << sol.longestConsecutive(nums1);
  cout << endl;

  vector<int> nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}; // 9
  cout << sol.longestConsecutive(nums2);
}
// @lc code=end
