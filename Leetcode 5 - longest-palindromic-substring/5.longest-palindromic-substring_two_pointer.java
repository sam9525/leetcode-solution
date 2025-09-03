/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {

  public String longestPalindrome(String s) {
    int resIdx = 0, resLen = 0;

    for (int i = 0; i < s.length(); i++) {
      // Odd length
      int l = i, r = i;
      while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        if (r - l + 1 > resLen) {
          resIdx = l;
          resLen = r - l + 1;
        }
        l--;
        r++;
      }

      // Even length
      l = i;
      r = i + 1;
      while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        if (r - l + 1 > resLen) {
          resIdx = l;
          resLen = r - l + 1;
        }
        l--;
        r++;
      }
    }

    return s.substring(resIdx, resLen + resIdx);
  }

  // Time Complexity : O(n^2)
  // Time Complexity : O(1)

  public static void main(String[] args) {
    String input = "babad";
    Solution solution = new Solution();

    String result = solution.longestPalindrome(input);
    System.out.println(result); // bab

    input = "cbbd";
    result = solution.longestPalindrome(input);
    System.out.println(result); // bb
  }
}
// @lc code=end
