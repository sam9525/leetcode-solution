/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

class Solution {

  public boolean isAnagram(String s, String t) {
    int[] countS = new int[26];
    for (char c : s.toCharArray()) {
      countS[((int) c) - 97] = countS[((int) c) - 97] + 1;
    }
    int[] countT = new int[26];
    for (char c : t.toCharArray()) {
      countT[((int) c) - 97] = countT[((int) c) - 97] + 1;
    }
    for (int i = 0; i < 26; i++) {
      if (countS[i] != countT[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.isAnagram("anagram", "nagaram")); // true
    System.out.println(solution.isAnagram("rat", "car")); // false
  }
}
// @lc code=end
