/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {

  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
      // Skip non-alphanumeric characters from left
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }

      // Skip non-alphanumeric characters from right
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }

      // Compare characters ignoring case
      if (
        Character.toLowerCase(s.charAt(left)) !=
        Character.toLowerCase(s.charAt(right))
      ) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
    System.out.println(sol.isPalindrome("race a car")); // false
    System.out.println(sol.isPalindrome(" ")); // true
  }
}
// @lc code=end
