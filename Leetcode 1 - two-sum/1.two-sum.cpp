/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> twoSum(vector<int> &nums, int target) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<int, int> count;

    for (int i = 0; i < nums.size(); i++) {
      int check = target - nums[i];
      if (count.find(check) != count.end()) {
        return {count[check], i};
      }
      count[nums[i]] = i;
    }

    return {-1, -1};
  }
};

int main() {
  Solution sol;

  vector<int> nums1 = {2, 7, 11, 15};
  vector<int> result1 = sol.twoSum(nums1, 9); // {0, 1}
  cout << "{";
  for (int i = 0; i < result1.size(); i++) {
    cout << result1[i];
    if (i != result1.size() - 1) {
      cout << ", ";
    }
  }
  cout << "}";
  cout << endl;

  vector<int> nums2 = {3, 2, 4};
  vector<int> result2 = sol.twoSum(nums2, 6); // {1, 2}
  cout << "{";
  for (int i = 0; i < result2.size(); i++) {
    cout << result2[i];
    if (i != result2.size() - 1) {
      cout << ", ";
    }
  }
  cout << "}";
  cout << endl;

  vector<int> nums3 = {3, 3};
  vector<int> result3 = sol.twoSum(nums3, 6); // {0, 2}
  cout << "{";
  for (int i = 0; i < result3.size(); i++) {
    cout << result3[i];
    if (i != result3.size() - 1) {
      cout << ", ";
    }
  }
  cout << "}";
}
// @lc code=end
