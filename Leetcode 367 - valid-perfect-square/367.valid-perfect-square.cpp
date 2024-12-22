/*
 * @lc app=leetcode id=367 lang=cpp
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
#include <iostream>

using namespace std;

class Solution {
public:
  bool isPerfectSquare(int num) {
    int low = 1, high = num;

    while (low < high) {
      int mid = low + (high - low) / 2;

      if (mid * mid == num) {
        return true;
      } else if (mid * mid < num) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return false;
  }
};

int main() {
  Solution sol;

  cout << boolalpha << endl;
  cout << sol.isPerfectSquare(16) << endl; // true;
  cout << sol.isPerfectSquare(14) << endl; // false;
}
// @lc code=end
