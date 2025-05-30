/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start

import java.util.Arrays;

class Solution {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    // Bottom-up dynamic programming
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }

  // Time Complexity: O(n * amount)
  // Space Complexity: O(amount)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] coins = { 1, 2, 5 };
    int amount = 11;
    System.out.println(solution.coinChange(coins, amount)); // 3

    coins = new int[] { 2 };
    amount = 3;
    System.out.println(solution.coinChange(coins, amount)); // -1

    coins = new int[] { 1 };
    amount = 0;
    System.out.println(solution.coinChange(coins, amount)); // 0
  }
}
// @lc code=end
