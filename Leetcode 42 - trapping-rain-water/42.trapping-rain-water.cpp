/*
 * @lc app=leetcode id=42 lang=cpp
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int trap(vector<int> &height) {
    int left = 0, right = height.size() - 1, count = 0;
    int maxLeft = 0, maxRight = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        maxLeft = max(maxLeft, height[left]);
        count += maxLeft - height[left];
        left++;
      } else {
        maxRight = max(maxRight, height[right]);
        count += maxRight - height[right];
        right--;
      }
    }

    return count;
  }
};

int main() {
  Solution sol;

  vector<int> height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6
  cout << sol.trap(height) << endl;

  vector<int> height2 = {4, 2, 0, 3, 2, 5}; // 9
  cout << sol.trap(height2) << endl;

  vector<int> height3 = {5, 4, 1, 2}; // 1
  cout << sol.trap(height3) << endl;
}
// @lc code=end
