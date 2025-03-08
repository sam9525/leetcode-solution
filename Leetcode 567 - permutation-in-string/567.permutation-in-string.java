/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {

  public boolean checkInclusion(String s1, String s2) {
    // Put each letters from s1 in to a map
    Map<Character, Integer> s1Letters = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      s1Letters.put(s1.charAt(i), s1Letters.getOrDefault(s1.charAt(i), 0) + 1);
    }

    int left = 0, right = s1.length() - 1;

    while (right < s2.length()) {
      // Put each letters from s1 in to a map
      Map<Character, Integer> s2Letters = new HashMap<>();
      for (int i = left; i <= right; i++) {
        s2Letters.put(
          s2.charAt(i),
          s2Letters.getOrDefault(s2.charAt(i), 0) + 1
        );
      }

      // Compare two map
      if (s1Letters.equals(s2Letters)) {
        return true;
      }

      left++;
      right++;
    }

    return false;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.checkInclusion("ab", "eidbaooo")); // true
    System.out.println(solution.checkInclusion("ab", "eidboaoo")); // false
  }
}
// @lc code=end
