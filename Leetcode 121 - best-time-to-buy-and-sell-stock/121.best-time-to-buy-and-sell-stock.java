/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {

  public int maxProfit(int[] prices) {
    int left = 0, right = 1;
    int maxProfit = 0;

    while (right < prices.length) {
      int curProfit = prices[right] - prices[left];

      if (curProfit > 0) {
        maxProfit = Math.max(maxProfit, curProfit);
      } else {
        left = right;
      }
      right++;
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] prices = { 7, 1, 5, 3, 6, 4 };
    System.out.println(solution.maxProfit(prices)); // 5

    int[] prices2 = { 7, 6, 4, 3, 1 };
    System.out.println(solution.maxProfit(prices2)); // 0

    int[] prices3 = { 2, 1, 4 };
    System.out.println(solution.maxProfit(prices3)); // 3
  }
}
// @lc code=end
