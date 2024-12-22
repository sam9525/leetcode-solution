/*
 * @lc app=leetcode id=48 lang=cpp
 *
 * [48] Rotate Image
 */

// @lc code=start
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
  void rotate(vector<vector<int>> &matrix) {
    vector<vector<int>> newArr;
    int row = matrix.size() - 1;
    int col = row;

    for (int j = 0; j <= row; j++) {
      vector<int> temp;
      for (int i = row; i >= 0; i--) {
        temp.push_back(matrix[i][j]);
      }
      newArr.push_back(temp);
      cout << "{";
      for (int i = 0; i < temp.size(); i++) {
        cout << temp[i];
        if (i != temp.size() - 1) {
          cout << ", ";
        }
      }
      cout << "}";
    }
    // int n = matrix.size();

    // for (int i = 0; i < n; i++) {
    //   for (int j = i + 1; j < n; j++) {
    //     swap(matrix[i][j], matrix[j][i]);
    //   }
    // }

    // for (int i = 0; i < n; ++i) {
    //   reverse(matrix[i].begin(), matrix[i].end());
    // }
  }
};

int main() {
  Solution sol;
  vector<vector<int>> arr1 = {
      {1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // {{7,4,1},{8,5,2},{9,6,3}}
  sol.rotate(arr1);
  cout << endl;

  vector<vector<int>> arr2 = {
      {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
  // {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}}
  sol.rotate(arr2);
  cout << endl;
}
// @lc code=end
