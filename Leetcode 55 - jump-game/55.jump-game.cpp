/*
 * @lc app=leetcode id=55 lang=cpp
 *
 * [55] Jump Game
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  bool canJump(vector<int> &nums) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int len = nums.size();
    int target = len - 1;

    for (int i = len - 1; i >= 0; i--) {
      if (nums[i] + i >= target) {
        target = i;
      }
    }

    return target == 0;
  }
};

int main() {
  Solution sol;

  cout << boolalpha;
  vector<int> nums1 = {2, 3, 1, 1, 4};
  cout << sol.canJump(nums1) << endl; // true

  vector<int> nums2 = {3, 2, 1, 0, 4};
  cout << sol.canJump(nums2) << endl; // false

  vector<int> nums3 = {0};
  cout << sol.canJump(nums3) << endl; // true
}
// @lc code=end
