/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start

import java.util.Arrays;
import java.util.List;

class Solution {

  public boolean wordBreak(String s, List<String> wordDict) {
    int len = s.length();
    boolean[] dp = new boolean[len + 1];
    dp[len] = true;

    // DP bottom-up
    for (int i = len; i >= 0; i--) {
      for (String word : wordDict) {
        if (
          (i + word.length() <= len) &&
          s.substring(i, i + word.length()).equals(word)
        ) {
          dp[i] = dp[i + word.length()];
        }
        if (dp[i]) {
          break;
        }
      }
    }

    return dp[0];
  }

  // Time Complexity: O(n ∗ m ∗ t)
  // Space Complexity: O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "leetcode";
    List<String> wordDict = Arrays.asList("leet", "code");
    System.out.println(solution.wordBreak(s, wordDict)); // true

    s = "applepenapple";
    wordDict = Arrays.asList("apple", "pen");
    System.out.println(solution.wordBreak(s, wordDict)); // true

    s = "catsandog";
    wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
    System.out.println(solution.wordBreak(s, wordDict)); // false
  }
}
// @lc code=end
