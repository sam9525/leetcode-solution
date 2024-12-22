/*
 * @lc app=leetcode id=875 lang=cpp
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int minEatingSpeed(vector<int> &piles, int h) {
    int low = 1, high = *max_element(piles.begin(), piles.end());

    while (low < high) {
      int mid = low + (high - low) / 2;

      if (canEat(piles, h, mid)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  bool canEat(vector<int> &piles, int h, int mid) {
    int hours = 0;
    for (int pile : piles) {
      hours += (pile + mid - 1) / mid;
    }

    return hours <= h;
  }
};

int main() {
  Solution sol;

  vector<int> piles = {3, 6, 7, 11};
  int h = 8;
  cout << sol.minEatingSpeed(piles, h) << endl; // 4

  piles = {30, 11, 23, 4, 20};
  h = 5;
  cout << sol.minEatingSpeed(piles, h) << endl; // 30

  piles = {30, 11, 23, 4, 20};
  h = 6;
  cout << sol.minEatingSpeed(piles, h) << endl; // 23
}
// @lc code=end
