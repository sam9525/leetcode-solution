/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start

class Solution {

  public int minEatingSpeed(int[] piles, int h) {
    int low = 1;
    int high = piles[0];
    for (int pile : piles) {
      high = Math.max(high, pile);
    }

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

  private boolean canEat(int[] piles, int h, int mid) {
    int minH = 0;

    for (int pile : piles) {
      minH += (pile + mid - 1) / mid;
      if (minH > h) return false;
    }

    return minH <= h;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] piles = { 3, 6, 7, 11 };
    int h = 8;
    System.out.println(solution.minEatingSpeed(piles, h)); // 4

    int[] piles2 = { 30, 11, 23, 4, 20 };
    int h2 = 5;
    System.out.println(solution.minEatingSpeed(piles2, h2)); // 30

    int[] piles3 = { 30, 11, 23, 4, 20 };
    int h3 = 6;
    System.out.println(solution.minEatingSpeed(piles3, h3)); // 23
  }
}
// @lc code=end
