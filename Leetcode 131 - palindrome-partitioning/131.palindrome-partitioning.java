/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

  List<List<String>> result = new ArrayList<>();
  List<String> part = new ArrayList<>();

  public List<List<String>> partition(String s) {
    backtrack(0, s);
    return result;
  }

  private void backtrack(int start, String s) {
    if (start >= s.length()) {
      result.add(new ArrayList<>(part));
      return;
    }

    for (int end = start; end < s.length(); end++) {
      if (isPali(start, end, s)) {
        part.add(s.substring(start, end + 1));
        backtrack(end + 1, s);
        part.remove(part.size() - 1);
      }
    }
  }

  private boolean isPali(int start, int end, String s) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  // Time Complexity : O(n^2)
  // Space Complexity : O(n)

  public static void main(String[] args) {
    Solution sol = new Solution();

    String s = "aab";

    for (List<String> l : sol.partition(s)) {
      System.out.println(l);
    } // [[a, a, b], [aa, b]]

    s = "a";
    for (List<String> l : sol.partition(s)) {
      System.out.println(l);
    } // [[a]]
  }
}
// @lc code=end
