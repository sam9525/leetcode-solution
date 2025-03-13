/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start

class Solution {

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;

    int[] letters = new int[26];

    // Count the letters in s1
    for (int i = 0; i < s1.length(); i++) {
      letters[s1.charAt(i) - 'a']++;
    }

    int left = 0, right = 0;

    // Slide the window
    while (right < s2.length()) {
      // Remove the letter from the counter
      letters[s2.charAt(right) - 'a']--;

      // If the window size is the same as s1, check if all letters are 0
      if (right - left + 1 == s1.length()) {
        boolean allZero = true;
        for (int count : letters) {
          if (count != 0) {
            allZero = false;
            break;
          }
        }

        // If all letters are 0, return true
        if (allZero) {
          return true;
        }

        // Add the letter back to the counter
        letters[s2.charAt(left) - 'a']++;
        left++;
      }

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
