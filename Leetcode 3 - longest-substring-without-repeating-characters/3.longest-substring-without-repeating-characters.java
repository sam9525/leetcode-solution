/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {

  public int lengthOfLongestSubstring(String s) {
    int left = 0, right = 0, maxCount = 0;

    Set<Character> letters = new HashSet<>();

    while (right < s.length()) {
      if (letters.contains(s.charAt(right))) {
        letters.remove(s.charAt(left));
        left++;
      } else {
        letters.add(s.charAt(right));
        maxCount = Math.max(maxCount, right - left + 1);
        right++;
      }
    }

    return maxCount;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3
    System.out.println(solution.lengthOfLongestSubstring("bbbbb")); // 1
    System.out.println(solution.lengthOfLongestSubstring("pwwkew")); // 3
  }
}
// @lc code=end
