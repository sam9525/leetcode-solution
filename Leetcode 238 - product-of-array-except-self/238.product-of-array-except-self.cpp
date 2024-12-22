/*
 * @lc app=leetcode id=238 lang=cpp
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
  vector<int> productExceptSelf(vector<int> &nums) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n = nums.size();
    vector<int> newNums(n, 1);

    int leftSum = 1;
    for (int i = 0; i < n; i++) {
      newNums[i] *= leftSum;
      leftSum *= nums[i];
    }

    int rightSum = 1;
    for (int j = n - 1; j >= 0; j--) {
      newNums[j] *= rightSum;
      rightSum *= nums[j];
    }

    return newNums;
  }
};

int main() {
  Solution sol;
  vector<int> nums1 = {1, 2, 3, 4};
  vector<int> nums2 = {-1, 1, 0, -3, 3};
  vector<int> result1 = sol.productExceptSelf(nums1); // 24 24 24 24
  for (const int &num : result1) {
    cout << num << " ";
  }
  cout << "\n";
  vector<int> result2 = sol.productExceptSelf(nums2); // 0 0 9 0 0
  for (const int &num : result2) {
    cout << num << " ";
  }
}
// @lc code=end
