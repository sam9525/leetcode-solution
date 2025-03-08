/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {

  public int characterReplacement(String s, int k) {
    int left = 0, maxCount = 0, result = 0;

    Map<Character, Integer> letters = new HashMap<>();

    for (int right = 0; right < s.length(); right++) {
      letters.put(
        s.charAt(right),
        letters.getOrDefault(s.charAt(right), 0) + 1
      );
      maxCount = Math.max(maxCount, letters.get(s.charAt(right)));

      while ((right - left + 1) - maxCount > k) {
        letters.put(s.charAt(left), letters.get(s.charAt(left)) - 1);
        left++;
      }

      result = Math.max(result, right - left + 1);
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.characterReplacement("ABAB", 2)); // 4
    System.out.println(solution.characterReplacement("AABABBA", 1)); // 4
    System.out.println(solution.characterReplacement("AABBBBA", 2)); // 5
  }
}
// @lc code=end
