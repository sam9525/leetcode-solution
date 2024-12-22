/*
 * @lc app=leetcode id=11 lang=cpp
 *
 * [11] Container With Most Water
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int maxArea(vector<int> &height) {
    int maxSum = 0, left = 0, right = height.size() - 1;

    while (left < right) {
      int h = min(height[left], height[right]);
      maxSum = max(maxSum, h * (right - left));
      while (left < right && height[left] <= h)
        left++;
      while (left < right && height[right] <= h)
        right--;
    }

    return maxSum;
  }
};

int main() {
  Solution s;

  vector<int> height = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // 49
  cout << s.maxArea(height) << endl;

  vector<int> height2 = {1, 1}; // 1
  cout << s.maxArea(height2) << endl;

  vector<int> height3 = {2, 3, 10, 5, 7, 8, 9}; // 36
  cout << s.maxArea(height3) << endl;
}
// @lc code=end
