/*
 * @lc app=leetcode id=217 lang=cpp
 *
 * [217] Contains Duplicate
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  bool containsDuplicate(vector<int> &nums) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<int, int> count;
    for (int c : nums) {
      count[c]++;
      if (count[c] >= 2) {
        return true;
      }
    }

    // std::sort(nums.begin(), nums.end());

    // for (int i = 1; i < nums.size(); ++i) {
    //   if (nums[i] == nums[i - 1]) {
    //     return true;
    //   }
    // }
    // return false;

    return false;
  }
};

int main() {
  Solution sol;

  cout << boolalpha;

  vector<int> nums1 = {1, 2, 3, 4}; // false
  cout << sol.containsDuplicate(nums1);
  cout << endl;

  vector<int> nums2 = {1, 2, 3, 1};
  cout << sol.containsDuplicate(nums2); // true
  cout << endl;

  vector<int> nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}; // true
  cout << sol.containsDuplicate(nums3);
  cout << endl;
}
// @lc code=end
