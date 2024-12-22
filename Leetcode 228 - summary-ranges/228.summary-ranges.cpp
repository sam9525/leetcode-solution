/*
 * @lc app=leetcode id=228 lang=cpp
 *
 * [228] Summary Ranges
 */

// @lc code=start
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  vector<string> summaryRanges(vector<int> &nums) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<string> range;
    if (nums.empty())
      return range;
    int start = nums[0];

    for (int i = 1; i <= nums.size(); i++) {
      if (i == nums.size() || nums[i] != nums[i - 1] + 1) {
        if (start == nums[i - 1]) {
          range.push_back(to_string(start));
        } else {
          range.push_back(to_string(start) + "->" + to_string(nums[i - 1]));
        }
        if (i < nums.size()) {
          start = nums[i];
        }
      }
    }

    return range;
  }
};

int main() {
  Solution sol;
  vector<int> nums1 = {0, 1, 2, 4, 5, 7};
  vector<int> nums2 = {0, 2, 3, 4, 6, 8, 9};
  vector<string> result1 = sol.summaryRanges(nums1); // 0->2 4->5 7
  for (const string &range : result1) {
    cout << range << " ";
  }
  cout << "\n";

  vector<string> result2 = sol.summaryRanges(nums2); // 0 2->4 6 8->9
  for (const string &range : result2) {
    cout << range << " ";
  }
}
// @lc code=end
