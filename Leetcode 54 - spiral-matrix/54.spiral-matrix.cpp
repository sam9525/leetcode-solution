/*
 * @lc app=leetcode id=54 lang=cpp
 *
 * [54] Spiral Matrix
 */

// @lc code=start
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
  vector<int> spiralOrder(vector<vector<int>> &matrix) {
    int m = matrix.size();    // rows
    int n = matrix[0].size(); // cloumns

    vector<int> newNums;
    int top = 0, bottom = m - 1;
    int left = 0, right = n - 1;
    int total = m * n;
    int count = 0;

    while (count < total) {
      for (int i = left; i <= right; ++i) {
        newNums.push_back(matrix[top][i]);
        count++;
      }
      ++top;

      for (int i = top; i <= bottom; ++i) {
        newNums.push_back(matrix[i][right]);
        count++;
      }
      --right;

      if (top <= bottom) {
        for (int i = right; i >= left; --i) {
          newNums.push_back(matrix[bottom][i]);
          count++;
        }
        --bottom;
      }

      if (left <= right) {
        for (int i = bottom; i >= top; --i) {
          newNums.push_back(matrix[i][left]);
          count++;
        }
        ++left;
      }
    }

    return newNums;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> nums1 = {
      {1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // {1,2,3,6,9,8,7,4,5}
  vector<int> result1 = sol.spiralOrder(nums1);
  cout << "{";
  for (int i = 0; i < result1.size(); i++) {
    cout << result1[i];
    if (i != result1.size() - 1) {
      cout << ", ";
    }
  }
  cout << "}";
  cout << endl;

  vector<vector<int>> nums2 = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}}; //{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}
  vector<int> result2 = sol.spiralOrder(nums2);
  cout << "{";
  for (int i = 0; i < result2.size(); i++) {
    cout << result2[i];
    if (i != result2.size() - 1) {
      cout << ", ";
    }
  }
  cout << "}";

  cout << endl;
}
// @lc code=end
