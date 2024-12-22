/*
 * @lc app=leetcode id=278 lang=cpp
 *
 * [278] First Bad Version
 */

// @lc code=start
// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

#include <iostream>

using namespace std;

class Solution {
public:
  int firstBadVersion(int n) {
    int low = 1, high = n;

    while (low < high) {
      int mid = low + (high - low) / 2;

      if (isBadVersion(mid)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }
};

int main() {
  Solution sol;

  cout << sol.firstBadVersion(5) << endl; // 4
}
// @lc code=end
