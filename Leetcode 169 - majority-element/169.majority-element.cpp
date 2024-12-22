/*
 * @lc app=leetcode id=169 lang=cpp
 *
 * [169] Majority Element
 */

// @lc code=start
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  int majorityElement(vector<int> &nums) {
    int count = 0;
    int candidate = 0;
    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    return candidate;
  }
};

int main() {
  Solution sol;

  vector<int> nums1 = {2, 2, 1, 1, 1, 2, 2}; // 2
  cout << sol.majorityElement(nums1) << endl;

  vector<int> nums2 = {3, 2, 3}; // 3
  cout << sol.majorityElement(nums2) << endl;
}
// @lc code=end
